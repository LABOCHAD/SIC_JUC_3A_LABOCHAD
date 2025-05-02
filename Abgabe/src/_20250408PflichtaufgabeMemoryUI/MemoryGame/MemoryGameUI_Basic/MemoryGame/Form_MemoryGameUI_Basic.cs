using Microsoft.VisualBasic;
using Timer = System.Windows.Forms.Timer;

namespace MemoryGame
{
    public partial class Form_MemoryGameUI_Basic : Form
    {

        //basic parameters for the game
        static int _cardCount;
        int size;
        static List<string> _cardTags = new List<string>(); //former icons
        int score = 200;
        int seconds = 0;

        //size via _cardTags.Count()
        int moves = 0;
        bool[] bools_revealedCorrectly;
        string[] strings_lastTwoSymbols = new string[2];
        Button[] buttons_lastTwoButtonsPressed = new Button[2];
        string username;


        public Form_MemoryGameUI_Basic()
        {
            //These four are needed for the first start
            Prepare();
            InitializeComponent();


            StartNewGame();
        }
        int GetCardNumberSuggestionByUser()
        {
            int _suggestion;
            while (true) //AI suggested loop including content :)
            {
                string input = Interaction.InputBox("Enter how many cards you want to play with (4 - 64):", "Card Count", "16"); // Default to 16

                if (string.IsNullOrWhiteSpace(input))
                {
                    _suggestion = 16; // Default suggestion if the user leaves it blank
                    break;
                }

                if (int.TryParse(input, out _suggestion) && _suggestion >= 4 && _suggestion <= 64)
                {
                    break; // Valid input
                }
                else
                {
                    MessageBox.Show("Invalid input. Please enter an even number from 4 to 64", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            return _suggestion;
        }
        void Prepare()
        {
            //Make user been asked later by box or drop down list first
            int _suggestion = GetCardNumberSuggestionByUser();

            //find next best available square
            size = (int)Math.Sqrt(_suggestion);// Initial integer part of the square root
            int lowerSquare = size * size;
            int upperSquare = (size + 1) * (size + 1);
            int upperDiff = upperSquare - _suggestion;
            int lowerDiff = Math.Abs(lowerSquare - _suggestion); // Use Math.Abs to get the positive difference
            if (upperDiff < lowerDiff) size++; // Take the upper square if it's closer

            _cardCount = size * size;

            if (size % 2 != 0) _cardCount--; //avoiding last odd card



            //Feedback to user of game building
            if (_cardCount != _suggestion)
                MessageBox.Show($"Field will be {_cardCount} ({size}*{size}) cards.\n");

            CreateNumericCardTags();
            LoadCardImages();
        }

        void CreateNumericCardTags() //why Tags? I want to use pics later
        {
            if (_cardTags.Count != 0) _cardTags.Clear(); //flush if still filled from game before
            for (int i = 0; i < (_cardCount / 2); i++)
            {//add symbol twice to pool for each pair
                _cardTags.Add(i.ToString());
                _cardTags.Add(i.ToString());
            }
        }
        private void AssignCardsToButtons() //encountered index issues by removing, so took this approach (AI helped)
        {
            Random random = new Random();

            // 1. Shuffle the _cardTags list
            _cardTags = _cardTags.OrderBy(x => random.Next()).ToList();

            // 2. Assign the shuffled tags to the buttons sequentially
            int i = 0;
            foreach (Control control in tableLayoutPanel_Cards.Controls)
            {
                Button button = control as Button;
                if (button != null && i < _cardTags.Count)
                {
                    button.Tag = _cardTags[i]; // Assign the image key to the Tag
                    i++;
                }
            }
        }

        bool isWaiting = false;
        private void AllButtons_Click(object sender, EventArgs e)
        {
            if (isWaiting) return;
            Button pressedButton = sender as Button;

            if (pressedButton != null && pressedButton.Enabled && !bools_revealedCorrectly[Convert.ToInt32(pressedButton.Name.Split("button")[1])])
            {

                pressedButton.Enabled = false;
                string imageKey = pressedButton.Tag.ToString();
                if (_cardImages.ContainsKey(imageKey))
                {
                    pressedButton.BackgroundImage = _cardImages[imageKey];
                }
                Evaluate(pressedButton);
            }

        }

        private void Evaluate(Button pressedButton)
        {
            strings_lastTwoSymbols[moves] = pressedButton.Tag.ToString(); // Use Tag for comparison
            buttons_lastTwoButtonsPressed[moves] = pressedButton;
            moves++;


            if (moves == 2)
            {
                if (strings_lastTwoSymbols[0] == strings_lastTwoSymbols[1]) // Match!
                {
                    foreach (Button b in buttons_lastTwoButtonsPressed)
                    {
                        int buttonNumber = Convert.ToInt32(b.Name.Split("button")[1]);
                        bools_revealedCorrectly[buttonNumber] = true;
                        // Keep them enabled but visually revealed
                    }
                    if (IsWon())
                    {
                        timerGame.Stop();
                        MessageBox.Show($"Congrats. You win! 🥳\nFinal score: {score}\nTime needed: {seconds} s");
                    }
                }
                else // No match
                {
                    isWaiting = true;
                    timerGame.Stop(); // Stop the game timer during the delay
                    Timer missMatchTimer = new Timer();
                    missMatchTimer.Interval = 1000;
                    missMatchTimer.Tick += (object? sender, EventArgs e) =>
                    {
                        foreach (Button b in buttons_lastTwoButtonsPressed)
                        {
                            if (!bools_revealedCorrectly[Convert.ToInt32(b.Name.Split("button")[1])]) // Only re-hide if not a correct match
                            {
                                b.BackgroundImage = _cardBackImage; // Revert to background
                                b.Enabled = true;
                            }
                        }
                        timerGame.Start(); // Restart the game timer
                        missMatchTimer.Stop();
                        isWaiting = false;
                    };
                    missMatchTimer.Start();
                    
                }
                moves = 0; // Reset moves for the next pair
            }
        }

        private bool IsWon()
        {
            foreach (bool b in bools_revealedCorrectly)
            {
                if (!b) return false;
            }
            return true;
        }

        private void timerGame_Tick(object sender, EventArgs e)
        {
            score -= 2;
            if (score < 0)
            {
                MessageBox.Show("Unfortunately you did not make it in the given time. Game will be restarted", "Time is up");
                StartNewGame();
            }
            seconds++;
            timerLabel.Text = $"Time: {seconds}s";
            scoreLabel.Text = $"Score: {score}s";

        }

        private void restartButton_Click(object sender, EventArgs e)
        {
            timerGame.Stop();
            Prepare();
            StartNewGame();
        }

        private Dictionary<string, Image> _cardImages = new Dictionary<string, Image>();
        private Image _cardBackImage;

        private string _imageFolderPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "..", "..", "..", "Card_Images"); // Adjust ".." levels as needed

        //gotten from AI
        private void LoadCardImages()
        {
            _cardImages.Clear();
            for (int i = 0; i < (_cardCount / 2); i++)
            {
                string imageFilename = $"card ({i}).ico"; // Your naming convention
                string imagePath = Path.Combine(Application.StartupPath, _imageFolderPath, imageFilename);

                try
                {
                    Image image = Image.FromFile(imagePath);
                    _cardImages[i.ToString()] = image; // Use the numerical tag as the key
                }
                catch (FileNotFoundException)
                {
                    MessageBox.Show($"Error: Image file not found: {imagePath}");
                    return; // Or handle the error as needed
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Error loading image {imageFilename}: {ex.Message}");
                    return;
                }
            }

            // Load the background image
            string backgroundFilename = "background.ico";
            string backgroundPath = Path.Combine(Application.StartupPath, _imageFolderPath, backgroundFilename); // aims at bin/debug/.etc...

            try
            {
                _cardBackImage = Image.FromFile(backgroundPath);
            }
            catch (FileNotFoundException)
            {
                MessageBox.Show($"Error: Background image file not found: {backgroundPath}");
                return;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error loading background image: {ex.Message}");
                return;
            }
        }
    }
}

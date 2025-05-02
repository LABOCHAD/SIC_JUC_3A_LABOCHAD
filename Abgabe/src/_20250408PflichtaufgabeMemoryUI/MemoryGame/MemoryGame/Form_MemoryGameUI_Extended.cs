using Microsoft.VisualBasic;

namespace MemoryGame
{
    public partial class Form_MemoryGameUI_Extended : Form
    {
        static readonly Color color_hiddenAndBackground = Color.CornflowerBlue;
        static readonly Color color_revealedSingleCardText = Color.Black;
        static readonly Color color_revealedCorrectlyText = Color.Green;
        static readonly Color color_revealedWrongText = Color.Red;

        //I moved the list and filling method from designer to here.
        //in here seems to be the pendant to the controller in Java.
        static List<string> icons = new List<string>()
        {
        "!", "!", "N", "N", ",", ",", "k", "k",
        "b", "b", "v", "v", "w", "w", "z", "z"
        };
        //size via icons.Count()

        int moves = 0;
        bool[] bools_revealedCorrectly = new bool[icons.Count];
        string[] strings_lastTwoSymbols = new string[2];
        Button[] buttons_lastTwoButtonsPressed = new Button[2];
        private bool canClick = true; // Flag to track if clicking is allowed --> AI suggestion
        string username;

        public Form_MemoryGameUI_Extended()
        {
            this.username = Interaction.InputBox("Please type in your Name:", "Welcome", "Unknown User");
            InitializeComponent();
            FillButtonsWithIcons();
        }

        private void FillButtonsWithIcons()
        {
            foreach (Control controll in tableLayoutPanel_Cards.Controls)
            {
                Random random = new Random();
                Button button = controll as Button; //buttons 1-16
                if (button != null)
                {
                    int index = random.Next(icons.Count);
                    string s = icons.ElementAt(index); //shift by alt + arrow
                    //https://stackoverflow.com/questions/15456845/getting-a-list-item-by-index
                    button.Text = s;
                    icons.RemoveAt(index); //remove after been assigned to a button card
                }
            }
        }

        //from here I had help by AI with Task async and await, before it also worked but not recoloring the buttons' texts.
        private async void AllButtons_Click(object sender, EventArgs e)
        {
            Button pressedButton = sender as Button; //instead of recasting like this: ((Button)sender)

            //Conditions when A click must be ignored
            {
                // Prevent clicking if evaluation is in progress --> AI
                if (!canClick) return;

                //ignore clicks on buttons already revealed correctly (own idea :) )
                if (bools_revealedCorrectly[Convert.ToInt32(pressedButton.Name.Split("button")[1]) - 1]) return;

                //avoid same move twice per turn, cannot be done via enabled = false, because disabled buttons' text turn to gray
                if (pressedButton == buttons_lastTwoButtonsPressed[0]) return;
                //SOLVED - After this happened AND  match was false AND in the next turn this button is clicked, then won't react. Why?
            }


            pressedButton.ForeColor = color_revealedSingleCardText;

            canClick = false; // Disable further clicks --> AI
            //must await Evaluation, which might must await delay depending on first or second card revealed
            await Evaluate(pressedButton);
            canClick = true; // Enable clicks after evaluation --> AI
        }

        private async Task Evaluate(Button pressedButton)
        {
            int wait = 1000;
            strings_lastTwoSymbols[moves] = pressedButton.Text; //getLastButtonClickedContent
            buttons_lastTwoButtonsPressed[moves] = pressedButton;

            if (moves == 0)
            {
                moves++; //let player make another reveal
                return;
            }
            else
            {
                if (strings_lastTwoSymbols[0] == strings_lastTwoSymbols[1]) //when match is achieved
                {
                    foreach (Button b in buttons_lastTwoButtonsPressed)
                    {
                        b.ForeColor = color_revealedCorrectlyText;
                        int buttonNumber = Convert.ToInt32(b.Name.Split("button")[1]);
                        bools_revealedCorrectly[buttonNumber - 1] = true;
                    }
                    if (IsWon()) MessageBox.Show("Congrats. You win! 🥳");

                }
                else //if no match
                {
                    foreach (Button b in buttons_lastTwoButtonsPressed)
                    {
                        b.ForeColor = color_revealedWrongText;
                    }

                    await Task.Delay(wait);

                    foreach (Button b in buttons_lastTwoButtonsPressed)
                    {
                        b.ForeColor = color_hiddenAndBackground;
                    }
                }
                moves = 0;
                // Reset the array for the next turn --> Thanks Gemini :D
                buttons_lastTwoButtonsPressed = new Button[2];
                //https://g.co/gemini/share/fb27e98b785d
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
    }
}

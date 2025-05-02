using System.Data;
using System.Linq.Expressions;
using System.Text;

class MemoryGame
{
    //Tasks (Ctrl + ^, T) can be TODO, HACK, UNDONE

    // play board with cards 
    private char[] cards;
    private char[] cardSymbols = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
    private bool[] revealedCards; //nice way of putting it :)

    //DONE Builds up the play board
    public MemoryGame()
    {
        //DONE Step 1: Create the deck using the CreateDeck() method
        cards = CreateDeck();

        //DONE Step 2: Shuffle the deck using the given method
        cards = ShuffleCards(cards);

        //DONE Step 3: Initialize the revealedCards array to track the state of each card
        revealedCards = new bool[16]; //standard is false
    }

    // DONE Method to create the deck of cards
    // This method creates an array of 16 cards, with 8 pairs of cards (2 of each symbol A-H)
    // The deck should be created by filling the first 8 positions with symbols from cardSymbols
    // Then, duplicate each symbol and place them in the last 8 positions --> simply copy symbols two times in a row (shuffles later)
    private char[] CreateDeck()
    {
        //https://www.telerik.com/blogs/copying-and-cloning-arrays-in-c
        cards = new char[16];
        cardSymbols.CopyTo(cards, 0);
        cardSymbols.CopyTo(cards, 8);
        return cards;
    }

    // ALREADY DONE LOL ?! Method to shuffle the deck
    // This method takes the array of cards and shuffles them randomly using a random number generator
    // The randomization should be done by rearranging the cards in a random order
    // Return the shuffled array of cards
    private char[] ShuffleCards(char[] cards)
    {
        Random rng = new Random();
        return cards.OrderBy(x => rng.Next()).ToArray();
    }


    // DONE Method to display the current game board
    // This method clears the console and displays the current state of the game board
    // Each revealed card is displayed with its symbol, and each unrevealed card is displayed as a star (*)
    // The board should be shown with 4 cards per row
    public void DisplayBoard(bool highlightMatch = false, bool isMatch = false, int index1 = 0,
        int index2 = 0) //highlight hit with green, fail with red
    {
        // Step 1: Clear the console to prepare for displaying the updated board (use Console.Clear())
        // Continue
        Console.Clear();
        Console.WriteLine("Game state");
        for (var i = 0; i < cards.Length; i++)
        {
            if (highlightMatch && (i == index1 || i == index2))
                Console.ForegroundColor = isMatch ? ConsoleColor.Green : ConsoleColor.Red;

            Console.Write((revealedCards[i]) ? cards[i] : "*"); //if card is revealed, show its char, else a star
            Console.ResetColor(); //also done, if color has not been changed

            Console.Write(((i + 1) % 4 == 0) ? "\n" : "  ");
        }

        Console.WriteLine();
    }

    private void printAdditionalHelpGrid()
    {
        for (int i = 1; i <= 16; i++)
        {
            Console.Write(i);
            if (i % 4 == 0)
                Console.Write("\n");
            else
                Console.Write(i < 10 ? "  " : " ");
        }

        Console.WriteLine();
    }


    // DONE Method to check if the game has been won
    // This method checks if all the cards have been revealed (i.e., all entries in the revealedCards array are true)
    // The game is considered won if all cards are revealed
    public bool IsGameWon()
    {
        foreach (var revealed in revealedCards)
        {
            if (!revealed) return false; //at least one card has not been revealed yet, game goes on
        }

        return true;
    }

    private bool IsAnIndexInvalid(int index1, int index2) //my own outsourcing if index validation
    {
        bool firstTooLow = index1 < 0;
        bool firstTooHigh = index1 > 15;
        bool secondTooLow = index2 < 0;
        bool secondTooHigh = index2 > 15;

        if (firstTooLow) WriteAnError("Index one it too low (min 1)"); //++index1, ...
        else if (firstTooHigh) WriteAnError("Index one is too high (max 16)");

        if (secondTooLow) WriteAnError("Index two it too low (min 1)");
        else if (secondTooHigh) WriteAnError("Index two is too high (max 16)");

        return (firstTooLow || firstTooHigh || secondTooLow || secondTooHigh);
    }

    // DONE Method to reveal two cards
    // DONE This method checks whether two chosen cards are valid to reveal (i.e., not already revealed and within valid range)
    // DONE It then compares the cards at the two indices. If they match, the game continues; if they don't match, they are hidden again
    // DONE Before hiding give the player time to memorize. Use System.Threading.Thread.Sleep(2000);
    //  DONE  After revealing the cards, the board should be displayed to show the current state of the game
    public bool RevealCards(int index1, int index2)
    {
        // Step 1: Validate indices
        if (IsAnIndexInvalid(index1, index2)) return false; //no direct return, because true must not end method here

        // Step 2: Check if the cards are already revealed
        if (revealedCards[index1]) WriteAnError("First Card has already been revealed. Choose another!");
        if (revealedCards[index2]) WriteAnError("Second Card has already been revealed. Choose another!");
        if (revealedCards[index1] || revealedCards[index2]) return false;

        // Step 3: Reveal the cards at the specified indices by setting the corresponding entries in revealedCards to true
        revealedCards[index1] = true;
        revealedCards[index2] = true;

        if (cards[index1] == cards[index2])
        {
            DisplayBoard(true, true, index1, index2);
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Hurray. It's a match.");
            Console.ResetColor();
        }

        else
        {
            DisplayBoard(true, false, index1, index2);
            WriteAnError("Doh! That was a miss. Try again.");
            revealedCards[index1] = false;
            revealedCards[index2] = false;
        }

        // Step 4: Display the board with the newly revealed cards
        System.Threading.Thread.Sleep(2000);
        DisplayBoard(); //no override was needed, thanks to default param vals, lol
        printAdditionalHelpGrid();
        return (cards[index1] == cards[index2]); //what was that intended to be needed for? :D
    }

    // DONE Method to play the game
    // This method controls the flow of the game. It repeatedly asks the player to choose two cards to reveal until all cards are matched
    // It tracks the number of turns, displays the board after each attempt, and announces whether the player's guess was correct
    public void PlayGame()
    {
        Console.WriteLine("Welcome to memory game.\n");
        while (!IsGameWon())
        {
            try
            {
                Console.Write("Type in a number between 1 and 16 for the first card to reveal: ");
                int first = Convert.ToByte(Console.ReadLine());
                Console.Write("Type in a number between 1 and 16 for the second card to reveal: ");
                int second = Convert.ToByte(Console.ReadLine());
                if (first == second) WriteAnError("You must choose two different cards to reveal.");
                else RevealCards(--first, --second); //for matching with index 0-15
            }
            catch (FormatException e)
            {
                WriteAnError(e.Message);
            }
        }
        Console.ForegroundColor = ConsoleColor.Green;
        Console.WriteLine("Congrats. You win!");
        Console.ResetColor();
        Console.WriteLine("Thanks for playing. Bye...");
    }

    private static void WriteAnError(string message)
    {
        https: //stackoverflow.com/questions/10532796/setting-the-color-for-console-error-writes
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine(message);
        Console.ResetColor();
    }
}

class StartGame
{
    static void Main(string[] args)
    {
        MemoryGame game = new MemoryGame();
        game.PlayGame();
    }
}
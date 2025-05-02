using CSharpWiederholung.BroadcasterApp;
using CSharpWiederholung.Models;

namespace CSharpWiederholung.BroadcasterApp
{
    internal class Broadcaster
    {
        private List<Show> shows = new List<Show>();

        internal bool AskForShow()
        {
            //Type of Show (Subclass)
            Console.WriteLine("Type in the show's type:");
            string _showType = Console.ReadLine();
            if (!String.IsNullOrWhiteSpace(_showType))
                _showType = _showType.Trim().ToLower(); //make sure first letter case won't lead to a mismatch
            else return false; //why does an empty input, only returned pressed on input not cause false?


            //Title of show
            Console.WriteLine("Type in the show's title:");
            string _title = Console.ReadLine();


            //get duration by user using exception handling
            int _duration = 0;
            Console.WriteLine("Type in the show's duration (in minutes):");
            try
            {
                //_duration = int.Parse(Console.ReadLine()); //IDE suggestion
                string _input = Console.ReadLine();
                _duration = Convert.ToInt32(_input);
            }
            catch (FormatException e)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Duration value could not be set! " + e.Message);
                Console.ResetColor();
                return false;
            }

            //genre was not mentioned in subtask four. Omitted intentionally or forgotten?
            Console.WriteLine("Type in the show's genre:");
            string _genre = Console.ReadLine();


            return CreateShowAndAddToList(_showType, _title, _duration, _genre);
        }

        private bool CreateShowAndAddToList(string _showType, string _title, int duration, string _genre)
        {
            switch (_showType)
            {
                case "series":
                {
                    shows.Add(new Series(_title, duration, _genre));
                    break;
                }
                case "movie":
                {
                    shows.Add(new Movie(_title, duration, _genre));
                    break;
                }
                case "documentary":
                {
                    shows.Add(new Documentary(_title, duration, _genre));
                    break;
                }
                default:
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("The show type seems to be invalid. Try again.");
                    Console.ResetColor();
                    return false;
                }
            }

            return true;
        }

        internal void DisplayShowsList()
        {
            Console.WriteLine("\nAlright, these are the shows in the list:");
            foreach (var show in shows)
            {
                show.ShowInfo();
            }
        }
    }
}

class Launcher
{
    public static void Main()
    {
        Broadcaster bc = new Broadcaster();

        for (int i = 0; i < 3; i++)
        {
            Console.WriteLine($"Recording show number {i + 1} to the list:");
            if (!bc.AskForShow())
            {
                Console.WriteLine("Seems like an error occured while adding a show to the list. Let's try this again.");
                i--;
            }
        }

        bc.DisplayShowsList();
    }
}
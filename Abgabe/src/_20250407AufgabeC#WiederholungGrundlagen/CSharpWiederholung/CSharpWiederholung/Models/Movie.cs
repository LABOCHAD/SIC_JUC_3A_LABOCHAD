namespace CSharpWiederholung.Models;

public class Movie(string _title = "T.I.M.", int _duration = 101, string _genre = "Science Fiction") : Show(_title, _duration, _genre)
{
    public override void ShowInfo()
    {
        Console.WriteLine($"Movie: {Title}, {Duration} minutes, Genre(s): {Genre}");
    }
}
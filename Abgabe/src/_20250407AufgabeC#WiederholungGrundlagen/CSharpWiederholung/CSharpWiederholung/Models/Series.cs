namespace CSharpWiederholung.Models;

public class Series(string _title = "Supernatural", int _duration = 42, string _genre = "Drama, Mystery, Horror") : Show(_title, _duration, _genre)
{
    public override void ShowInfo()
    {
        Console.WriteLine($"Series: {Title}, {Duration} minutes, Genre(s): {Genre}");
    }
}
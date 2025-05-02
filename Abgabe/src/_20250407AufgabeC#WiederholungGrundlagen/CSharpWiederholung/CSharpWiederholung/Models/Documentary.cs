namespace CSharpWiederholung.Models;

public class Documentary(string _title = "A brief history of Time", int _duration = 80, string _genre = "Biography") : Show(_title, _duration, _genre)
{
    public override void ShowInfo()
    {
        Console.WriteLine($"Documentary: {Title}, {Duration} minutes, Genre(s): {Genre}");
    }
}
namespace CSharpWiederholung.Models;

public class Show
{
    public string Title { get; set; }
    public int Duration { get; set; }

    public string Genre { get; } //getter only

    public Show(string _title = "Unknown", int _duration = 0, string _genre = "General")
    {
        this.Title = _title;
        this.Duration = _duration;
        this.Genre = _genre;
    }

    public virtual void ShowInfo()
    { // use more comfortable text blocks by """ """ instead of \n, \t and " " + ...
        Console.WriteLine($"""
                           
                           Show Information:
                           _________________
                           Title:       {this.Title}
                           Duration:    {this.Duration}
                           Genre:       {this.Genre}
                           
                           """);
    }
}
namespace WindowsForms_Library.model
{
    //copied from Java version
    public class Book
    {
        //how do we encapsulate among namespaces properly? 
        //Please consider explaining this more detailed in near future ;)
        public int BookId { get; set; }
        public string Title { get; set; }
        public int AuthorId { get; set; }
        public int PublicationYear { get; set; }
        public string Genre { get; set; }
        public string Isbn { get; set; }

        //Before database has been accessed
        public Book(string title, int authorId, int publicationYear, string genre, string isbn)
        {
            this.Title = title;
            this.AuthorId = authorId;
            this.PublicationYear = publicationYear;
            this.Genre = genre;
            this.Isbn = isbn;
        }

        //After database has been accessed
        public Book(int bookId, string title, int authorId, int publicationYear, string genre, string isbn) : this(title, authorId, publicationYear, genre, isbn)
        {
            this.BookId = bookId;
        }


        public override string? ToString()
        {
            return "Book{" +
                   "bookId=" + BookId +
                   ", Title='" + Title + '\'' +
                   ", AuthorId=" + AuthorId +
                   ", PublicationYear=" + PublicationYear +
                   ", Genre='" + Genre + '\'' +
                   ", Isbn='" + Isbn + '\'' +
                   '}';
        }
    }
}

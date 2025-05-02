package schichtenmodellLibrary.modell;

public final class Book {

    private int bookId;
    private String title;
    private int authorId;
    private int publicationYear;
    private String genre;
    private String isbn;

    public Book(int bookId, String title, int authorId, int publicationYear, String genre, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.isbn = isbn;
    }

    // in case I want to do anything with the books, only immutable for now.

    public void read() {
        System.out.println("The book " + title + " is being read...");
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
               "bookId=" + bookId +
               ", title='" + title + '\'' +
               ", authorId=" + authorId +
               ", publicationYear=" + publicationYear +
               ", genre='" + genre + '\'' +
               ", isbn='" + isbn + '\'' +
               '}';
    }
}

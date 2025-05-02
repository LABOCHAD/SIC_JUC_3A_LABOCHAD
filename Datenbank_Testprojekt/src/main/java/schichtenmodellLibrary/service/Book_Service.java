package schichtenmodellLibrary.service;

import schichtenmodellLibrary.dao.BookDAOImpl;
import schichtenmodellLibrary.modell.Book;

import java.util.Scanner;

public class Book_Service {
    //hier fehlt leider noch einiges
    private static BookDAOImpl bookDAO = new BookDAOImpl(); //linking class that accesses the actual database

    //TestMain
/*    public static void main(String[] args) {
        //Test the whole thing
        Book_Service service = new Book_Service();

        service.showAllBooks();

        System.out.println(service.findBookById(1).getTitle());

        System.out.println("Type in a title to search a book by: ");
        String title = new Scanner(System.in).nextLine();
        Book book = service.findBookByName(title);
        System.out.println(book != null ? book.getTitle() : "not found");

        System.out.println("Deleting book 1984 with id 2:");
        service.deleteBookById(2); // 2	2	1984	1949	Dystopie	9780451524935

        System.out.println("Rename 'Harry Potter and the Philosopher's Stone' by user chosen name:" );
        service.updateBookById(1); // 1	1	Harry Potter and the Philosopher's Stone	1997	Fantasy	9780747532699

        service.showAllBooks();
    }*/

    //DONE findBookById
    public Book findBookById(int id) {
        return bookDAO.getBookById(id);
    }

    //DONE finBookByName
    public Book findBookByName(String name) {
        return bookDAO.getBookByName(name);
    }

    //DONE deleteABookByID
    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }

    //DONE UpdateABooksTitle
    public void updateBookById(int id) {
        bookDAO.updateBookById(id);
    }

    public void showAllBooks() {
        //https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
        final String separationLines = "---------------------------------------------------------------------------------------------------------";
        System.out.println("\nAll Books:"); //could be done with joining author, but this will do for now
        //book_id(7) author_id(9) title(40) year(4) genre(13) isbn(13)
        System.out.println(separationLines);
        System.out.printf("| %-7s | %-9s | %-40s | %-4s | %-13s | %-13s |%n", "Book_ID", "Author_ID", "Title", "Year", "Genre", "ISBN");
        for (Book b : bookDAO.getAllBooks()) {
            System.out.println(separationLines);
            System.out.printf("| %-7s | %-9s | %-40s | %-4s | %-13s | %-13s |%n",
                    b.getBookId(), b.getAuthorId(), b.getTitle(), b.getPublicationYear(), b.getGenre(), b.getIsbn());
        }
        System.out.println(separationLines+"\n");
        //TODO replace author_id with join of author('s name) if time permits
    }


}
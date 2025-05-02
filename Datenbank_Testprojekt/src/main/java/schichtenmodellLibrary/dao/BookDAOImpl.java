package schichtenmodellLibrary.dao;

import auxilliary.DBCreatorLibrary;
import schichtenmodellLibrary.modell.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAOImpl implements BookDAO {

    private Connection connection;

    public BookDAOImpl(){
        connection = DBCreatorLibrary.getConnection();
    }
    //again it seems like result sets must not be passed but must be used directly within the method they are being filled in.
    private Book createBookByResultSet(ResultSet resultSet) throws SQLException {

            int book_id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            int authorId = resultSet.getInt("author_id");
            int publicationYear = resultSet.getInt("publication_year");
            String genre = resultSet.getString("genre");
            String isbn = resultSet.getString("isbn");

            return new Book(book_id, title, authorId, publicationYear, genre, isbn);
    }

    @Override
    public Book getBookById(int book_id) {
        Book book = null;
        final String sql = "SELECT * FROM books WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                book = createBookByResultSet(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public Book getBookByName(String title) {
        Book book = null;
        final String sql = "SELECT * FROM books WHERE title = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                book = createBookByResultSet(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void deleteBookById(int book_id) {
        final String sql = "DELETE FROM books WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected"); //if 0, it didn't work
            //connection.commit(); // in case I want to submit the changes finally to the database
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO if time is left make changeable more than title
    @Override
    public void updateBookById(int book_id) {
        final String sql = "update books set title = ? where book_id = ?"; //1 original title
        try(Scanner scanner = new Scanner(System.in)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("How do you want to rename the book?: ");
            String newTitle = scanner.nextLine();
            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, book_id);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " rows affected"); //if 0, it didn't work
            //connection.commit(); // in case I want to submit the changes finally to the database
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //optional extra
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();

        final String sql = "SELECT * FROM books";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = createBookByResultSet(resultSet);
                books.add(book);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}

package _20250325VorlesungArchitektur.schichtenmodelllibrary.dao;


import _20250325VorlesungArchitektur.schichtenmodelllibrary.model.Book;

import java.sql.*;

public class BookDAOImpl implements BookDAO {

    private Connection connection;

    public BookDAOImpl() {
        /*try {
            //connection = DriverManager("", "", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }

    @Override
    public Book getBookById(int id) {
        Book b = null;
        final String sql = "SELECT * FROM Books WHERE id = ? ";
        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, id);

            ResultSet rs = p.executeQuery();
            int book_id = rs.getInt("book_id");
            //...
            //b = new Book(book_id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return b;
    }


    @Override
    public Book getBookByName(String name) {
        return null;
    }

    @Override
    public void deleteBookById(int id) {

    }

    @Override
    public void updateBookById(int id) {

    }
}

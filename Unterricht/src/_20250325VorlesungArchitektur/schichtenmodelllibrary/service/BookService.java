package _20250325VorlesungArchitektur.schichtenmodelllibrary.service;

import _20250325VorlesungArchitektur.schichtenmodelllibrary.dao.BookDAO;
import _20250325VorlesungArchitektur.schichtenmodelllibrary.dao.BookDAOImpl;
import _20250325VorlesungArchitektur.schichtenmodelllibrary.model.Book;

public class BookService {

    private BookDAO bookDAO;

    public BookService(){
        bookDAO = new BookDAOImpl();
    }

    public Book findBookByID(int id){
        return bookDAO.getBookById(id);
    }

    public static void main(String[] args) {
        BookService b = new BookService();
        b.findBookByID(1);
    }
}

package _20250325VorlesungArchitektur.schichtenmodelllibrary.dao;


import _20250325VorlesungArchitektur.schichtenmodelllibrary.model.Book;

public interface BookDAO {

    Book getBookById(int id);
    Book getBookByName(String name);

    void deleteBookById(int id);
    void updateBookById(int id);

}

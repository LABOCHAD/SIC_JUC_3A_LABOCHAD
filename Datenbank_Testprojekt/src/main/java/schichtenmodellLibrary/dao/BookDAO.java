package schichtenmodellLibrary.dao;

import schichtenmodellLibrary.modell.Book;

public interface BookDAO {

    Book getBookById(int id);
    Book getBookByName(String name);

    void deleteBookById(int id);
    void updateBookById(int id);

}


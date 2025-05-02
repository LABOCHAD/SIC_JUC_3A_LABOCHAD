package schichtenmodellLibrary.controller;

import schichtenmodellLibrary.modell.Book;
import schichtenmodellLibrary.service.Book_Service;
import schichtenmodellLibrary.view.ViewLibrary;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControllerLibrary {
    private ViewLibrary viewLibrary;
    private Book_Service bookService;


    ControllerLibrary() {
        this.viewLibrary = new ViewLibrary();
        this.bookService = new Book_Service();

        //Book by Name Button
        this.viewLibrary.addActionListenerToBookSearchButton(e -> {
            Book book = bookService.findBookByName(viewLibrary.getTextField_BookName().getText());
            System.out.println(book);
        });

        //Show All Books Button
        this.viewLibrary.addActionListenerToShowAllBooksButton(e -> {bookService.showAllBooks();});
    }

    public static void main(String[] args) {
        ControllerLibrary controllerLibrary = new ControllerLibrary();
    }



}

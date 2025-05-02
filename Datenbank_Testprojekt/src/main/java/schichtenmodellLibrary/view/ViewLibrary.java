package schichtenmodellLibrary.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewLibrary extends JFrame {

    private ModuleLayer.Controller controller;
    private Container container;

    //Book search Frame Components
    private JFrame frame_BookSearch = new JFrame();
    private JLabel label_BookName;
    private JTextField textField_BookName;
    private JButton button_SearchBook;
    private JButton button_ShowAllBooks;


    public ViewLibrary() {
        container = getContentPane();

        //Main Frame - Books Search
        initialize_frame_BookSearch();

        frame_BookSearch.setVisible(true);
    }

    private void initialize_frame_BookSearch() {
        this.frame_BookSearch = new JFrame();
        frame_BookSearch.setLayout(new GridLayout(2, 2)); //Label, TextField, Button
        frame_BookSearch.setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame. not needed, we extend from it
        frame_BookSearch.setTitle("ViewLibrary");
        frame_BookSearch.setSize(320, 240);
        frame_BookSearch.setLocationRelativeTo(null);
        frame_BookSearch.setVisible(true);

        //Components
        this.label_BookName = new JLabel("Type in Book Name");
        label_BookName.setHorizontalAlignment(SwingConstants.CENTER);
        this.textField_BookName = new JTextField();
        this.button_SearchBook = new JButton("Search");
        this.button_ShowAllBooks = new JButton("Show All Books");

        //Add components to Frame
        frame_BookSearch.add(label_BookName);
        frame_BookSearch.add(textField_BookName);
        frame_BookSearch.add(button_SearchBook);
        frame_BookSearch.add(button_ShowAllBooks);
    }

    public void addActionListenerToBookSearchButton(ActionListener actionListener) {
        button_SearchBook.addActionListener(actionListener);
    }

    public void addActionListenerToShowAllBooksButton(ActionListener actionListener) {
        button_ShowAllBooks.addActionListener(actionListener);
    }

    public JTextField getTextField_BookName() {
        return textField_BookName;
    }
}

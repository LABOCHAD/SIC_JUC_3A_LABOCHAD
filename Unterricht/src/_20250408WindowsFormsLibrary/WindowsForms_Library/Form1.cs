using WindowsForms_Library.dao;
using WindowsForms_Library.model;
using WindowsForms_Library.singleton;

namespace WindowsForms_Library
{
    public partial class Form_Main : Form
    {
        BookDAO _bookDAO = new BookDAO();
        Book _currentBook;
        public Form_Main()
        {
            InitializeComponent();
            //try connecting to database
            DBConnectorLibrary.GetConnection();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button_saveBook_Click(object sender, EventArgs e)
        {
            //DONE make sure no field is empty
            if (IsAnyFieldsEmpty()) { MessageBox.Show("Please fill out all book data fields.", "Missing data"); return; }

            try
            {   //get all book properties from the GUI
                string _Title = textBox_title.Text;
                int _Author_Id = Convert.ToInt32(textBox_author.Text);
                int _PublicationYear = Convert.ToInt32(textBox_publicationYear.Text); //could also be checked in database (1900 - 9999)
                string _Genre = textBox_genre.Text;
                string _ISBN = textBox_ISBN.Text; //should be checked for 13 numbers with or without - delimiter in database
                _bookDAO.AddBook(new Book(_Title, _Author_Id, _PublicationYear, _Genre, _ISBN));
            }
            catch (FormatException ex)
            {
                MessageBox.Show("Please check if Author ID and publication year are numbers only.", "Invalid numeric input");
            }

        }

        bool IsAnyFieldsEmpty()
        {
            foreach (Control c in tableLayoutPanel_bookData.Controls)
            {
                //https://stackoverflow.com/questions/3561202/check-if-instance-is-of-a-type
                //c.GetType().Name.Equals("Label") //if (c.GetType() == typeof(Button)) //c is TextBox
                if (c != null && c is TextBox tb) //pattern variable casting
                {
                    if (String.IsNullOrWhiteSpace(tb.Text)) return true; //must use String class statically to check for emptiness
                }
            }
            return false;
        }

        private void button_searchForABook_Click(object sender, EventArgs e) //TODO make this method search for book by all data later if no id is given (adapt BookDAO)
        {
            int id = 0;
            if (String.IsNullOrEmpty(textBox_book_id.Text))
                try
                {
                    id = Convert.ToInt32(textBox_book_id.Text);
                    Book? found = _bookDAO.getBookById(id);
                    if (found != null) { _currentBook = found; MessageBox.Show(found.ToString(), "Book found"); }
                }
                catch (FormatException ex)
                {
                    MessageBox.Show("Please check if Book id is numeric.", "Invalid numeric input");
                }
            else
            {
                MessageBox.Show("Please fill in book id", "Missing Data");
            }
        }

        private void button_CountBooks_Click(object sender, EventArgs e)
        {
            int count = _bookDAO.CountBooks();
            MessageBox.Show($"Found number of {count} book in database.", "Book counted.");
        }
    }
}

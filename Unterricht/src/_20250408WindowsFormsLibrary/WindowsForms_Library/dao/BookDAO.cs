using MySql.Data.MySqlClient;
using WindowsForms_Library.model;
using WindowsForms_Library.singleton;

namespace WindowsForms_Library.dao
{

    /*
        DONE Erzeuge eine DAO-Klasse für Book
        DONE Schreibe eine Methode, die ein Buch anhand der Id holt
        DONE Füge eine Methode hinzu, um ein Buch in die Datenbank zu speichern
        UNDONE Verknüpfe das gestern erzeugte Fenster, sodass beim Klicken des Buttons ein Buch in die Datenbank gespeichert wird
        --Orientiert euch an der Klasse von Java
    */

    internal class BookDAO
    {
        private MySqlConnection _connection = DBConnectorLibrary.GetConnection();

        public int CountBooks()
        {
            string sql = "select count(*) from books"; //result will have count(*) column title

            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, _connection);
                return Convert.ToInt32(cmd.ExecuteScalar());
            }
            catch (MySqlException e)
            {
                MessageBox.Show("Could not get book count from database.\n" + e.Message, "An SQL-Error occured.");
            }

            return -1;
        }

        public Book? getBookById(int id) //in example page 16 it says get all books with a list
        {
            string sql = "select * from books where book_id = @id"; //can also be ? once

            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, _connection);
                using MySqlDataReader reader = cmd.ExecuteReader(); //using: opened here, closed after try
                //must be used as resource because they must not more than one reader open at a time
                return CreateBookByMySqlDataReader(reader);
            }
            catch (MySqlException e)
            {
                MessageBox.Show("Could not get book from database.\n" + e.Message, "An SQL-Error occured.");
            }

            return null;

        }

        private Book? CreateBookByMySqlDataReader(MySqlDataReader reader)
        {
            if (reader.Read())
            { //cannot be in-line created without properties, with if instead of while, because just one book expected

                int _Book_Id = reader.GetInt32("book_id");
                string _Title = reader.GetString("title");
                int _Author_Id = reader.GetInt32("author_id");
                int _PublicationYear = reader.GetInt32("publication_year");
                string _Genre = reader.GetString("genre");
                string _ISBN = reader.GetString("isbn");
                return new Book(_Book_Id, _Title, _Author_Id, _PublicationYear, _Genre, _ISBN);
            }
            return null;
        }

        public void AddBook(Book book)
        {
            //consider getting author id by name with preselect and than start this here
            string sql = "insert into Books(title, author_id, publication_year, genre, isbn)" +
                " values (@title, @author_id, @publication_year, @genre, @isbn);";
            try
            {
                MySqlCommand cmd = new MySqlCommand(sql, _connection);
                cmd.Parameters.AddWithValue("@title", book.Title);
                cmd.Parameters.AddWithValue("@author_id", book.AuthorId);
                cmd.Parameters.AddWithValue("@publication_year", book.PublicationYear);
                cmd.Parameters.AddWithValue("@genre", book.Genre);
                cmd.Parameters.AddWithValue("@isbn", book.Isbn);
                cmd.ExecuteNonQuery(); //for non selects;

            }
            catch (MySqlException e)
            {
                MessageBox.Show("Could not add book to database.\n" + e.Message, "An SQL-Error occured.");
            }
        }
    }
}

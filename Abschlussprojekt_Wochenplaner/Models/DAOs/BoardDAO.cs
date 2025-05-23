using System.Reflection.PortableExecutable;
using System.Windows;
using Abschlussprojekt_Wochenplaner.Models.Entities;
using Abschlussprojekt_Wochenplaner.Models.Services;
using MySql.Data.MySqlClient;

namespace Abschlussprojekt_Wochenplaner.Models.DAOs
{
    class BoardDAO
    {
        public static readonly MySqlConnection _connection = new DatabaseConnector().Connection; //public for making it closable from outside when closing application
        //                MessageBox.Show(ex.Message, "Database related error!", MessageBoxButton.OK, MessageBoxImage.Error);



        //-- string constants for SQL statements --
        //Creation
        const string SQL_CreateBoardByFieldsAndGetNewId = "insert into Boards (year, week, fromDate, toDate) values (@year, @week, @fromDate, @toDate); SELECT LAST_INSERT_ID()"; //cmd.ExecuteScalar()
        //Reading
        const string SQL_GetBoardByID = "select * from boards where Board_id = @id;";
        const string SQL_GetAllBoards = "select * from boards;";
        const string SQL_GetLastBoardId = "select max(Board_id) from boards;";

        //-- CREATE -- //only creating (saving) here
        public Board CreateBoard(int year, int week, DateOnly? fromDate = null, DateOnly? toDate = null)
        {
            Board board;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_CreateBoardByFieldsAndGetNewId, _connection);
                cmd.Parameters.AddWithValue("@year", year);
                cmd.Parameters.AddWithValue("@week", week);
                cmd.Parameters.AddWithValue("@fromDate", fromDate == null ? (object)DBNull.Value : fromDate.Value.ToString("yyyy-MM-dd", System.Globalization.CultureInfo.InvariantCulture));
                cmd.Parameters.AddWithValue("@toDate", toDate == null ? (object)DBNull.Value : toDate.Value.ToString("yyyy-MM-dd", System.Globalization.CultureInfo.InvariantCulture));
                int id = Convert.ToInt32(cmd.ExecuteScalar()); //would have been ExcecuteNonQuery(); (all but no select or aggregation) if not asked for new ID
                board = new Board(id, year, week, fromDate, toDate); ; //might be more secure than opening a setter for id in entity
            }
            catch (MySqlException) { throw; }

            return board;
        }

        //-- READ --
        public Board GetBoardById(int id)
        {
            Board board;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetBoardByID, _connection);
                cmd.Parameters.AddWithValue("@id", id);
                using MySqlDataReader reader = cmd.ExecuteReader(); //keeps open, when building methods adds up on stack

                if (reader.Read()) //not while, because only on expected
                    board = BuildBoardFromReader(reader);
                else throw new Exception($"Board with id {id} could not be found"); //board should not just be null
            }
            catch (MySqlException) { throw; }

            return board;
        }

        public List<Board> GetAllBoards()
        {
            List<Board> boards = new List<Board>();
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetAllBoards, _connection);
                using MySqlDataReader reader = cmd.ExecuteReader(); //keeps open, when building methods adds up on stack

                while (reader.Read()) //not while, because only on expected
                    boards.Add(BuildBoardFromReader(reader));
            }
            catch (MySqlException) { throw; }


            return boards;
        }

        public int GetLastBoardId()
        {
            int last = 0; //effectively count if no removed in between

            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetLastBoardId, _connection);
                last = Convert.ToInt32(cmd.ExecuteScalar());
            }
            catch (MySqlException) { throw; }

            return last;
        }

        private Board BuildBoardFromReader(MySqlDataReader reader) //just an auxiliary outsourcing
        {
            //This method is invoked by another method that's having a try catch block for SQL stuff, so another in here won't be needed
            int id = reader.GetInt32("Board_id");
            int year = reader.GetInt32("year");
            int week = reader.GetInt32("week");

            DateOnly? fromDate = null;
            DateOnly? toDate = null;

            if (!reader.IsDBNull(reader.GetOrdinal("fromDate"))) //isDB null wants the column index, so GetOrdinal (from 0 on -> idx 3)
            {
                DateTime dateTimeFromDb = reader.GetDateTime("fromDate");
                fromDate = DateOnly.FromDateTime(dateTimeFromDb);

            }

            if (!reader.IsDBNull(reader.GetOrdinal("toDate"))) //(idx 4)
            {
                DateTime dateTimeFromDb = reader.GetDateTime("toDate");
                toDate = DateOnly.FromDateTime(dateTimeFromDb);
            }

            return new Board(id, year, week, fromDate, toDate);
        }

        //-- UPDATE --
        //not intended now but later


        //-- DELETE --
        //not intended now but later
    }
}
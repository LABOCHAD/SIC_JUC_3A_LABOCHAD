using Abschlussprojekt_Wochenplaner.Models.Entities;
using Abschlussprojekt_Wochenplaner.Models.Services;
using Abschlussprojekt_Wochenplaner.Utilities;
using MySql.Data.MySqlClient;
using System.Windows;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task;

namespace Abschlussprojekt_Wochenplaner.Models.DAOs
{
    class TodoDAO
    {
        public static readonly MySqlConnection _connection = new DatabaseConnector().Connection; //public for making it closable from outside when closing application

        //-- string constants for SQL statements --
        //Creation
        const string SQL_CreateTodoByFieldsAndGetNewId =
            "insert into Todos (Task_id, Board_id, weekdayNumber, slotNumber, state, instanceNote) " +
            "values (@Task_id, @Board_id, @weekdayNumber, @slotNumber, @state, @instanceNote); SELECT LAST_INSERT_ID()";

        //Reading
        const string SQL_GetTodoByID = "select * from Todos where Todo_id = @id;";
        const string SQL_GetAllTodosOfABoard = "select * from Todos where Board_id = @Board_id;";
        const string SQL_CheckIfSlotIsNotEmpty = "select * from Todos where Board_id = @Board_id AND weekdayNumber = @weekdayNumber AND slotNumber = @slotNumber;";

        //Updating
        const string SQL_UpdateTodoTaskID = "update Todos set Task_id = @Task_id where Todo_id = @Todo_id;";
        //changing board not intended now but later
        const string SQL_UpdateTodoWeekdayNumber = "update Todos set weekdayNumber = @weekdayNumber where TODO_id = @TODO_id;";
        const string SQL_UpdateTodoSlotNumber = "update Todos set slotNumber = @slotNumber where TODO_id = @TODO_id;";
        const string SQL_UpdateTodoState = "update Todos set state = @state where TODO_id = @TODO_id;";
        //updating instanceNote not intended now but later

        //Deleting
        const string SQL_DeleteTodoById = "delete from Todos where TODO_id = @Todo_id;";


        //-- CREATE -- //only creating (saving) here
        public Todo CreateTodo(Task task, Board board, int weekdayNumber, int slotNumber, string state, string? instanceNote)
        {
            Todo Todo;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_CreateTodoByFieldsAndGetNewId, _connection);

                cmd.Parameters.AddWithValue("@Task_id", task.TaskId); //pass FK id
                cmd.Parameters.AddWithValue("@Board_id", board.BoardId); //pass FK id

                cmd.Parameters.AddWithValue("@weekdayNumber", weekdayNumber);
                cmd.Parameters.AddWithValue("@slotNumber", slotNumber);
                
                cmd.Parameters.AddWithValue("@state", state);
                cmd.Parameters.AddWithValue("@instanceNote", (instanceNote == null) ? DBNull.Value : instanceNote);
                int id = Convert.ToInt32(cmd.ExecuteScalar());

                Todo = new Todo(id, task, board, weekdayNumber, slotNumber, state, instanceNote);
            }
            catch (MySqlException) { throw; }

            return Todo;
        }

        //-- READ --
        public Todo GetTodoById(int id)
        {
            Todo Todo;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetTodoByID, _connection);
                cmd.Parameters.AddWithValue("@id", id);
                using MySqlDataReader reader = cmd.ExecuteReader(); //keeps open, when building methods adds up on stack

                if (reader.Read()) //not while, because only on expected
                    Todo = BuildTodoFromReader(reader);
                else throw new Exception($"Todo with id {id} could not be found"); //Todo should not just be null
            }
            catch (MySqlException) { throw; }

            return Todo;
        }

        public bool CheckIfSlotIsNotEmpty(int board_id, int weekdayNumber, int slotNumber)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_CheckIfSlotIsNotEmpty, _connection);
                cmd.Parameters.AddWithValue("@board_id", board_id);
                cmd.Parameters.AddWithValue("@weekdayNumber", weekdayNumber);
                cmd.Parameters.AddWithValue("@slotNumber", slotNumber);
                using MySqlDataReader reader = cmd.ExecuteReader(); //keeps open, when building methods adds up on stack
                //Not only Scalar (count) in case more information will be needed of which todo is already in this slot
                return (bool)reader.Read(); //if reader has no row, then there is no todo in this slot of that weekday
            }
            catch (MySqlException) { throw; }
        }

        public List<Todo> GetAllTodosOfABoard(int _Board_id)
        {
            List<Todo> Todos = new List<Todo>();
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetAllTodosOfABoard, _connection);
                cmd.Parameters.AddWithValue("@Board_id", _Board_id);
                using MySqlDataReader reader = cmd.ExecuteReader(); //opened

                while (reader.Read())
                    ExceptionHandler.Handle(() => Todos.Add(BuildTodoFromReader(reader))); //avoid full abort when one todo is corrupted
            }
            catch (MySqlException) { throw; }

            return Todos;
        }

        private Todo BuildTodoFromReader(MySqlDataReader reader) //just an auxiliary outsourcing
        {
            int Todo_id = reader.GetInt32("Todo_id");

            int Task_id = reader.GetInt32("Task_id");
            
            Task task = new TaskDAO().GetTaskById(Task_id); //called with already open reader

            int Board_id = reader.GetInt32("Board_id");
            Board board = new BoardDAO().GetBoardById(Board_id); //called with already open reader
            
            int weekdayNumber = reader.GetInt32("weekdayNumber");
            int slotNumber = reader.GetInt32("slotNumber");

            string state = reader.GetString("state");

            string? instanceNote = null;
            if (!reader.IsDBNull(reader.GetOrdinal("instanceNote"))) instanceNote = reader.GetString("instanceNote");

            return new Todo(Todo_id, task, board, weekdayNumber, slotNumber, state, instanceNote);
        }


        //-- UPDATE --
        public void UpdateTodoTask(int _Todo_id, int _Task_id)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_UpdateTodoTaskID, _connection);
                cmd.Parameters.AddWithValue("@Task_id", _Task_id);
                cmd.Parameters.AddWithValue("@Todo_id", _Todo_id);
                int affectedRows = cmd.ExecuteNonQuery();

                //this here should never occur
                if (affectedRows != 1) throw new Exception($"{affectedRows} affected on updating todo (ID:{_Todo_id}) with Task_id {_Task_id}");

            }
            catch (MySqlException) { throw; }

        }

        public void UpdateTodoWeekdayNumber(int _Todo_id, int weekdayNumber)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_UpdateTodoWeekdayNumber, _connection);
                cmd.Parameters.AddWithValue("@weekdayNumber", weekdayNumber);
                cmd.Parameters.AddWithValue("@Todo_id", _Todo_id);
                int affectedRows = cmd.ExecuteNonQuery();

                //this here should never occur
                if (affectedRows != 1) throw new Exception($"{affectedRows} affected on updating todo (ID:{_Todo_id}) with weekdayNumber {weekdayNumber}");

            }
            catch (MySqlException) { throw; }
        }

        public void UpdateTodoSlotNumber(int _Todo_id, int slotNumber)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_UpdateTodoSlotNumber, _connection);
                cmd.Parameters.AddWithValue("@slotNumber", slotNumber);
                cmd.Parameters.AddWithValue("@Todo_id", _Todo_id);
                int affectedRows = cmd.ExecuteNonQuery();

                //this here should never occur
                if (affectedRows != 1) throw new Exception($"{affectedRows} affected on updating todo (ID:{_Todo_id}) with slotNumner {slotNumber}");

            }
            catch (MySqlException) { throw; }
        }

        public void UpdateTodoState(int _Todo_id, string state) //not null!!!
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_UpdateTodoState, _connection);
                cmd.Parameters.AddWithValue("@state", state);
                cmd.Parameters.AddWithValue("@Todo_id", _Todo_id);
                int affectedRows = cmd.ExecuteNonQuery();

                //this here should never occur
                if (affectedRows != 1) throw new Exception($"{affectedRows} affected on updating todo (ID:{_Todo_id}) with state {state}");

            }
            catch (MySqlException) { throw; }
        }

        //TODO later update instance note

        //-- DELETE --
        public void DeleteTodoById(int _Todo_id)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_DeleteTodoById, _connection);
                cmd.Parameters.AddWithValue("@Todo_id", _Todo_id);
                int affectedRows = cmd.ExecuteNonQuery();
                
                //this here should never occur
                if (affectedRows != 1) throw new Exception($"{affectedRows} affected on delete todo (ID:{_Todo_id}) with id {_Todo_id}");

            }
            catch (MySqlException) { throw; }

        }

    }
}

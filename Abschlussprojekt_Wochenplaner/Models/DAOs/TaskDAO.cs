using System.Windows;
using Abschlussprojekt_Wochenplaner.Models.Services;
using MySql.Data.MySqlClient;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task; //to avoid System own Task threading class name conflict. Should have thought of this, bruh :D

namespace Abschlussprojekt_Wochenplaner.Models.DAOs
{
    class TaskDAO
    {
        public static readonly MySqlConnection _connection = new DatabaseConnector().Connection; //public for making it closable from outside when closing application
        //-- string CONSTANTS for SQL statements --
        //Creation
        const string SQL_CreateTaskByFieldsAndGetNewId = "insert into Tasks (taskName, generalNote) values (@taskName, @generalNote) ; SELECT LAST_INSERT_ID()"; //cmd.ExecuteScalar()
        //Reading
            const string SQL_GetTaskByID = "select * from tasks where Task_id = @id;";
            const string SQL_GetTaskByTaskName = "select * from tasks where taskName = @taskName;"; 
            const string SQL_GetAllTasks = "select * from tasks;";

        //-- CREATE -- //only creating (saving) here
        public Task CreateTask(string taskName, string? generalNote = null)
        {
            Task task;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_CreateTaskByFieldsAndGetNewId, _connection);
                cmd.Parameters.AddWithValue("@taskName", taskName);
                cmd.Parameters.AddWithValue("@generalNote", (generalNote == null) ? DBNull.Value : generalNote);
                int id = Convert.ToInt32(cmd.ExecuteScalar());
                task = new Task(id, taskName, generalNote); //id after name, because standard is 0 and optionals must occur after optionals
            }
            catch (MySqlException) { throw; }

            return task;
        }

        //-- READ --
        public Task GetTaskById(int id)
        {
            Task Task;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetTaskByID, _connection);
                cmd.Parameters.AddWithValue("@id", id);
                using MySqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                    Task = BuildTaskFromReader(reader);
                else throw new Exception($"Task with id {id} could not be found");
            }
            catch (MySqlException) { throw; }


            return Task;
        }

        public Task? GetTaskByName(string taskName)
        {
            Task Task;
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetTaskByTaskName, _connection); //also when exists not found, why?
                cmd.Parameters.AddWithValue("@taskName", taskName);
                using MySqlDataReader reader = cmd.ExecuteReader();

                if (reader.Read())
                    Task = BuildTaskFromReader(reader);
                else return null; //no task found with given name
            }
            catch (MySqlException) { throw; }


            return Task;
        }

        public List<Task> GetAllTasks()
        {
            List<Task> Tasks = new List<Task>();
            try
            {
                MySqlCommand cmd = new MySqlCommand(SQL_GetAllTasks, _connection);
                using MySqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                    Tasks.Add(BuildTaskFromReader(reader));
            }
            catch (MySqlException) { throw; }


            return Tasks;
        }

        private Task BuildTaskFromReader(MySqlDataReader reader) //just an auxiliary outsourcing
        {
            int id = reader.GetInt32("Task_id");
            string taskName = reader.GetString("taskName");
            string? generalNote = null;

            if (!reader.IsDBNull(reader.GetOrdinal("generalNote"))) generalNote = reader.GetString("generalNote");
            return new Task(id, taskName, generalNote);
        }

        //-- UPDATE --
        //not intended now but later(changing task name or note not intended in first version, as well as an administrative management of them)
        //later on at here a todo with task in category could be changed or if cat is none than changed here anyway


        //-- DELETE --
        //not intended now but later (not deletable in first version, because no task managing intended for now)

    }
}

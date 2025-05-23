using System.Data;
using System.Windows;
using MySql.Data.MySqlClient;


namespace Abschlussprojekt_Wochenplaner.Models.Services
{
    //Singleton for providing specific connection
    public class DatabaseConnector //singleton should be static so class elements must be static as well
    {
        //parameters for building up the connection
        static string _Server = "localhost";
        static string _DatabaseName = "weeklySchedule";
        static string _User_id = "root";
        static string _Password = "dominik-labocha";

        //Build up connection by concatenating a formatted string
        static string _ConnectionString = $"Server={_Server};Database={_DatabaseName};User ID={_User_id};Password={_Password};";
        //$ for printf, @ is for literal with no\t or \n (like textbox)
        //https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/tokens/interpolated


        //modifier can be omitted in C#, none is private automatically
        MySqlConnection _connection; //static instance that will be the only one in singleton
        public MySqlConnection Connection //Property to Backing field above (no () after Name!)
        {
            get
            {
                //when there is no connection, yet or it has been already closed
                if (_connection == null) //Referring to an Enum listing states (closed = 0, Open = 1, ...)
                    _connection = new MySqlConnection(_ConnectionString);

                //try opening connection
                if (_connection.State == System.Data.ConnectionState.Closed)
                    try
                    {
                        _connection.Open();
                    }
                    catch (MySqlException ex) //connection couldn't be built up
                    {
                        MessageBox.Show((ex.Message + "\n\nThe Application will be closed now."), "Connecting to Database failed", MessageBoxButton.OK, MessageBoxImage.Error);
                        //System.Windows.Application.Current.Shutdown(); //has not stopped the full process
                        Environment.Exit(0);
                        //https://stackoverflow.com/questions/2820357/how-do-i-exit-a-wpf-application-programmatically
                    }

                //finally return connection
                return _connection;
            }

        }

        public void CloseConnection()
        {
            if (_connection != null && _connection.State == ConnectionState.Open)
            {
                _connection.Close();
                Console.WriteLine("Connection closed.");
            }
            _connection?.Dispose();
        }

        public void OpenConnection()
        {
            if (_connection != null && _connection.State == ConnectionState.Closed)
            {
                _connection.Open();
                Console.WriteLine("Connection closed.");
            }
        }
    }
}

using MySql.Data.MySqlClient;

//Tasks' steps
/*
TODO Öffnet das Projekt von gestern, in der ihr eine Oberfläche zum Hinzufügen eines Buches gebaut hattet
UNDONE Erstellt ein Package singleton
FIX ME Projekt – Rechtsklick – Hinzufügen – Neuer Ordner – Name: singleton
DONE Erstellt eine STATISCHE Klasse DBConnector(kann somit nur statische Elemente beinhalten)
DONE Nutzt die Klasse MySqlConnection, um eine Singleton-Klasse zu schreiben
DONE Schreibe eine getter-Methode, die eine Connection zurückgeben soll.
DONE Überprüfe, bevor du eine Connection aufbaust, ob die Connection null oder closed ist

DONE ConnectionState.Closed
DONE Verbinde dich mit der Library-Datenbank
DONE Nutze dafür die Open()-Methode
DONE NutzeExceptions
DONE Gebt mittels MessageBox.Show(„Connected Successfully“) aus, ob die Verbindung erfolgreich war. Wenn nicht, passt die MessageBox-Nachricht an.
 
"Server=localhost;Database=library;User ID=root;Password=;"
 */

namespace WindowsForms_Library.singleton
{
    internal static class DBConnectorLibrary
    {
        private static MySqlConnection _connection;

        public static MySqlConnection GetConnection()
        {
            if (_connection == null || _connection.State == System.Data.ConnectionState.Closed)
            {
                _connection = new MySqlConnection("Server=localhost;Database=library;User ID=root;Password=dominik-labocha;");
                try
                {
                    _connection.Open();
                    MessageBox.Show("Connected Successfully to database library");
                    //Console.WriteLine("Connected Successfully to database library"); //why does console write not work with GUI ???
                }
                catch (MySqlException ex)
                {
                    MessageBox.Show("Connecting to database library failed.\nFix the connection and restart.");
                    Application.Exit();
                }
            }

            return _connection;
        }
    }
}

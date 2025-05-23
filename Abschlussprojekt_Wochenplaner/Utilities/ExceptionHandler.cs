//Written by AI as I asked it, how I can avoid writing the same try catch block in every method all over again

// Dateiname: ExceptionHandler.cs
// Pfad: Abschlussprojekt_Wochenplaner/Utilities/ExceptionHandler.cs

using MySql.Data.MySqlClient; // Oder der spezifische Namespace für MySqlException
using System;
using System.Diagnostics; // Für Debug.WriteLine
using System.Windows;   // Für MessageBox

namespace Abschlussprojekt_Wochenplaner.Utilities
{
    public static class ExceptionHandler
    {
        /// <summary>
        /// Führt eine Aktion sicher aus und fängt gängige Datenbank- und allgemeine Ausnahmen ab.
        /// Zeigt eine MessageBox bei Fehlern an und loggt Details ins Debug-Fenster.
        /// </summary>
        /// <param name="action">Die auszuführende Aktion (Methode ohne Rückgabewert).</param>
        public static void Handle(Action action)
        {
            try
            {
                action.Invoke(); // Führt die übergebene Methode aus
            }
            catch (MySqlException ex)
            {
                // Spezifische Behandlung für MySQL-Fehler
                MessageBox.Show(("Ein Problem beim Speichern ist aufgetreten!.\nFehlertext:\n" + ex.Message), "Datenbankfehler", MessageBoxButton.OK, MessageBoxImage.Error); LogExceptionDetails(ex, "MySqlException");
                LogExceptionDetails(ex, "MySqlException");
            }
            catch (Exception ex)
            {
                // Allgemeine Fehlerbehandlung
                MessageBox.Show("Ein Problem ist aufgetreten.\nFehlertext:\n" + ex.Message, "Fehler!", MessageBoxButton.OK, MessageBoxImage.Error);
                LogExceptionDetails(ex, "General Exception");
            }
        }

        /// <summary>
        /// Führt eine Funktion sicher aus und fängt gängige Datenbank- und allgemeine Ausnahmen ab.
        /// Zeigt eine MessageBox bei Fehlern an und loggt Details ins Debug-Fenster.
        /// </summary>
        /// <typeparam name="T">Der Typ des Rückgabewerts der Funktion.</typeparam>
        /// <param name="func">Die auszuführende Funktion (Methode mit Rückgabewert).</param>
        /// <returns>Den Rückgabewert der Funktion bei Erfolg, oder den Standardwert von T bei einem Fehler.</returns>
        public static T Handle<T>(Func<T> func)
        {
            try
            {
                return func.Invoke(); // Führt die übergebene Methode aus und gibt das Ergebnis zurück
            }
            catch (MySqlException ex)
            {
                MessageBox.Show(("Ein Problem beim Speichern ist aufgetreten!.\nFehlertext:\n" + ex.Message), "Datenbankfehler", MessageBoxButton.OK, MessageBoxImage.Error); LogExceptionDetails(ex, "MySqlException");
                LogExceptionDetails(ex, "MySqlException");
                return default(T); // Gibt den Standardwert für den Typ T zurück (z.B. null für Referenztypen, 0 für int)
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ein Problem ist aufgetreten.\nFehlertext:\n" + ex.Message, "Fehler!", MessageBoxButton.OK, MessageBoxImage.Error);
                LogExceptionDetails(ex, "General Exception");
                return default(T);
            }
        }

        /// <summary>
        /// Hilfsmethode zum Loggen der Ausnahmedetails.
        /// </summary>
        /// <param name="ex">Die aufgetretene Ausnahme.</param>
        /// <param name="exceptionType">Eine Beschreibung des Ausnahmentyps für das Logging.</param>
        private static void LogExceptionDetails(Exception ex, string exceptionType)
        {
            Debug.WriteLine($"--- {exceptionType} ---");
            Debug.WriteLine($"Message: {ex.Message}");
            if (ex.InnerException != null)
            {
                Debug.WriteLine($"InnerException Message: {ex.InnerException.Message}");
            }
            Debug.WriteLine($"StackTrace: {ex.StackTrace}");
            Debug.WriteLine("---------------------");
        }
    }
}
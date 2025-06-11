using Abschlussprojekt_Wochenplaner.Models.Entities;
using Abschlussprojekt_Wochenplaner.Models.DAOs;
using MySql.Data.MySqlClient;
using System.Globalization;
using System.Windows;

namespace Abschlussprojekt_Wochenplaner.Models.Services
{

    public class BoardService
    {
        BoardDAO boardDAO = new BoardDAO();

        public Board SaveCreatedBoardAndReturnIt(Board boardToSave) //tested successfully
        {
            int year = boardToSave.Year;
            int week = boardToSave.Week;
            DateOnly? from = boardToSave.FromDate;
            DateOnly? to = boardToSave.ToDate;
            Board savedBoardWithID;
            savedBoardWithID = boardDAO.CreateBoard(year, week, from, to);
            return savedBoardWithID;
        }

        public Board GetLastBoardCreated() //tested successfully
        {
            Board lastBoard;
            try
            {
                lastBoard = boardDAO.GetBoardById(boardDAO.GetLastBoardId()); //like a sub-query
            }
            catch (Exception ex) //Board not found, failed to load or none created yet, Exception unspecified
            {
                if (ex is not MySqlException) //could also be done with another catch branch
                {
                    MessageBox.Show("No Board found for initial load! We create one for this week."); //only for now, later user should create first by button //TODO Remove this later
                    lastBoard = CreateABoardForCurrentWeekAndReturnIt();
                    //add return null here later
                } //in case Exception was not because of SQL issues but simply no board was pre-saved
                else throw; //if it is MySql related coming changing could not be savable because then board has no id a todo can be linked to
            }

            return lastBoard; //like a sub-query
        }

        public Board CreateABoardForCurrentWeekAndReturnIt() //Fallback
        {
            DateTime today = DateTime.Today;
            CultureInfo ci = CultureInfo.CurrentCulture; // or CultureInfo.GetCultureInfo("de-DE")

            CalendarWeekRule weekRule = ci.DateTimeFormat.CalendarWeekRule;
            DayOfWeek firstDayOfWeek = ci.DateTimeFormat.FirstDayOfWeek;
            int calendarWeek = ci.Calendar.GetWeekOfYear(today, weekRule, firstDayOfWeek);

            //DONE add date interval calculation later
            // --- Datumsinvervall-Berechnung START ---
                int diff = (7 + (today.DayOfWeek - firstDayOfWeek)) % 7;
                DateTime mondayOfWeek = today.AddDays(-diff);
                DateTime sundayOfWeek = mondayOfWeek.AddDays(6);
            // --- Datumsinvervall-Berechnung ENDE ---
            DateOnly fromDate = DateOnly.FromDateTime(mondayOfWeek);
            DateOnly toDate = DateOnly.FromDateTime(sundayOfWeek);

            //To make the app startable with a real board, create one on the fly
            return SaveCreatedBoardAndReturnIt(new Board(today.Year, calendarWeek, fromDate, toDate));
        }

        //Later for managing them --> GetAllBoards()
        //after that updating and deleting, if wanted, but musted be added in DAO as well

    }
}

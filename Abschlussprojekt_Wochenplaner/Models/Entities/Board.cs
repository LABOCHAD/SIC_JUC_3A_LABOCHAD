using System.Text;

namespace Abschlussprojekt_Wochenplaner.Models.Entities
{
    public class Board
    {
        //--- Constants for errors and exception handling ---
        private const string InvalidYearMessage = "The value {0} is no valid year. \n(Range: 2000 - 9999)";
        private const string InvalidWeekMessage = "The value {0} is no valid calendar week number. \n(Range: 01 - 52)";


        //--- Actual fields and properties ---
        public int BoardId { get; private set; } = 0; //0 = not saved to DB yet //should not be set outside the constructor, so no Backing field needed

        int _year;
        public int Year //Property must have a backing field if controlled access wanted
        {
            get { return _year; }
            set
            {
                if (value < 2000 && value > 9999)
                    throw new ArgumentOutOfRangeException(nameof(Year), value, string.Format(InvalidYearMessage, value)); //paramName, argumentObjekt, MessageString
                _year = value;
            }
        }
        int _week;
        public int Week //Property must have a backing field if controlled access wanted
        {
            get { return _week; }
            set
            {
                if (value < 01 && value > 52)
                    throw new ArgumentOutOfRangeException(nameof(Week), value, string.Format(InvalidWeekMessage, value));
                _week = value;
            }
        }

        //Consider for future versions to validate if the interval matches year and week number
        public DateOnly? FromDate { get; set; } //no controlled access for now, because optional field
        public DateOnly? ToDate { get; set; } //no controlled access for now, because optional field

        //--- Constructor ---
        //could have been stayed with id=0 in between but id bothered me, id was not first, when there is any
        public Board(int id, int year, int week, DateOnly? fromDate = null, DateOnly? toDate = null) : this(year, week, fromDate, toDate) //chaining with this() must be outside (like super())
        {
            this.BoardId = id;
        }
        public Board(int year, int week, DateOnly? fromDate = null, DateOnly? toDate = null)
        {
            this.Year = year;
            this.Week = week;
            this.FromDate = fromDate;
            this.ToDate = toDate;
        }


        //--- space for any stuff that this entity should be capable of doing ---
        void CalculateDateIntervallAndAssignDates()
        {
            //if there should ever be time for it
            //then take the year and week number, use Calendar API and determine week's Monday's and Fridays's date each and assign them
        }

        private Board() { } //only for deepCopy
        public Board DeepCopy()
        {
            return new Board
            {
                BoardId = this.BoardId,
                Year = this.Year,
                Week = this.Week,
                FromDate = this.FromDate,
                ToDate = this.ToDate
            };
        }

        public override string? ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("\nBoard_ID: " + BoardId);
            sb.Append("\nYear: " + Year);
            sb.Append("\nWeek: " + Week);
            sb.Append("\nFromDate: " + FromDate);
            sb.Append("\nToDate: " + ToDate);

            return sb.ToString();
        }
    }
}

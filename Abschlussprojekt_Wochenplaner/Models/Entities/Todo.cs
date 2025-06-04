using Org.BouncyCastle.Asn1.X509;
using System.Text;
using System.Threading.Tasks;

namespace Abschlussprojekt_Wochenplaner.Models.Entities
{
    public class Todo
    {
        //--- Constants for errors and exception handling ---
        const int MaxLengthTodoState = 4;
        const int MaxLengthInstanceNote = 256;

        static readonly string InvalidNumberMessage = "{0} number must be from 1 to 7."; //weekday or slot (each 1-7), slots may be more than 7 in future

        static readonly string TodoStateNotInListMessage = "The given state \"{0}\" is not defined in the list of valid states!"; //no $ when used with string.Format(str, val)
        static readonly List<string> PossibleStatesList = new List<string> { "open", "done", "fail" }.AsReadOnly().ToList(); //toList down-castes collection back to list
        //can't use const, 'cause list is built at runtime. Try to change list throws NotSupportedException. Easier than an Enum for that, I think.

        static readonly string TodoStateTooLongMessage = $"TODO-State must be not longer than {MaxLengthTodoState} characters!"; //const dos not work with another constant inside
        static readonly string InstanceNoteTooLongMessage = $"General Note must be not longer than {MaxLengthInstanceNote} characters!";


        //--- Actual fields and properties ---
        public int TodoId { get; private set; } = 0;
        public Task Task { get; set; } //rebasing to another task enabled
        public Board Board { get; private set; } // for now not intended to be changed once set (assigning to another board)

        int _weekdayNumber;
        public int WeekdayNumber
        {
            get { return _weekdayNumber; }
            set
            {
                if (value < 1 && value > 7)
                    throw new ArgumentOutOfRangeException(nameof(value), value, String.Format(InvalidNumberMessage, "Weekday"));
                _weekdayNumber = value;
            }
        }

        int _slotNumber;
        public int SlotNumber
        {
            get { return _slotNumber; }
            set
            {
                if (value < 1 && value > 7)
                    throw new ArgumentOutOfRangeException(nameof(value), value, String.Format(InvalidNumberMessage, "Slot"));
                _slotNumber = value;
            }
        }

        string _state;
        public string State
        {
            get { return _state; }
            set
            {
                if (value.Length > MaxLengthTodoState) //additional assurance for the database in case a string longer 4 slips into the list
                    throw new ArgumentOutOfRangeException(nameof(value), value, TodoStateTooLongMessage);

                if (!PossibleStatesList.Contains(value))
                    throw new ArgumentException(String.Format(TodoStateNotInListMessage, value) 
                        + $"\nAt day {WeekdayNumber} and slot {SlotNumber}");

                _state = value;
            }
        }

        string _instanceNote;
        public string? InstanceNote
        {
            get { return _instanceNote; }
            set
            {
                if (value != null && value.Length > MaxLengthInstanceNote)
                    throw new ArgumentOutOfRangeException(nameof(value), value, InstanceNoteTooLongMessage);
                _instanceNote = value;
            }
        }


        //--- Constructor ---
        public Todo(int id, Task task, Board board, int weekdayNumber, int slotNumber, string state, string? instanceNote = null) : this(task, board, weekdayNumber, slotNumber, state, instanceNote)
        {
            this.TodoId = id;
        }

        public Todo(Task task, Board board, int weekdayNumber, int slotNumber, string state = "open", string? instanceNote = null)
        {
            this.Task = task;
            this.Board = board;
            this.WeekdayNumber = weekdayNumber;
            this.SlotNumber = slotNumber;
            this.State = state;
            this.InstanceNote = instanceNote;
        }

        private Todo() { }
        public Todo DeepCopy()
        {
            return new Todo
            {
                TodoId = TodoId,
                Task = this.Task.DeepCopy(),
                Board = this.Board.DeepCopy(),
                WeekdayNumber = this.WeekdayNumber,
                SlotNumber = this.SlotNumber,
                State = this.State,
                InstanceNote = this.InstanceNote
            };
        }

        //--- space for any stuff that this entity should be capable of doing ---
        //  idk thou we'll see

        public override string? ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("\nTodo_ID: " + TodoId.ToString());
            sb.Append("\nBoard: " + Board.ToString());
            sb.Append("\nTask: " + Task.ToString());

            sb.Append("\nWeekdayNumber: " + WeekdayNumber.ToString());
            sb.Append("\nSlotNumber: " + SlotNumber.ToString());
            sb.Append("\nState: " + State.ToString());
            //if (InstanceNote != null)
                sb.Append("\nInstanceNote: " + InstanceNote);

            return sb.ToString();
        }
    }
}

using System.Text;

namespace Abschlussprojekt_Wochenplaner.Models.Entities
{
    public class Task
    {
        //--- Constants for errors and exception handling ---
        const int MaxLengthTaskname = 32;
        const int MaxLengthGeneralNote = 256;
        const string InvalidTaskNameMessage = "Task name must have a readable content (be not null, empty or white-spaced only)";
        static readonly string TaskNameTooLongMessage = $"Task name must be not longer than {MaxLengthTaskname} characters!"; //const dos not work with another constant inside
        static readonly string GeneralNoteTooLongMessage = $"General Note name must be not longer than {MaxLengthGeneralNote} characters!";


        //--- Actual fields and properties ---
        public int TaskId { get; private set; } = 0; //0 means it has not been saved to DB yet (is 0 implicitly anyway)

        string _taskName;
        public string TaskName
        {
            get { return _taskName; }
            set
            {
                if (String.IsNullOrWhiteSpace(value))
                    throw new ArgumentException(InvalidTaskNameMessage);

                if (value.Length > MaxLengthTaskname)
                    throw new ArgumentException(TaskNameTooLongMessage);

                _taskName = value;
            }
        }
        string? _generalNote;
        public String? GeneralNote //all longer because of checking for maxLength, else short Property would have been enough
        {
            get { return _generalNote; }
            set
            {
                if (value != null && String.IsNullOrWhiteSpace(value))
                    throw new ArgumentException(InvalidTaskNameMessage);

                if (value != null && value.Length > MaxLengthGeneralNote)
                    throw new ArgumentException(GeneralNoteTooLongMessage);
                _generalNote = value;
            }
        }

        //--- Constructor ---
        public Task(int id, string taskName, string? generalNote = null) : this(taskName, generalNote)
        {
            this.TaskId = id;
        }
        public Task(string taskName, string? generalNote = null)
        {   //removed exceptions here, because Property setters having them are invoked anyway
            this.TaskName = taskName;
            this.GeneralNote = generalNote;
        }

        private Task() { }
        public Task DeepCopy()
        {
            return new Task
            {
                TaskId = this.TaskId,
                TaskName = this.TaskName,
                GeneralNote = this.GeneralNote
            };
        }
        public override string? ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("\nTask_ID: " + TaskId);
            sb.Append("\nTaskName: " + TaskName);
            sb.Append("\nGeneralNote: " + GeneralNote);

            return sb.ToString();
        }
    }
}

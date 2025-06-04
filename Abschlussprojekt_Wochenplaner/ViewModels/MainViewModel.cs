// Ignore Spelling: Abschlussprojekt Wochenplaner

using System.Collections.ObjectModel; // for ObservableCollection
using System.ComponentModel; // for INotifyPropertyChanged
using System.Windows.Input;
using Abschlussprojekt_Wochenplaner.Utilities;
using Abschlussprojekt_Wochenplaner.Models.Entities;
using Abschlussprojekt_Wochenplaner.Models.Services;
using System.Diagnostics; //for debug write line

using System.Windows;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task;
using Microsoft.VisualBasic;
using MySql.Data.MySqlClient;
using Abschlussprojekt_Wochenplaner.Views; //remind me next time not to name a damn own class task

// Hide and show
// https://learn.microsoft.com/en-us/visualstudio/ide/outlining?view=vs-2022

namespace Abschlussprojekt_Wochenplaner.ViewModels
{
    public class MainViewModel : INotifyPropertyChanged //interface for telling changes to the view
    {
        //static int test = 0;

        BoardService boardService;
        TaskService taskService;
        TodoService todoService;

        List<Todo> InitialTodos; //mirroring InitialTodos binded to the current boardLoaded (don't forget to synchronize, especially when changing boards later) - Used to feed BoardSlotViewModel

        bool IsWaitingForCopy = false;
        bool IsWaitingForMove = false;

        private List<string> _taskNames;
        public List<string> TaskNames
        {
            get => _taskNames;
            set
            {
                _taskNames = value;
                OnPropertyChanged(nameof(TaskNames));
            }
        }

        private Board _currentBoard;
        public Board CurrentBoard
        {
            get => _currentBoard;
            private set
            {
                if (value != null)
                {
                    _currentBoard = value;
                    OnPropertyChanged(nameof(CurrentBoard));
                }
            }
        } //Make head fields binded to it's properties as soon as implemented

        //2D Collection of Board Entry Slots
        private ObservableCollection<ObservableCollection<BoardSlotViewModel>> _boardEntries; //backing field but 2D
        public ObservableCollection<ObservableCollection<BoardSlotViewModel>> BoardEntries //actual property
        {
            get { return _boardEntries; }
            set
            {
                _boardEntries = value;
                OnPropertyChanged(nameof(BoardEntries)); //tells field it has been changed by GUI
            }
        }

        // Property saving the last selected slot
        private BoardSlotViewModel _selectedBoardSlot; // needed for buttons two know which slot has been selected
        public BoardSlotViewModel SelectedBoardSlot //let's see how this will work with copyTodo/move (maybe we'll need another)
        {
            get => _selectedBoardSlot;
            set
            {
                if (_selectedBoardSlot != value)

                    if (_selectedBoardSlot != null) //only if there is any
                    {
                        _selectedBoardSlot.IsSelected = false; // Unmark previous selected slot
                    }

                _selectedBoardSlot = value; // now assign the new one


                if (_selectedBoardSlot != null)
                {
                    _selectedBoardSlot.IsSelected = true; // mark new selected one
                }

                OnPropertyChanged(nameof(SelectedBoardSlot)); // Tell View it changed

                // for testing what has been selected
                if (SelectedBoardSlot != null)
                {
                    Debug.WriteLine($"Selected: Day {SelectedBoardSlot.DayIndex}, Slot {SelectedBoardSlot.SlotIndex} (Text: {SelectedBoardSlot.DisplayText})");
                }
            }
        }
        private BoardSlotViewModel firstSlot;
        private BoardSlotViewModel secondSlot;//ForCopy/Move

        // Command, that is being called when a slot has been clicked
        public ICommand SelectSlotCommand { get; private set; } //this is a kind of action listener, but xaml compatible

        //Side Button Commands
        public ICommand ClickedButtonAddCommand { get; private set; }
        public ICommand ClickedButtonEditCommand { get; private set; }
        public ICommand ClickedButtonDeleteCommand { get; private set; }
        public ICommand ClickedButtonMoveCommand { get; private set; }
        public ICommand ClickedButtonCopyCommand { get; private set; }
        public ICommand ClickedButtonDoneCommand { get; private set; }
        public ICommand ClickedButtonFailCommand { get; private set; }

        public ICommand ClickedButtonNewBoard { get; private set; }

        public ICommand AddTaskCommand { get; private set; }

        //  C O N S T R U K T O R
        public MainViewModel()
        {
            //MessageBox.Show($"Ich werde zum {++test}. Mal geladen."); Discovered difference between Designtime and Runtime
            //Consider to display a short HOW TO
            AssignCommandsViaRelay();
            InitialzeServicesAndEntities();
            InitializeBoardSlots();
        }

        // A U X I L L I A R I E S
        private void AssignCommandsViaRelay()
        {
            //Initialize the command, it takes a BoardVieModel (SlotContent) as Parameter. (I know a Relay as an electronical Switch)
            //here is where the method is being assigned to the "action listener" via relay
            SelectSlotCommand = new RelayCommand<BoardSlotViewModel>(OnSelectSlot); //this is needed to trigger the assignment by the click on GUI
            //RelayCommand is a class implementing the functional Interface ICommand (Checking executability)

            //Now assign actions via Relay
            ClickedButtonAddCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonAdd()));
            ClickedButtonEditCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonEdit()));
            ClickedButtonDeleteCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonDelete()));
            ClickedButtonMoveCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonMove()));
            ClickedButtonCopyCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonCopy()));
            ClickedButtonDoneCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonDone()));
            ClickedButtonFailCommand = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonFail()));

            ClickedButtonNewBoard = new RelayCommand(() => ExceptionHandler.Handle(() => OnClickedButtonNewBoard()));
        }


        private void InitialzeServicesAndEntities()
        {
            //Start Services //FIXME repair circular usages within them
            boardService = new BoardService();
            taskService = new TaskService();
            todoService = new TodoService();

            TaskNames = taskService.GetAllTaskNamesAsStringList();
            CurrentBoard = boardService.GetLastBoardCreated();

            InitialTodos = todoService.GetAllTodosOnTheBoard(CurrentBoard); //could be empty, if boardLoaded has none or is new
            IsWaitingForMove = false; IsWaitingForCopy = false; //in case new boardLoaded is loaded, while waiting was active
            //Debugging
            /*            
             *          Debug.WriteLine("\nCurrent Board:\t"+CurrentBoard);
                        Debug.WriteLine("\nList a predefined Tasks:");
                        foreach (Task task in tasks) { Debug.WriteLine(task); }
                        Debug.WriteLine("\nList a Todos on current boardLoaded:");
                        foreach (Todo todo in InitialTodos) { Debug.WriteLine(todo);
             */

        }

        private void InitializeBoardSlots() //load Todos and fill them in or just leave them blank, if none is assigned to the board
        {
            BoardEntries = new ObservableCollection<ObservableCollection<BoardSlotViewModel>>();
            for (int day = 0; day < 7; day++)
            {
                var daySlots = new ObservableCollection<BoardSlotViewModel>();
                for (int slot = 0; slot < 7; slot++)
                    daySlots.Add(new BoardSlotViewModel(day + 1, slot + 1)); //leave text empty at first
                BoardEntries.Add(daySlots); //add inner collection to outer one
            }
            SelectedBoardSlot = BoardEntries[0][0]; //make sure slot will never be null

            foreach (Todo t in InitialTodos)
            {
                //assuming that InitialTodos don't exceed the 7*7 range (mind the off by one shift!)
                BoardSlotViewModel currentSlot = BoardEntries[t.WeekdayNumber - 1][t.SlotNumber - 1];
                currentSlot.Todo = t;
                if (string.Equals(t.State, "done"))
                    currentSlot.DisplayText += " ✔"; //make done visible again
                else if (string.Equals(t.State, "fail"))
                    currentSlot.DisplayText += " ❌"; //make fail visible again
            }
        }

        // For Button Actions (Outsourcings)
        private bool IsSlotPreoccupied(string action)
        {
            //check for slot preoccupation is done here,
            //also service checks for it (but only afterwards!)
            if (!SelectedBoardSlot.DisplayText.Equals("")) //check on GUI side, not from DB
            {
                MessageBox.Show($"Du kannst auf diesen Slot nichts {action}." +
                    $"\nLeere ihn vorher durch Verschieben oder Löschen.",
                    $"Slot bereits besetzt  (Tag: {SelectedBoardSlot.DayIndex}, Slot: {SelectedBoardSlot.SlotIndex})",
                    MessageBoxButton.OK, MessageBoxImage.Exclamation);
                return true;
            }
            return false;
        }

        private bool IsSlotStillEmpty(string action)
        {
            if (SelectedBoardSlot.DisplayText.Equals("")) //check on GUI side, not from DB
            {
                MessageBox.Show($"Du kannst von diesem Slot nichts {action}." +
                    $"\nFülle ihn durch Hinzufügen, Verschieben oder Kopieren.",
                    $"Slot noch leer (Tag: {SelectedBoardSlot.DayIndex}, Slot: {SelectedBoardSlot.SlotIndex})",
                    MessageBoxButton.OK, MessageBoxImage.Exclamation);
                return true;
            }
            return false;
        }

        private Task? GetTaskFromDropDownInputDialog()
        {
            Task? task = null;
            InputDropdownDialog dialog = new InputDropdownDialog(TaskNames, "");
            bool? dialogResult = dialog.ShowDialog();
            if (dialogResult == true)
            {
                string selectedOrEnteredTask = dialog.ResultValue;
                if (!string.IsNullOrWhiteSpace(selectedOrEnteredTask))
                {

                    task = new Task(selectedOrEnteredTask);
                    if (taskService.IsNewTask(selectedOrEnteredTask))
                    {
                        string note = Interaction.InputBox("Gib eine Notiz zur neuen Aufgabe ein. Achtung! Diese bleibt mit dem Namen verknüpft, " +
                            "bis die Aufgabe aus der Datenbank gelöscht wurde. Du kannst sie auch leer lassen.", "Diese Aufgabe ist neu.");
                        if (!String.IsNullOrEmpty(note))
                            task = new Task(selectedOrEnteredTask, note);
                        else task = taskService.GetTaskBackWithID_CreateFirstIfNew(task); //without note, if left empty
                        //MessageBox.Show($"Neuer Task hinzugefügt: {selectedOrEnteredTask}", "Task Hinzufügen", MessageBoxButton.OK, MessageBoxImage.Information);
                    }
                    else { task = taskService.GetTaskBackWithID_CreateFirstIfNew(task); } //without note when known, cause has one anyway (or not)

                    TaskNames = taskService.GetAllTaskNamesAsStringList(); //refresh list for next time
                }
                else MessageBox.Show("Kein gültiger Taskname ausgewählt oder eingegeben.", "Fehler", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
            else MessageBox.Show("Task-Erstellung abgebrochen.", "Abgebrochen", MessageBoxButton.OK, MessageBoxImage.Information);

            return task;
        }

        private void FinishCopyOrMove() //so I won't need any multi-Thread
        {
            if (firstSlot == secondSlot)
            {
                MessageBox.Show("Quell- und Zielslot sing gleich.", "Keine Änderung angewandt.", MessageBoxButton.OK, MessageBoxImage.Information);
                IsWaitingForMove = false; IsWaitingForCopy = false; return;
            }

            SelectedBoardSlot = secondSlot;
            if (IsSlotPreoccupied("verschieben oder kopieren")) { IsWaitingForMove = false; IsWaitingForCopy = false; return; }

            Todo copyTodo = firstSlot.Todo.DeepCopy();
            int destinstionDay = secondSlot.DayIndex;
            int destinationSlot = secondSlot.SlotIndex;
            copyTodo.WeekdayNumber = destinstionDay;
            copyTodo.SlotNumber = destinationSlot;

            //Finish Moving
            if (IsWaitingForMove)
            {
                todoService.MoveTodo(copyTodo);
                firstSlot.Todo = null;
                secondSlot.Todo = copyTodo;
            }
            //Finish Copying
            else if (IsWaitingForCopy)
            {
                copyTodo = todoService.CopyTodo(copyTodo); //make sure New ID of todo copy from DB is applied in backend
                secondSlot.Todo = copyTodo;
            }

            else MessageBox.Show("Etwas ist schief gelaufen. Versuchs nochmal.",
                                 "Fehler", MessageBoxButton.OK, MessageBoxImage.Warning);

            IsWaitingForMove = false; IsWaitingForCopy = false;
        }

        // B U T T O N S

        //Button actions for side buttons 
        //TODO remember to wrap them later with Exception Handler at command init
        //TODO ADDING: later on try a dropdownList approach to use predefines tasks
        private void OnClickedButtonAdd()
        { //TODO EDIT Refresh Task Pool for dropdown
            if (IsSlotPreoccupied("hinzufügen")) return;
            Task? task = GetTaskFromDropDownInputDialog();
            if (task == null) return; //Creation has been aborted or left empty

            int day = SelectedBoardSlot.DayIndex;
            int slot = SelectedBoardSlot.SlotIndex;
            Todo todo = new Todo(task, CurrentBoard, day, slot);

            todo = todoService.AddATodoAndReturnItWithNewID(todo); //save to DB and get it back with new ID

            SelectedBoardSlot.Todo = todo; //if save was successful //triggers UI update
        } //DONE

        private void OnClickedButtonEdit()
        { //TODO EDIT Refresh Task Pool for dropdown
            Debug.WriteLine("Edit has been clicked.");
            if (IsSlotStillEmpty("bearbeiten")) return;
            if (SelectedBoardSlot.Todo != null)
            {
                //Get or Create Task with ID and save to DB
                Task? task = GetTaskFromDropDownInputDialog();
                if (task == null) return; //Editing has been aborted or left empty
                //TODO add change generalNote only in taskService and taskDAO (so name remains and note changes) and add up to dialog method
                Todo copyTodo = SelectedBoardSlot.Todo.DeepCopy(); //memberWiseClone would have brought same references for inner objects
                copyTodo.Task = task; //update copy of Entity - no UI update if DB fails
                todoService.EditTodoByTask(copyTodo); //update Todo in Database (Exception thrown if fails)

                SelectedBoardSlot.Todo = copyTodo; //update actual Todo Entity and UI after success   
            }
        } //DONE

        private void OnClickedButtonDelete()
        {
            if (IsSlotStillEmpty("löschen")) return; //checks by empty text (set "", when ToDo is null)
            Todo? slotTodo = SelectedBoardSlot.Todo;
            if (slotTodo != null)
            {
                MessageBoxResult result = MessageBox.Show($"Details:\n{slotTodo}",
                    "Willst du das Todo wirklich löschen?", MessageBoxButton.YesNo);
                if (result == MessageBoxResult.Yes)
                {
                    todoService.RemoveTodo(slotTodo);
                    SelectedBoardSlot.Todo = null;
                }

            }

            Debug.WriteLine("Delete has been clicked.");
        } //DONE

        private void OnClickedButtonMove()
        {
            if (IsSlotStillEmpty("verschieben")) return;
            Debug.WriteLine("Move has been clicked");
            IsWaitingForMove = true;
            IsWaitingForCopy = false; //prevent double processing
            //MessageBox.Show("Klicke nun auf den Zielslot, in welchen du verschieben willst.", "Bereit zum Verschieben", MessageBoxButton.OK, MessageBoxImage.Information);

        } //DONE move

        private void OnClickedButtonCopy()
        {
            if (IsSlotStillEmpty("kopieren")) return;
            Debug.WriteLine("Copy has been clicked.");
            IsWaitingForCopy = true;
            IsWaitingForMove = false; //prevent double processing
            //MessageBox.Show("Klicke nun auf den Zielslot, in welchen du kopieren willst.", "Bereit zum Kopieren", MessageBoxButton.OK, MessageBoxImage.Information);

        } //DONE copyTodo

        private void OnClickedButtonDone()
        {
            Debug.WriteLine("Done has been clicked.");
            if (IsSlotStillEmpty("als erledigt markieren")) return;
            if (SelectedBoardSlot.Todo != null)
            {
                Todo copyTodo = SelectedBoardSlot.Todo.DeepCopy();
                todoService.MarkTodoAsDone(copyTodo);
                SelectedBoardSlot.Todo = copyTodo; //old status will be also wiped
                if (copyTodo.State.Equals("done"))
                    SelectedBoardSlot.DisplayText += " ✔";
            }
        } //DONE Mark as done

        private void OnClickedButtonFail()
        {
            if (IsSlotStillEmpty("als nicht geschafft markieren")) return;
            Debug.WriteLine("Failed has been clicked.");
            if (SelectedBoardSlot.Todo != null)
            {
                Todo copyTodo = SelectedBoardSlot.Todo.DeepCopy();
                todoService.MarkTodoAsFailed(copyTodo);
                SelectedBoardSlot.Todo = copyTodo; //old status will be also wiped
                if (copyTodo.State.Equals("fail"))
                    SelectedBoardSlot.DisplayText += " ❌";
            }

        } //DONE Mark as failed

        private void OnClickedButtonNewBoard()
        {
            Debug.WriteLine("New Board has been clicked.");

            MessageBoxResult result = MessageBox.Show("Das alte Board bleibt in der Datenbank gespeichtert,\n" +
                "ist dann aber in dieser Programm-Verion vorerst nicht mehr aufrufbar", "Neues Board anlegen?", MessageBoxButton.YesNo);
            if (result == MessageBoxResult.Yes)
            {
                CurrentBoard = boardService.CreateABoardForCurrentWeekAndReturnIt();
                InitialTodos = new List<Todo>();

                InitializeBoardSlots();
            }

        } //TODO new Board (comes later)


        // Method called by SelectSlotCommand if a slot is being clicked. (This is the actual button action)
        private void OnSelectSlot(BoardSlotViewModel clickedSlot) //passed to the (has been clicked on action)
        {
            //set selected slot to the clicked one (slots Property setter manages the IsSelected property)
            if (IsWaitingForCopy || IsWaitingForMove)
            {
                firstSlot = SelectedBoardSlot; //save old value, before changing it
                secondSlot = clickedSlot; //save new directly after
                FinishCopyOrMove();
            }
            SelectedBoardSlot = clickedSlot; //and here anyway, ready for next action
        }

        //Interface must have stuff
        public event PropertyChangedEventHandler PropertyChanged; //event handler, some reactive stuff

        protected void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName)); //Invokes reaction to changes
        }

    }
}

/*
                try
                {

                }
                catch (MySqlException ex)
                {
                MessageBox.Show(("Ein Problem beim Speichern ist aufgetreten!.\nFehlertext:\n " + ex.Message), "Datenbankfehler", MessageBoxButton.OK, MessageBoxImage.Error); LogExceptionDetails(ex, "MySqlException");
                    Debug.WriteLine(ex.Message, ex.InnerException.Message, ex.StackTrace);
                }
                catch (Exception ex)
                {

                MessageBox.Show("Ein Problem ist aufgetreten.\nFehlertext:\n " + ex.Message, "Fehler!", MessageBoxButton.OK, MessageBoxImage.Error);
                    Debug.WriteLine(ex.Message, ex.InnerException.Message, ex.StackTrace);
                }
 */

//TODO CATCH AND TREAT EXCEPTIONS HERE (AGRUMENT; RANGE; SQL; AND GENERELL)
//GUI MUST REWIND CHANGE IF SAVING FAILED; DB, ENITITY-OBJECTS AND GUI MUST ALWAYS STAY SYNCHRONIZED

//Mapping for weekdays (first row), so column number can be mapped to a weekday, like 0 = Monday ("Montag")

//For latest exception catching in here
//MessageBox.Show(ex.Message, "Database related error!", MessageBoxButton.OK, MessageBoxImage.Error);
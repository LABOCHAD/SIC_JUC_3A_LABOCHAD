using System.Windows;
using Abschlussprojekt_Wochenplaner.Models.Services; //just to test
using Abschlussprojekt_Wochenplaner.Models.Entities; //just to test
using Abschlussprojekt_Wochenplaner.ViewModels;
using MySql.Data.MySqlClient;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task;
using Abschlussprojekt_Wochenplaner.Models.DAOs; // consider namespace

namespace Abschlussprojekt_Wochenplaner.Views
{
    public partial class MainView
    {
        public MainViewModel ViewModel { get; } = new MainViewModel(); // create an instance of the viewModel
        //no view inside the viewModel. The will no direct bidirectional communication, but reactive databinding.

        public MainView()
        {
            InitializeComponent();
            DataContext = ViewModel; 
            // set dataContext of view to ViewModel 
            //seems to be old fashioned to do it here 
            //I do it anyway to avoid double VM loading

            //Test(); //TODO Remove when done
        }

        // -- TESTING AREA BEFORE REAL BINDING --
        /*
                private void Test()
                {
                    BoardService boardService = new BoardService();
                    TaskService taskService = new TaskService();
                    TodoService todoService = new TodoService();

                    //Board Creation
                    DateOnly from = new DateOnly(2025, 05, 12);
                    DateOnly to = new DateOnly(2025, 05, 18);
                    Board boardWithDates = new Board(2025, 20, from, to); //has no ID yet
                    Board lastBoard = boardService.GetLastBoardCreated();

                    Task newTask = new Task("For testing InitialTodos from now on2");
                    Task existingTask = new Task("test1");
                    Task taskWithNote = new Task("Test my Services", "Some additional stuff about testing...");

                    //Todo todo = new Todo(new Task(DateTime.Now.ToString()), lastBoard, 5, 3); //should be now Friday second slot
                    List<Todo> InitialTodos = todoService.GetAllTodosOnTheBoard(lastBoard);
                    Todo todo;
                    if (InitialTodos.Count == 0) { todo = new Todo(new Task(DateTime.Now.ToString()), lastBoard, 1, 1); }
                    else todo = InitialTodos[InitialTodos.Count - 1];
                    MessageBox.Show("Before change\n" + todo.ToString());

                    try
                    {
                        //TODO consider check if a boardWithDates with same year and weeks exists

                        // B O A R D
                        //Try Board Creation - done
                        //boardWithDates = boardService.SaveCreatedBoardAndReturnIt(boardWithDates); //boardWithDates could be created, has an id now
                        //MessageBox.Show(boardWithDates.ToString(), "Board just created"); //could be added, also with date

                        //Try last Board Loading - done
                        //Board loadedBoard = boardService.GetLastBoardCreated(); //could not find specific column fromDate
                        //MessageBox.Show(loadedBoard.ToString(), "Reloaded last boardWithDates from Database"); //now gets loaded correctly

                        // T A S K
                        //Check for new Task
                        //MessageBox.Show(taskService.isNewTask(newTask).ToString(), "Test with new Task (isNew?)"); // works
                        //MessageBox.Show(taskService.isNewTask(existingTask).ToString(), "Test with existing Task (isNew?)"); // works

                        //Try Creating new Task
                        //Task t = taskService.SaveNewTask(newTask); MessageBox.Show(t.ToString());// works


                        //Try getting tasks names - done
                        //foreach (string s in taskService.GetAllTaskNamesAsStringList()) MessageBox.Show(s);

                        //Try getting tasks names - done
                        //foreach (Task t in taskService.GetAllTasksAsEntityList()) MessageBox.Show(t.ToString());


                        // T O D O -- in Progress

                        //ADD -- works now. Had to make sure IDs will be passed as well
                        //todo = todoService.AddATodoAndReturnItWithNewID(todo); MessageBox.Show(todo.ToString()); //before change


                        //EDIT -- seems like working. added two new tasks and one existing two times in a row afterwards.
                        //todo.Task = existingTask;
                        //todoService.EditTodoByTask(todo); MessageBox.Show(todo.ToString()); //after change


                        //DELETE -- works as well
                        // todoService.RemoveTodo(todo); InitialTodos.Remove(todo);


                        //MOVE //TODO make sure to check if slot not occupied -- WORKS 🥳
                        //now move without changing aimed slot -- triggers exception as wanted (slot already in use)
                        //try { todoService.MoveTodo(todo); } catch (Exception ex) { MessageBox.Show(ex.Message); }


                        //COPY -- works 🥳
                        //todo.WeekdayNumber += 1;
                        //todo.SlotNumber += 1;
                        //todo = todoService.CopyTodo(todo); //mind new ID after copying
                        //MessageBox.Show("After change\n" + todo.ToString());

                        //MARK DONE -- works 🥳
                        //todoService.MarkTodoAsDone(todo); MessageBox.Show("DONE\n" + todo.ToString());

                        //MARK FAIL -- works 🥳
                        //todoService.MarkTodoAsFailed(todo); MessageBox.Show("FAILED\n" + todo.ToString());

                        //UNMARK -- works 🥳
                        //todoService.MarkTodoAsFailed(todo); MessageBox.Show("UNMARK AS OPEN\n" + todo.ToString());

                    }
                    catch (ArithmeticException ex) { } //just a dummy to enable the others to be commented out for make them crash intentionally for testing.
                    catch (MySqlException ex) { MessageBox.Show((ex.Message), "Database related error!", MessageBoxButton.OK, MessageBoxImage.Error); }
                    catch (Exception ex) { MessageBox.Show((ex.Message), "A non SQL-related Exception occurred", MessageBoxButton.OK, MessageBoxImage.Error); }
                }*/

    }
}
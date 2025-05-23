using System.Threading.Tasks;
using System.Windows.Documents;
using Abschlussprojekt_Wochenplaner.Models.DAOs;
using Abschlussprojekt_Wochenplaner.Models.Entities;
using MySql.Data.MySqlClient;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task;

namespace Abschlussprojekt_Wochenplaner.Models.Services
{
    public class TodoService
    {
        public const string SlotInUseError = "Slot is already in use. Take another, move it or delete first!";

        TodoDAO todoDAO = new TodoDAO();
        TaskService taskService = new TaskService();

        //READ
        public List<Todo> GetAllTodosOnTheBoard(Board board) //for startup or loading a new Board
        {
            return todoDAO.GetAllTodosOfABoard(board.BoardId);
        }

        //Add
        public Todo AddATodoAndReturnItWithNewID(Todo newTodo)
        {
            Task task = newTodo.Task; //might be without ID
            Board board = newTodo.Board;
            int weekdayNumber = newTodo.WeekdayNumber;
            int slotNumber = newTodo.SlotNumber;

            if (todoDAO.CheckIfSlotIsNotEmpty(board.BoardId, weekdayNumber, slotNumber))
                throw new Exception(SlotInUseError); //TODO specify Exception Type later e.g. SlotFullException

            string state = "open";
            string? instanceNote = newTodo.InstanceNote;
            if (task.TaskId == 0)
                task = taskService.GetTaskBackWithID_CreateFirstIfNew(task); //creates task, if new or gets just id if not

            return todoDAO.CreateTodo(task, board, weekdayNumber, slotNumber, state, instanceNote);
        }

        //Edit (change belonging Task)
        //mind the cross or tick for done/undone / state != "open" (or restrict editing if state not open) --> remark to release
        public void EditTodoByTask(Todo changedTodo)
        {
            int todoId = changedTodo.TodoId;
            if (changedTodo.Task.TaskId == 0)
                changedTodo.Task = taskService.GetTaskBackWithID_CreateFirstIfNew(changedTodo.Task); //creates task, if new or gets just id if not

            todoDAO.UpdateTodoTask(todoId, changedTodo.Task.TaskId);
            changedTodo.State = "open";
        }

        //Delete
        public void RemoveTodo(Todo deletedTodo)
        {
            todoDAO.DeleteTodoById(deletedTodo.TodoId);
        }

        //Move
        public void MoveTodo(Todo movedTodo)
        {
            //1. detect whether weekday, slot or both changed
            //or just overwrite, no matter if same or not
            //might be more efficient than asking for the values first
            //2. then perform according action(s)
            int _TodoID = movedTodo.TodoId; //will not change
            int _weekdayNumber = movedTodo.WeekdayNumber;
            int _slotNumber = movedTodo.SlotNumber;

            if (todoDAO.CheckIfSlotIsNotEmpty(movedTodo.Board.BoardId, _weekdayNumber, _slotNumber))
                throw new Exception(SlotInUseError);

            if (_weekdayNumber != todoDAO.GetTodoById(_TodoID).WeekdayNumber) //only change if differs
                todoDAO.UpdateTodoWeekdayNumber(_TodoID, _weekdayNumber); //can also be done directly

            if (_slotNumber != todoDAO.GetTodoById(_TodoID).SlotNumber) //only change if differs
                todoDAO.UpdateTodoSlotNumber(_TodoID, _slotNumber); //can also be done directly
        }

        //Copy
        public Todo CopyTodo(Todo copiedTodo)
        {
            if (todoDAO.CheckIfSlotIsNotEmpty(copiedTodo.Board.BoardId, copiedTodo.WeekdayNumber, copiedTodo.SlotNumber))
                throw new Exception(SlotInUseError);

            return AddATodoAndReturnItWithNewID(copiedTodo);
        }

        //MarkAsDone
        public void MarkTodoAsDone(Todo doneTodo)
        {
            MarkTodoWithState(doneTodo, "done");
        }

        //MarkAsFailed
        public void MarkTodoAsFailed(Todo failedTodo)
        {
            MarkTodoWithState(failedTodo, "fail");
        }

        //DONE optional - markings: consider unmarking as open again if marked twice the same state
        private void MarkTodoWithState(Todo remarkedTodo, string newState)
        {
            int _TodoID = remarkedTodo.TodoId;
            string lastState = todoDAO.GetTodoById(_TodoID).State;
            const string unmark = "open";
            if (lastState.Equals(newState))
            { todoDAO.UpdateTodoState(_TodoID, unmark); remarkedTodo.State = unmark; }
            else
            { todoDAO.UpdateTodoState(_TodoID, newState); remarkedTodo.State = newState; }
        }

    }
}

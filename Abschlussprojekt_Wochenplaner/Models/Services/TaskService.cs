using Abschlussprojekt_Wochenplaner.Models.DAOs;
using MySql.Data.MySqlClient;
using Task = Abschlussprojekt_Wochenplaner.Models.Entities.Task;

namespace Abschlussprojekt_Wochenplaner.Models.Services
{
    public class TaskService
    {
        TaskDAO taskDAO = new TaskDAO();

        //should I check if a givenTask already exists in here to decide if it's gonna be saved or in ViewModel?
        public Task SaveNewTask(Task newTask) //notes won't be used in first version
        {
            string taskName = newTask.TaskName;
            string? generalNote = newTask.GeneralNote;
            return taskDAO.CreateTask(taskName, generalNote);
        }

        //TODO get TaskIDByName


        public Task GetTaskBackWithID_CreateFirstIfNew(Task task)
        {
            Task? taskWithID = taskDAO.GetTaskByName(task.TaskName);
            //TODO later on test is name the same but generalNoteChanged (and apply them only)
            if (taskWithID == null) 
                taskWithID = SaveNewTask(task);
            return taskWithID;
        }

        public bool IsNewTask(string taskName)
        {
            Task? testTask = taskDAO.GetTaskByName(taskName);
            //TODO later on test is name the same but generalNoteChanged (and apply them only)
            if (testTask == null)
                return true;
            return false;
        }
        

        public List<Task> GetAllTasksAsEntityList()  //tested successfully
        {
            return taskDAO.GetAllTasks();
        }

        //TODO don't forget to prefill givenTask table for having something to test early (and to chose from later)
        public List<String> GetAllTaskNamesAsStringList()   //tested successfully
        {
            //also used to check if already exists by text to decide if new should be saved in history or not
            //In case needed this way in a ListView or DropDown
            List<String> taskNames = new List<String>();
            foreach (Task task in GetAllTasksAsEntityList()) { taskNames.Add(task.TaskName); }
            return taskNames;
        }

        //Editing (updating) or deleting a givenTask is not intended for the first version but kept in mind for later
    }
}

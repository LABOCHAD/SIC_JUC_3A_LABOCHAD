using System;
using System.Windows.Input; // Needed for ICommand

namespace Abschlussprojekt_Wochenplaner.Utilities
{
    //Implements the ICommand Interface
    //Makes it possible to invoke a method via xaml command on GUI level (like an action listener in Java)
    //Here with Parameter/Generic Type <T> because the clicked slot is mandatory as argument to detect its position and content
    //Works like an Relay on electrician technology. It has no own business logic.
    //It forwards a signal to another place (control current comes in and switches payload current)
    //So the View sends the control current and the ViemModel "can make the electronic motor work".
    //I read this a typical mechanic in MVVM Pattern with WPF

    public class RelayCommand<T> : ICommand //With Type of ViewModel (Slot) because infos in it are needed
    {
        // Action to applay when command is called
        private readonly Action<T> _execute;
        // Optional function to determine if command can be executed
        private readonly Func<T, bool> _canExecute;

        //Triggered when executability status changed (can / cannot be done at the moment)
        // add and remove - View can check and enable or disable the command (OnClickAction) if needed
        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        
        //On Relay-Construction, Method (Action<T>) is passed and optionally checked if invokable now (Func<T, bool>), Exception if checked on null
        public RelayCommand(Action<T> execute, Func<T, bool> canExecute = null) 
        {
            _execute = execute ?? throw new ArgumentNullException(nameof(execute)); // x ?? -> if x is null, than do following statement
            _canExecute = canExecute; //else assign according argument for invokability check
        }

        // Called by WPF for check if Command can be executed
        public bool CanExecute(object parameter) //paremter (T) is from type BoardSlotViewModel (clickedSlot) when called because of slot click
        {
            // always true when Function check is null (how does this not contradict the exception in the constructor?) - never mind, I mixed up execute and canExecute
            if (_canExecute == null) return true;

            // Make sure passed object parameter is from type T and executable (return bool)
            return parameter is T typedParameter && _canExecute(typedParameter);
        }

        // Called by WPF, when command is actually supposed to be executed
        public void Execute(object parameter)
        {
            // Try to convert parameter in expected type and execute it
            if (parameter is T typedParameter)
            {
                _execute(typedParameter);
            }
        }
    }

    public class RelayCommand : ICommand //For side buttons those don't need to pass infos about them
    {
        private readonly Action _execute;
        private readonly Func<bool> _canExecute;

        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        public RelayCommand(Action execute, Func<bool> canExecute = null)
        {
            _execute = execute ?? throw new ArgumentNullException(nameof(execute));
            _canExecute = canExecute;
        }

        public bool CanExecute(object parameter)
        {
            return _canExecute == null || _canExecute();
        }

        public void Execute(object parameter)
        {
            _execute();
        }
    }
}

// Optional: For later if Commands needed without type parameters
/*
    public class RelayCommand : ICommand
    {
        private readonly Action _execute;
        private readonly Func<bool> _canExecute;

        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        public RelayCommand(Action execute, Func<bool> canExecute = null)
        {
            _execute = execute ?? throw new ArgumentNullException(nameof(execute));
            _canExecute = canExecute;
        }

        public bool CanExecute(object parameter)
        {
            return _canExecute == null || _canExecute();
        }

        public void Execute(object parameter)
        {
            _execute();
        }
    }
*/
using System.ComponentModel; // Needed for INotifyPropertyChanged
using System.Diagnostics;
using System.Runtime.CompilerServices;
using Abschlussprojekt_Wochenplaner.Models.Entities; // Needed for[CallerMemberName]

namespace Abschlussprojekt_Wochenplaner.ViewModels
{
    // Represents every cell in Board 7*7 Grid
    public class BoardSlotViewModel : INotifyPropertyChanged
    {
        private string _displayText = "";
        // Property for text in each cell, like "Test 1,1" --> Now this must become a Todo's test
        public string DisplayText
        {
            get => _displayText;
            set
            {
                if (_displayText != value) // Check if value actually changed
                {
                    _displayText = value;
                    OnPropertyChanged(nameof(DisplayText)); // Tell view text changed
                }
            }
        }

        private string _toolTipText = "";
        // Property for text in each cell, like "Test 1,1" --> Now this must become a Todo's test
        public string ToolTipText
        {
            get => _toolTipText;
            set
            {
                if (_toolTipText != value) // Check if value actually changed
                {
                    _toolTipText = value;
                    OnPropertyChanged(nameof(ToolTipText)); // Tell view text changed
                }
            }
        }

        //TODO add Textproperties for notes later for being shown as tooltips

        private bool _isSelected;
        // Property to determine if cell is selected
        public bool IsSelected
        {
            get => _isSelected;
            set
            {
                if (_isSelected != value)
                {
                    _isSelected = value;
                    OnPropertyChanged(nameof(IsSelected));
                }
            }
        }

        // Coordinate Properties from 1-7 each (Day -> x, Slot -> y)
        public int DayIndex { get; set; }
        public int SlotIndex { get; set; }

        private Todo? _todo;
        public Todo? Todo
        {
            get => _todo;
            set
            {
                _todo = value;
                if (value != null)
                {
                    DisplayText = value.Task.TaskName;
                    ToolTipText = (value.Task.GeneralNote == null) ? "" : value.Task.GeneralNote;
                }  
                else DisplayText = "";
            }
        }

        // Actually create a cell
        public BoardSlotViewModel(int dayIndex, int slotIndex)
        {
            DayIndex = dayIndex;
            SlotIndex = slotIndex;
        }

        // default stuff from Interface to make the GUI reactive to changes
        public event PropertyChangedEventHandler? PropertyChanged;
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

    }
}

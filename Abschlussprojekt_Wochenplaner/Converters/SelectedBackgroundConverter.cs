namespace Abschlussprojekt_Wochenplaner.Converters
{
    using System;
    using System.Globalization;
    using System.Windows.Data; // needed for IValueConverter
    using System.Windows.Media; // needed for Brush (Color)
    using System.Windows; // needed for Application.Current.FindResource

    public class SelectedBackgroundConverter : IValueConverter //converter interface
    {

        /* 
         * Actual converting method, View calls it and passes source element. Gets checked on selection and intended coloring is returned. (Source value to destination property) 
         * Explanation of parameters:
         * 
         * object value         that is actually to be converted, passed by the MainViewModel
         * 
         * Type targetType      specifies what we want to convert to (if source could become multiple types) 
         *                      (in my case it could be used to make sure return is a SolidColorBrush)
         *                      if val is 0 or 1 it could be bool or string... as true/false or yes/no
         *                      
         * object parameter     could be used to let the view pass additional information binded.
         *                      for example a currency symbol or here passing the color resource instead of make it been found by method below
         * 
         * CultureInfo culture  this is only needed if national formats must be considered like date and time format, not needed here
         * 
         */
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture) //only first is needed, but all have to be there due to the interface we are using
        {
            if (value is bool isSelected) // passed value must be a boolean
            {
                if (isSelected)
                {
                    // if selected return according color defined in App.xaml Resources -- light blue
                    return Application.Current.FindResource("SelectedSlotBrush");
                }
                else
                {
                    // if not return default (white)
                    return Application.Current.FindResource("DefaultSlotBrush");
                }
            }
            return Brushes.Transparent; // if something went wrong return transparent
        }

        // This would be the other way around (convert color to selection state), but that is not needed
        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture) //also there because of the interface
        {
            throw new NotImplementedException();
        }
    }
}

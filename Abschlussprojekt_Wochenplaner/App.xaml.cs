using System.Windows;
using Abschlussprojekt_Wochenplaner.Models.DAOs;
using Abschlussprojekt_Wochenplaner.Models.Services;

namespace Abschlussprojekt_Wochenplaner
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnExit(ExitEventArgs e)
        {
            base.OnExit(e);
            BoardDAO._connection.Close();
            TaskDAO._connection.Close();
            TodoDAO._connection.Close();
            //MessageBox.Show("Database closed"); //test
        }
    }
}

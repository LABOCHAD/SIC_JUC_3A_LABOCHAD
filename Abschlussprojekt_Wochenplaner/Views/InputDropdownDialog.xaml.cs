using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace Abschlussprojekt_Wochenplaner.Views // WICHTIG: Passe den Namespace an deine View-Struktur an!
{
    public partial class InputDropdownDialog : Window
    {
        // Diese Property speichert das finale Ergebnis (Auswahl oder eigene Eingabe)
        public string ResultValue { get; private set; }

        public InputDropdownDialog(List<string> taskNames, string defaultSelection = null)
        {
            InitializeComponent();

            // Fülle die ComboBox mit den übergebenen Tasknamen
            foreach (var taskName in taskNames)
            {
                cmbOptions.Items.Add(taskName);
            }

            // Setze die Standardauswahl, falls angegeben
            if (defaultSelection != null && cmbOptions.Items.Contains(defaultSelection))
            {
                cmbOptions.SelectedItem = defaultSelection;
            }
            else if (cmbOptions.Items.Count > 0)
            {
                cmbOptions.SelectedIndex = 0; // Wähle das erste Element, wenn keine Standardauswahl
            }

            // Initialisiere den OK-Button-Status
            UpdateOkButtonState();
        }

        private void OkButton_Click(object sender, RoutedEventArgs e)
        {
            // Priorisiere die eigene Eingabe, falls vorhanden
            if (!string.IsNullOrWhiteSpace(txtOtherInput.Text))
            {
                ResultValue = txtOtherInput.Text.Trim();
            }
            // Ansonsten nimm die Auswahl aus der ComboBox
            else if (cmbOptions.SelectedItem != null)
            {
                ResultValue = cmbOptions.SelectedItem.ToString();
            }
            else
            {
                ResultValue = null; // Kein gültiges Ergebnis
            }

            DialogResult = true; // Setze DialogResult auf true, um Erfolg zu signalisieren
            this.Close();        // Schließe den Dialog
        }

        private void CancelButton_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = false; // Setze DialogResult auf false, um Abbruch zu signalisieren
            this.Close();        // Schließe den Dialog
        }

        // Event-Handler, um die TextBox zu leeren, wenn in der ComboBox etwas ausgewählt wird
        private void CmbOptions_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (cmbOptions.SelectedItem != null && !string.IsNullOrEmpty(txtOtherInput.Text))
            {
                txtOtherInput.Text = string.Empty; // Leere eigene Eingabe bei Dropdown-Auswahl
            }
            UpdateOkButtonState();
        }

        // Event-Handler, um die ComboBox-Auswahl zurückzusetzen, wenn in der TextBox etwas eingegeben wird
        private void TxtOtherInput_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (!string.IsNullOrEmpty(txtOtherInput.Text) && cmbOptions.SelectedItem != null)
            {
                cmbOptions.SelectedItem = null; // Setze Dropdown-Auswahl zurück bei Texteingabe
            }
            UpdateOkButtonState();
        }

        // Hilfsmethode zur Steuerung des OK-Buttons
        private void UpdateOkButtonState()
        {
            // OK-Button ist aktiv, wenn entweder eine Option ausgewählt ODER Text eingegeben wurde
            bool canExecute = cmbOptions.SelectedItem != null || !string.IsNullOrWhiteSpace(txtOtherInput.Text);
            // Annahme: der OK-Button hat den Namen "OkButton" oder greif über dessen Content zu
            // Für diesen Fall nehmen wir an, dass der OK-Button ein Click-Handler hat und wir ihn hier nicht direkt deaktivieren müssen,
            // sondern die Logik im Click-Handler die Gültigkeit prüft.
            // Wenn du ihn visuell deaktivieren willst, müsstest du den Button per x:Name identifizieren und seine IsEnabled Property setzen.
            // Beispiel: ((Button)FindName("OkButton")).IsEnabled = canExecute; (nicht empfohlen, aber möglich)
        }
    }
}
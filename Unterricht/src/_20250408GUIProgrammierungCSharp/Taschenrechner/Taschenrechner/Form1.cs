namespace Taschenrechner
{
    public partial class Form1 : Form
    {

        string input = string.Empty; // aktuelle Eingabe
        string operand1 = string.Empty;
        string operand2 = string.Empty;
        char operation;
        double result = 0.0;
        bool operationPressed = false;

        public Form1()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, EventArgs e)
        {

            Button button = sender as Button;

            if (button != null)
            {
                string buttonText = button.Text;

                // Clear-Eingabe
                if (buttonText == "C")
                {
                    input = string.Empty;
                    operand1 = string.Empty;
                    operand2 = string.Empty;
                    operation = '\0';
                    result = 0.0;
                    operationPressed = false;
                    textBox1.Text = "";
                }

                // Zahl oder Punkt
                else if (char.IsDigit(buttonText, 0) || buttonText == ".")
                {
                    input += buttonText;
                    textBox1.Text += buttonText;
                }

                // Operator
                else if (buttonText == "+" || buttonText == "-" || buttonText == "*" || buttonText == "/")
                {
                    if (!string.IsNullOrEmpty(input))
                    {
                        operand1 = input;
                        input = string.Empty;
                        operation = buttonText[0];
                        operationPressed = true;
                        textBox1.Text += " " + buttonText + " ";
                    }
                }

                // Gleichheitszeichen
                else if (buttonText == "=")
                {
                    if (!string.IsNullOrEmpty(input) && !string.IsNullOrEmpty(operand1) && operationPressed)
                    {
                        operand2 = input;

                        double num1, num2;
                        double.TryParse(operand1, out num1);
                        double.TryParse(operand2, out num2);

                        switch (operation)
                        {
                            case '+':
                                result = num1 + num2;
                                break;
                            case '-':
                                result = num1 - num2;
                                break;
                            case '*':
                                result = num1 * num2;
                                break;
                            case '/':
                                result = num2 != 0 ? num1 / num2 : double.NaN;
                                break;
                        }

                        textBox1.Text = result.ToString();
                        input = result.ToString();
                        operand1 = string.Empty;
                        operand2 = string.Empty;
                        operationPressed = false;
                    }
                }

                // Vorzeichen ändern
                else if (buttonText == "+/-")
                {
                    if (double.TryParse(input, out double num))
                    {
                        num = -num;
                        input = num.ToString();
                        textBox1.Text = input;
                    }
                }
            }
        }
    }
}

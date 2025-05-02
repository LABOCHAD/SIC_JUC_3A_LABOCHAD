namespace MyFirstWindowsFormsC__App
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void clickMeButton_Click(object sender, EventArgs e)
        {
            textBox1.Text = "Ich wurde geklickt.";
        }


        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

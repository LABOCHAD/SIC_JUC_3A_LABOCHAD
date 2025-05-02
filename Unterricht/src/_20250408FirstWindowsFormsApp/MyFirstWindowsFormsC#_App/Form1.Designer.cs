namespace MyFirstWindowsFormsC__App
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            textBox1 = new TextBox();
            clickMeButton = new Button();
            SuspendLayout();
            // 
            // textBox1
            // 
            textBox1.Location = new Point(12, 37);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(280, 23);
            textBox1.TabIndex = 0;
            textBox1.Text = "Hallo";
            textBox1.TextChanged += textBox1_TextChanged;
            // 
            // clickMeButton
            // 
            clickMeButton.Location = new Point(12, 66);
            clickMeButton.Name = "clickMeButton";
            clickMeButton.Size = new Size(280, 25);
            clickMeButton.TabIndex = 1;
            clickMeButton.Text = "Klicke mich";
            clickMeButton.UseVisualStyleBackColor = true;
            clickMeButton.Click += clickMeButton_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(304, 201);
            Controls.Add(clickMeButton);
            Controls.Add(textBox1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBox1;
        private Button clickMeButton;
    }
}

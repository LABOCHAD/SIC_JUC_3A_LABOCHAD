using System.Security.Cryptography;

namespace MemoryGame
{
    partial class Form_MemoryGameUI_Extended
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
            tableLayoutPanel_Cards = new TableLayoutPanel();
            tableLayoutPanel_Cards.SuspendLayout();
            SuspendLayout();
            // 
            // tableLayoutPanel_Cards
            // 
            tableLayoutPanel_Cards.CellBorderStyle = TableLayoutPanelCellBorderStyle.Inset;
            tableLayoutPanel_Cards.ColumnCount = 4;
            tableLayoutPanel_Cards.Dock = DockStyle.Fill;
            tableLayoutPanel_Cards.Location = new Point(0, 0);
            tableLayoutPanel_Cards.Name = "tableLayoutPanel_Cards";
            tableLayoutPanel_Cards.RowCount = 4;
            tableLayoutPanel_Cards.Size = new Size(784, 561);
            tableLayoutPanel_Cards.TabIndex = 0;
          
            // Form_MemoryGameUI_Extended
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(784, 561);
            Controls.Add(tableLayoutPanel_Cards);
            FormBorderStyle = FormBorderStyle.Fixed3D;
            MaximizeBox = false;
            Name = "Form_MemoryGameUI_Extended";
            SizeGripStyle = SizeGripStyle.Hide;
            Text = "Memory Game";
            tableLayoutPanel_Cards.ResumeLayout(false);
            ResumeLayout(false);

            //adding buttons for cards to tableLayout and prepare
            for(int col = 0; col < 4; col++) //first down, then right
            {
                tableLayoutPanel_Cards.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
                tableLayoutPanel_Cards.RowStyles.Add(new RowStyle(SizeType.Percent, 25F));
                for (int row = 0; row < 4; row++) //tableLayoutPanel_Cards.Controls.Add(button16, 3, 3); from 0-3
                {
                    tableLayoutPanel_Cards.Controls.Add(new Button(), col, row);
                }
            }

            //applying all common things on all buttons
            int counter = 1; //shift naming because of the rest of the code
            foreach (Control control in tableLayoutPanel_Cards.Controls)
            {
                if (control != null && control is Button button)
                {
                    button.Name = $"button{counter}";
                    button.Dock = DockStyle.Fill;
                    button.Font = new Font("Segoe UI", 72F, FontStyle.Bold, GraphicsUnit.Point, 0);
                    button.ForeColor = color_hiddenAndBackground;
                    button.BackColor = color_hiddenAndBackground;
                    button.Click += AllButtons_Click;
                    counter++;
                }

            }
        }

        #endregion

        private TableLayoutPanel tableLayoutPanel_Cards;
    }
}

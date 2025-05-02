using System.Security.Cryptography;
using Microsoft.VisualBasic;

//all help I got by Gemini
//https://g.co/gemini/share/18e3d119c670

namespace MemoryGame
{
    //UNDO add a panel later to make also score be showable in a side panel next to gameplay
    partial class Form_MemoryGameUI_Basic //just for building up the UI elements
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
        /// 

        private void InitializeComponent() //partial AI assisted
        {
            components = new System.ComponentModel.Container();
            mainLayout = new TableLayoutPanel();
            infoPanel = new Panel();
            scoreLabel = new Label();
            timerLabel = new Label();
            restartButton = new Button();
            gamePanel = new Panel();
            timerGame = new System.Windows.Forms.Timer(components);
            mainLayout.SuspendLayout();
            infoPanel.SuspendLayout();
            SuspendLayout();
            // 
            // mainLayout
            // 
            mainLayout.ColumnCount = 2;
            mainLayout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 70F));
            mainLayout.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 30F));
            mainLayout.Controls.Add(infoPanel, 1, 0);
            mainLayout.Controls.Add(gamePanel, 0, 0);
            mainLayout.Dock = DockStyle.Fill;
            mainLayout.Location = new Point(0, 0);
            mainLayout.Name = "mainLayout";
            mainLayout.RowCount = 1;
            mainLayout.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            mainLayout.Size = new Size(980, 757);
            mainLayout.TabIndex = 0;
            // 
            // infoPanel
            // 
            infoPanel.Controls.Add(scoreLabel);
            infoPanel.Controls.Add(timerLabel);
            infoPanel.Controls.Add(restartButton);
            infoPanel.Dock = DockStyle.Fill;
            infoPanel.Location = new Point(689, 3);
            infoPanel.Name = "infoPanel";
            infoPanel.Size = new Size(288, 751);
            infoPanel.TabIndex = 1;
            // 
            // scoreLabel
            // 
            scoreLabel.AutoSize = true;
            scoreLabel.Location = new Point(0, 0);
            scoreLabel.Name = "scoreLabel";
            scoreLabel.Size = new Size(60, 15);
            scoreLabel.TabIndex = 0;
            scoreLabel.Text = "Score: 200";
            // 
            // timerLabel
            // 
            timerLabel.AutoSize = true;
            timerLabel.Location = new Point(10, 30);
            timerLabel.Name = "timerLabel";
            timerLabel.Size = new Size(50, 15);
            timerLabel.TabIndex = 1;
            timerLabel.Text = "Time: 0s";
            // 
            // restartButton
            // 
            restartButton.Location = new Point(10, 60);
            restartButton.Name = "restartButton";
            restartButton.Size = new Size(75, 23);
            restartButton.TabIndex = 2;
            restartButton.Text = "Restart";
            restartButton.Click += restartButton_Click;
            // 
            // gamePanel
            // 
            gamePanel.Dock = DockStyle.Fill;
            gamePanel.Location = new Point(3, 3);
            gamePanel.Name = "gamePanel";
            gamePanel.Size = new Size(680, 751);
            gamePanel.TabIndex = 0;
            // 
            // timerGame
            // 
            timerGame.Interval = 1000;
            timerGame.Tick += timerGame_Tick;
            // 
            // Form_MemoryGameUI_Basic
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            AutoSize = true;
            ClientSize = new Size(980, 757);
            Controls.Add(mainLayout);
            FormBorderStyle = FormBorderStyle.Fixed3D;
            MaximumSize = new Size(1920, 1080);
            Name = "Form_MemoryGameUI_Basic";
            Text = "Memory Game Basic";
            mainLayout.ResumeLayout(false);
            infoPanel.ResumeLayout(false);
            infoPanel.PerformLayout();
            ResumeLayout(false);
        }

        private void BuildGameTablePanel()
        {
            if (tableLayoutPanel_Cards != null)
            {
                tableLayoutPanel_Cards.Dispose();
            }

            tableLayoutPanel_Cards = new TableLayoutPanel();

            // 
            // tableLayoutPanel_Cards
            // 
            tableLayoutPanel_Cards.CellBorderStyle = TableLayoutPanelCellBorderStyle.Inset;
            tableLayoutPanel_Cards.Dock = DockStyle.Fill;
            tableLayoutPanel_Cards.Location = new Point(0, 0);
            tableLayoutPanel_Cards.Name = "tableLayoutPanel_Cards";
            tableLayoutPanel_Cards.Size = new Size(542, 555);
            tableLayoutPanel_Cards.TabIndex = 0;

            gamePanel.Controls.Add(tableLayoutPanel_Cards);

        }

        private void BuildTheButtons()
        {

            // Calculate letter size once per game board
            float letterSize = 120F;
            if (_cardCount >= 8) letterSize = 80F; // Slightly more aggressive reduction
            if (_cardCount >= 16) letterSize = 50F; // More aggressive reduction for 4x4+
            if (_cardCount >= 25) letterSize = 40F; // New breakpoint for 5x5+ (if applicable)
            if (_cardCount >= 36) letterSize = 30F; // More aggressive for 6x6+
            if (_cardCount >= 49) letterSize = 25F; // New breakpoint for 7x7+
            if (_cardCount >= 64) letterSize = 20F; // Even smaller for 8x8
            using (Font buttonFont = new Font("Segoe UI", letterSize, FontStyle.Bold, GraphicsUnit.Point, 0))
            {
                tableLayoutPanel_Cards.SuspendLayout(); // Suspend layout

                // Adding buttons for cards to tableLayout
                int buttonNumCount = 0;
                for (int col = 0; col < size; col++)
                {
                    tableLayoutPanel_Cards.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, (100 / size)));
                    tableLayoutPanel_Cards.RowStyles.Add(new RowStyle(SizeType.Percent, (100 / size)));
                    for (int row = 0; row < size; row++)
                    {
                        if (col == size - 1 && row == size - 1 && (size % 2 != 0)) break; //avoiding last odd card
                        else
                        {
                            Button button = new Button();
                            button.Name = $"button{buttonNumCount}";
                            button.TabIndex = buttonNumCount;
                            button.Dock = DockStyle.Fill;
                            button.Font = buttonFont;
                            button.BackgroundImage = _cardBackImage; // Initialize with background
                            button.BackgroundImageLayout = ImageLayout.Stretch;
                            button.Click += AllButtons_Click;
                            tableLayoutPanel_Cards.Controls.Add(button, col, row);
                            button.Tag = ""; // Initially no image key assigned
                            buttonNumCount++;
                        }
                    }
                }
                tableLayoutPanel_Cards.ResumeLayout(true); // Resume layout

            }
        }

        private void StartNewGame()
        {
            // 1. Reset Game State
            moves = 0;
            bools_revealedCorrectly = new bool[_cardCount];
            strings_lastTwoSymbols = new string[2];
            buttons_lastTwoButtonsPressed = new Button[2];
            score = 200; // Reset score
            seconds = 0; // Reset seconds

            BuildGameTablePanel();
            BuildTheButtons();
            AssignCardsToButtons(); //must be done after buttons are created

            scoreLabel.Text = "Score: 200";
            timerLabel.Text = "Time: 0s";

            timerGame.Start();

        }

        #endregion
        private TableLayoutPanel tableLayoutPanel_Cards;
        private TableLayoutPanel mainLayout;
        private Panel gamePanel;
        private Panel infoPanel;
        private Label scoreLabel;
        private Label timerLabel;
        private Button restartButton;
        private System.Windows.Forms.Timer timerGame;
    }
}

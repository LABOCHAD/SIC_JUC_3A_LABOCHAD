namespace WindowsForms_Library
{
    partial class Form_Main
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
            tableLayoutPanel_bookData = new TableLayoutPanel();
            label_title = new Label();
            label_Author = new Label();
            textBox_title = new TextBox();
            label_publicationYear = new Label();
            label_genre = new Label();
            label_ISBN = new Label();
            textBox_author = new TextBox();
            textBox_publicationYear = new TextBox();
            textBox_genre = new TextBox();
            textBox_ISBN = new TextBox();
            flowLayoutPanel1 = new FlowLayoutPanel();
            button_saveBook = new Button();
            button_searchForABook = new Button();
            textBox_book_id = new TextBox();
            groupBox_BasicBookData = new GroupBox();
            button_CountBooks = new Button();
            tableLayoutPanel_bookData.SuspendLayout();
            flowLayoutPanel1.SuspendLayout();
            groupBox_BasicBookData.SuspendLayout();
            SuspendLayout();
            // 
            // tableLayoutPanel_bookData
            // 
            tableLayoutPanel_bookData.ColumnCount = 2;
            tableLayoutPanel_bookData.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 25F));
            tableLayoutPanel_bookData.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 75F));
            tableLayoutPanel_bookData.Controls.Add(label_title, 0, 0);
            tableLayoutPanel_bookData.Controls.Add(label_Author, 0, 1);
            tableLayoutPanel_bookData.Controls.Add(textBox_title, 1, 0);
            tableLayoutPanel_bookData.Controls.Add(label_publicationYear, 0, 2);
            tableLayoutPanel_bookData.Controls.Add(label_genre, 0, 3);
            tableLayoutPanel_bookData.Controls.Add(label_ISBN, 0, 4);
            tableLayoutPanel_bookData.Controls.Add(textBox_author, 1, 1);
            tableLayoutPanel_bookData.Controls.Add(textBox_publicationYear, 1, 2);
            tableLayoutPanel_bookData.Controls.Add(textBox_genre, 1, 3);
            tableLayoutPanel_bookData.Controls.Add(textBox_ISBN, 1, 4);
            tableLayoutPanel_bookData.Location = new Point(6, 22);
            tableLayoutPanel_bookData.Name = "tableLayoutPanel_bookData";
            tableLayoutPanel_bookData.RowCount = 5;
            tableLayoutPanel_bookData.RowStyles.Add(new RowStyle(SizeType.Percent, 20F));
            tableLayoutPanel_bookData.RowStyles.Add(new RowStyle(SizeType.Percent, 20F));
            tableLayoutPanel_bookData.RowStyles.Add(new RowStyle(SizeType.Percent, 20F));
            tableLayoutPanel_bookData.RowStyles.Add(new RowStyle(SizeType.Percent, 20F));
            tableLayoutPanel_bookData.RowStyles.Add(new RowStyle(SizeType.Percent, 20F));
            tableLayoutPanel_bookData.Size = new Size(543, 155);
            tableLayoutPanel_bookData.TabIndex = 0;
            // 
            // label_title
            // 
            label_title.Anchor = AnchorStyles.Left;
            label_title.AutoSize = true;
            label_title.Location = new Point(3, 8);
            label_title.Name = "label_title";
            label_title.Size = new Size(29, 15);
            label_title.TabIndex = 0;
            label_title.Text = "Title";
            // 
            // label_Author
            // 
            label_Author.Anchor = AnchorStyles.Left;
            label_Author.AutoSize = true;
            label_Author.Location = new Point(3, 39);
            label_Author.Name = "label_Author";
            label_Author.Size = new Size(103, 15);
            label_Author.TabIndex = 1;
            label_Author.Text = "Author (ID/Name)";
            // 
            // textBox_title
            // 
            textBox_title.Location = new Point(138, 3);
            textBox_title.Name = "textBox_title";
            textBox_title.Size = new Size(402, 23);
            textBox_title.TabIndex = 2;
            // 
            // label_publicationYear
            // 
            label_publicationYear.Anchor = AnchorStyles.Left;
            label_publicationYear.AutoSize = true;
            label_publicationYear.Location = new Point(3, 70);
            label_publicationYear.Name = "label_publicationYear";
            label_publicationYear.Size = new Size(92, 15);
            label_publicationYear.TabIndex = 2;
            label_publicationYear.Text = "Publication Year";
            // 
            // label_genre
            // 
            label_genre.Anchor = AnchorStyles.Left;
            label_genre.AutoSize = true;
            label_genre.Location = new Point(3, 101);
            label_genre.Name = "label_genre";
            label_genre.Size = new Size(38, 15);
            label_genre.TabIndex = 3;
            label_genre.Text = "Genre";
            // 
            // label_ISBN
            // 
            label_ISBN.Anchor = AnchorStyles.Left;
            label_ISBN.AutoSize = true;
            label_ISBN.Location = new Point(3, 132);
            label_ISBN.Name = "label_ISBN";
            label_ISBN.Size = new Size(32, 15);
            label_ISBN.TabIndex = 4;
            label_ISBN.Text = "ISBN";
            // 
            // textBox_author
            // 
            textBox_author.Location = new Point(138, 34);
            textBox_author.Name = "textBox_author";
            textBox_author.Size = new Size(402, 23);
            textBox_author.TabIndex = 2;
            // 
            // textBox_publicationYear
            // 
            textBox_publicationYear.Location = new Point(138, 65);
            textBox_publicationYear.Name = "textBox_publicationYear";
            textBox_publicationYear.Size = new Size(402, 23);
            textBox_publicationYear.TabIndex = 2;
            // 
            // textBox_genre
            // 
            textBox_genre.Location = new Point(138, 96);
            textBox_genre.Name = "textBox_genre";
            textBox_genre.Size = new Size(402, 23);
            textBox_genre.TabIndex = 2;
            // 
            // textBox_ISBN
            // 
            textBox_ISBN.Location = new Point(138, 127);
            textBox_ISBN.Name = "textBox_ISBN";
            textBox_ISBN.Size = new Size(402, 23);
            textBox_ISBN.TabIndex = 2;
            // 
            // flowLayoutPanel1
            // 
            flowLayoutPanel1.Controls.Add(button_saveBook);
            flowLayoutPanel1.Controls.Add(button_searchForABook);
            flowLayoutPanel1.Controls.Add(textBox_book_id);
            flowLayoutPanel1.Controls.Add(button_CountBooks);
            flowLayoutPanel1.Location = new Point(22, 12);
            flowLayoutPanel1.Name = "flowLayoutPanel1";
            flowLayoutPanel1.Size = new Size(539, 30);
            flowLayoutPanel1.TabIndex = 1;
            // 
            // button_saveBook
            // 
            button_saveBook.Font = new Font("Segoe UI", 9F, FontStyle.Bold | FontStyle.Italic | FontStyle.Underline, GraphicsUnit.Point, 0);
            button_saveBook.Location = new Point(3, 3);
            button_saveBook.Name = "button_saveBook";
            button_saveBook.Size = new Size(122, 23);
            button_saveBook.TabIndex = 0;
            button_saveBook.Text = "Save Book";
            button_saveBook.UseVisualStyleBackColor = true;
            button_saveBook.Click += button_saveBook_Click;
            // 
            // button_searchForABook
            // 
            button_searchForABook.Enabled = false;
            button_searchForABook.Location = new Point(131, 3);
            button_searchForABook.Name = "button_searchForABook";
            button_searchForABook.Size = new Size(113, 23);
            button_searchForABook.TabIndex = 1;
            button_searchForABook.Text = "Search for a book";
            button_searchForABook.UseVisualStyleBackColor = true;
            button_searchForABook.Click += button_searchForABook_Click;
            // 
            // textBox_book_id
            // 
            textBox_book_id.Location = new Point(250, 3);
            textBox_book_id.Name = "textBox_book_id";
            textBox_book_id.PlaceholderText = "Type in a book ID here";
            textBox_book_id.Size = new Size(134, 23);
            textBox_book_id.TabIndex = 2;
            // 
            // groupBox_BasicBookData
            // 
            groupBox_BasicBookData.Controls.Add(tableLayoutPanel_bookData);
            groupBox_BasicBookData.Location = new Point(12, 48);
            groupBox_BasicBookData.Name = "groupBox_BasicBookData";
            groupBox_BasicBookData.Size = new Size(562, 180);
            groupBox_BasicBookData.TabIndex = 2;
            groupBox_BasicBookData.TabStop = false;
            groupBox_BasicBookData.Text = "Basic Book Data";
            // 
            // button_CountBooks
            // 
            button_CountBooks.Location = new Point(390, 3);
            button_CountBooks.Name = "button_CountBooks";
            button_CountBooks.Size = new Size(146, 23);
            button_CountBooks.TabIndex = 3;
            button_CountBooks.Text = "Show Count of Books";
            button_CountBooks.UseVisualStyleBackColor = true;
            button_CountBooks.Click += button_CountBooks_Click;
            // 
            // Form_Main
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(578, 234);
            Controls.Add(groupBox_BasicBookData);
            Controls.Add(flowLayoutPanel1);
            Name = "Form_Main";
            Text = "Library Application";
            Load += Form1_Load;
            tableLayoutPanel_bookData.ResumeLayout(false);
            tableLayoutPanel_bookData.PerformLayout();
            flowLayoutPanel1.ResumeLayout(false);
            flowLayoutPanel1.PerformLayout();
            groupBox_BasicBookData.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private TableLayoutPanel tableLayoutPanel_bookData;
        private FlowLayoutPanel flowLayoutPanel1;
        private Button button_saveBook;
        private TextBox textBox_book_id;
        private Button button_searchForABook;
        private GroupBox groupBox_BasicBookData;
        private Label label_title;
        private Label label_Author;
        private Label label_publicationYear;
        private Label label_genre;
        private Label label_ISBN;
        private TextBox textBox_title;
        private TextBox textBox_author;
        private TextBox textBox_publicationYear;
        private TextBox textBox_genre;
        private TextBox textBox_ISBN;
        private Button button_CountBooks;
    }
}

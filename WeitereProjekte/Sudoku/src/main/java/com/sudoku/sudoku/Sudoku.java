package com.sudoku.sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Sudoku extends Application {
    private static final int SIZE = 9;
    private TextField[][] cells;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sudoku Solver");

        GridPane grid = new GridPane();
        cells = new TextField[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new TextField();
                cells[i][j].setPrefWidth(50);
                cells[i][j].setPrefHeight(50);
                cells[i][j].setStyle("-fx-alignment: center;");
                grid.add(cells[i][j], j, i);

                // Hinzufügen der dicken Linien nur um die 3x3-Untergitter
                BorderStrokeStyle style = BorderStrokeStyle.SOLID;
                BorderWidths borderWidths = new BorderWidths(
                        (i % 3 == 0 && i != 0) ? 2 : 1,
                        ((j + 1) % 3 == 0 && j != SIZE - 1) ? 2 : 1,
                        ((i + 1) % 3 == 0 && i != SIZE - 1) ? 2 : 1,
                        (j % 3 == 0 && j != 0) ? 2 : 1
                );
                cells[i][j].setBorder(new Border(new BorderStroke(Color.BLACK, style, CornerRadii.EMPTY, borderWidths)));
            }
        }

        // Vorab gefülltes Sudoku-Rätsel generieren
        int[][] board = generateSudoku();
        fillRandomCells(board, 10);

        Button solveButton = new Button("Solve");
        solveButton.setOnAction(e -> solveSudoku());

        VBox vbox = new VBox(grid, solveButton);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 450, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillRandomCells(int[][] board, int numCells) {
        //TODO Implements me please
    }

    private int[][] generateSudoku() {
        //TODO Implements me please
    }

    private void solveSudoku() {
        //TODO Implements me please
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sudoku Solver");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class SudokuSolver {
    private static final int SIZE = 9;
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        //TODO Implements me please
    }

    private boolean isValid(int num, int row, int col) {
        //TODO Implements me please
    }

    public int[][] getBoard() {
        return board;
    }
}

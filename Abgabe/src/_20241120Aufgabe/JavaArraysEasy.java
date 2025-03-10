package _20241120Aufgabe;
/**
Leichte Aufgaben:
1) Erstellen Sie ein 2D-Array der Größe 5x5.
2) Füllen Sie das gesamte Array mit dem Wert "1" und geben Sie es als Quadrat im Terminal aus.
3) Füllen Sie das gesamte Array mit dem Wert "~" und geben Sie es als Quadrat im Terminal aus.
4) Wiederholen Sie die Aufgaben 2 und 3 mit einem 2D-Array der Größe `5 x 10` und drucken Sie es als
Rechteck aus.
 */

public class JavaArraysEasy {

    /**
     * Creates arrays as tasks tells us to.
     * Redundant functionalities have been outsourced.
     * Passes arrays each and char in case of filling.
     * @param args not considered.
     */
    public static void main(String[] args) {
        //Task 1
        char[][] table5x5 = new char[5][5];

        //Task 2
        fill2DCharArray(table5x5, '1');
        show2DCharArray(table5x5);

        //Task 3
        fill2DCharArray(table5x5, '~');
        show2DCharArray(table5x5);

        //Task 4
        char[][] table5x10 = new char[5][10];
        //Repeating task 2
        refillAndShowTable(table5x10, '1');

        //repeating task 3
        refillAndShowTable(table5x10, '~');



    }

    /**
     * Here just an encapsulating method
     * for fulfilling the task easier.
     * Calls filling and showing together.
     * Simply passes through parameters.
     * Why? Because I can.
     * @param passedArray passed table
     * @param passesChar passed char
     */
    static void refillAndShowTable(char[][] passedArray, char passesChar){
        fill2DCharArray(passedArray, passesChar);
        show2DCharArray(passedArray);
    }

    /**
     * Because tasks says array should be displayed twice, and we don't want to repeat ourselves
     * Uses enhanced (nested) for loop in order I could practice it again.
     * As long as no indexes are being needed to be called by iterator
     * that's not iterating indexes themselves, it won't be complicated.
     * (Could also be solved like the loop in the method for filling.)
     * @param arrayToBeShown is passed as the table from main.
     */
    static void show2DCharArray(char[][] arrayToBeShown) {
        //for Display later
        System.out.println();
        for (char[] row : arrayToBeShown) { //iterate through 2d with 1d / though table by rows
            for (char col : row) { //iterate through 1d with single char / through row by col each
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /**
     * Also filling is required more than once.
     * So it got outsourced with accepting array.
     * Changed from type char[][] to void method,
     * because it turned out an array is passed
     * by reference and not by value like data
     * of primitive types, same with ArrayLists.
     * In consequence the array will be treated
     * like it is a global variable along class.
     * @param arrayToBeFilled table from main.
     * @param wantedChar char to set all along.
     */
    static void fill2DCharArray (char[][] arrayToBeFilled, char wantedChar) {
        for (int row = 0; row < arrayToBeFilled.length; row++){ //2DArr.length = count of rows
            for (int col = 0; col < arrayToBeFilled[0].length; col++){ //2DArr[0].length = count of cols (in row)
                arrayToBeFilled[row][col] = wantedChar;
            }
        }
    }
}

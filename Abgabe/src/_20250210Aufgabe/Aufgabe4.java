package _20250210Aufgabe;

import java.util.Random;

public class Aufgabe4 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        //Befüllen mit Zufallszahlen
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                    matrix[i][j] = random.nextInt(1,10);
            }
        }

        //Ausgabe Matrix mit Zeilensummen
        System.out.print("\nMatrix:");
        for (int i = 0; i < matrix.length; i++){
            int rowSum = 0;

            System.out.println();
            //Ausgeben der Zeilen, Bildung der Zeilensummen
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "  ");
                rowSum += matrix[i][j]; //add up rowSum by colVals

                if (j == matrix[i].length-1){ //When last col print sum of row
                    System.out.print("| " + rowSum);
                }
            }
        }

        //Bildung der Spaltensummen
        int[] colSums = new int[matrix.length];
        for (int col = 0; col < matrix[0].length; col++){
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++){
                colSum += matrix[row][col];
            }
            colSums[col] = colSum;
        }

        //Ausgabe der Spaltensummen
        System.out.println("\n-----------------");
        for(int sum : colSums){
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}

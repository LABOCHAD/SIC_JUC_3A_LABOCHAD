package _20250210Aufgabe;

public class Aufgabe3 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        //Befüllung
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (i == j)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }

        //Ausgabe
        for (int[] i : matrix){
            System.out.println();
            for(int j : i){
                System.out.print(j + "  ");
            }
        }
        System.out.println();
    }
}

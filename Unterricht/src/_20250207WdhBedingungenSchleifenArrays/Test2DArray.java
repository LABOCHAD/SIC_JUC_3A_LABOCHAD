package _20250207WdhBedingungenSchleifenArrays;

public class Test2DArray {
    public static void main(String[] args) {
        int[][] cArray = {{1, 2, 3, 4}, {1, 2, 3}, {1, 2, 3, 4, 5, 6}};
        for (int i = 0; i < cArray.length; i++) {
            System.out.println("Zeile " + (i + 1));
            for (int j = 0; j < cArray[i].length; j++) {
                System.out.print(cArray[i][j] + ((j < cArray[i].length - 1) ? ", " : ""));
            }
            System.out.println();
        }
    }

}

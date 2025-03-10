package _20241120Aufgabe;
/*
https://www.codingrooms.com/blog/2d-array-length-java
For me to learn how to get multidimensional array length.
 */


public class ArrayLength2DExample {
    //has 10 rows and 5 columns (each)
    public static int[][] exampleVariableOne = new int[10][5];

    // returns the length of the rows in the array
    public static int lengthOne = exampleVariableOne.length;

    // returns the length of the columns in the array
    public static int lengthTwo = exampleVariableOne[0].length;

    public static void main(String[] args) {
        System.out.println(lengthOne);
        System.out.println(lengthTwo);

        /*
        So this means with an example2DArr[][]
        example2DArr.length = count of rows
        example2DArr[0].length = count of cols (in row)

         */

    }
}
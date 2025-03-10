package _20250211WdhExceptions;

public class Übung_RunTimeException {
    public static void main(String[] args) {
        causeArrayOutOfBoundsException();
        causeNullPointerException();
    }

    static void causeArrayOutOfBoundsException(){
      int[] array = new int[10];
        System.out.println(array[10]); //of by one intentionally, hihi
    }
    static void causeNullPointerException(){
        int[] array = null;
        System.out.println(array[10]);
    }

}

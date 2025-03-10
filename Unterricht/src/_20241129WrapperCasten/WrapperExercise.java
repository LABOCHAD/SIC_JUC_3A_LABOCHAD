package _20241129WrapperCasten;

public class WrapperExercise {
    public static void main(String[] args) {
        //1
        String numStr = "123";
        Integer numIntObj = Integer.valueOf(numStr); //parseInt() -> primitive, valueOf() -> wrapper object
        System.out.println(numIntObj.toString());

        //2
        Integer test1 = 123;
        Integer test2 = 456;
        Integer test3 = 123;

        System.out.println("If " + test1 + " equals " + test2 + " output is 0 else -1: " + test1.compareTo(test2)); //not equals
        System.out.println("If " + test1 + " equals " + test3 + " output is 0 else -1: " + test1.compareTo(test3)); //equals
    }
}

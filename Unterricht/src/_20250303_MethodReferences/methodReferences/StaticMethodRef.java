package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class StaticMethodRef {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4");
        List<Integer> listInt = Arrays.asList(1,2,3,4);

        list.replaceAll(StaticMethodRef::concatString);
        listInt.replaceAll(StaticMethodRef::printSquare);

        System.out.println(list);
        System.out.println(listInt);
    }

    private static String concatString(String s){
        return s + "Hallo";
    }

    private static int printSquare(int number){
        return number*number;
    }
}

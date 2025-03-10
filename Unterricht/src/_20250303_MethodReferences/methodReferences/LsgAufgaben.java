package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.List;

public class LsgAufgaben {
}
class MathHelper {
    public static int doubleTheValue(int value) {
        return value * 2;
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1,2,3,4);
        numberList.replaceAll(MathHelper::doubleTheValue);


        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        bikeBrands.sort(String::compareTo);
        bikeBrands.forEach(System.out::println);

        bikeBrands.forEach(Main::printLength);
    }

    public static void printLength(String word) {
        System.out.println(word.length());
    }
}

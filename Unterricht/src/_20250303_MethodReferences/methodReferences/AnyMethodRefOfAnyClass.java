package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.List;

public class AnyMethodRefOfAnyClass {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Joe");
        list.replaceAll(String::toUpperCase);
        list.forEach(System.out::println);
    }
}

package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaVsMethodRef {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.forEach(item -> System.out.println(item));
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String item) {
                System.out.println(item);
            }
        });

        list.forEach(item -> {
            System.out.println("Schaue nach dem nächsten Element. Ob es mit a beginnt?");
            if(item.startsWith("a")){
                System.out.println(item);
            }else{
                System.out.println("Element startet nicht mit a");
            }

        });
    }
}

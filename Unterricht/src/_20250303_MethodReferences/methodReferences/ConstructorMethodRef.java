package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ConstructorMethodRef {
    public static void main(String[] args) {
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        List<Bicycle> bicycleList =
                bikeBrands
                        .stream()           //konvertiert Liste zu Stream
                        .map(Bicycle::new)  //ändert String-Objekt zu Bicycle-Objekt
                        .collect(Collectors.toList());  //erstellt aus dem Stream wieder eine Liste
        //bicycleList.forEach(i -> System.out.println(i.getBrand()));


        Function<String, Bicycle> bicycleFunction = Bicycle::new;
         //<T> the type of the input to the function
         //<R> the type of the result of the function

        for(String brand: bikeBrands){
            System.out.println(bicycleFunction.apply(brand).getBrand());
        }

        BiFunction<String, Integer, Bicycle> bicycleBiFunction = Bicycle::new;

    }
}

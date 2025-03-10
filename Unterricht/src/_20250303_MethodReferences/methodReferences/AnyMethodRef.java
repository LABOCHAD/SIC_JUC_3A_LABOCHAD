package _20250303_MethodReferences.methodReferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnyMethodRef {
    public static void main(String[] args) {
        BicycleBrandComparator bicycleBrandComparator = new BicycleBrandComparator();
        List<Bicycle> bicycleList = Arrays.asList(new Bicycle("Canyon"),
                new Bicycle("BMC"), new Bicycle("Pegasus"));

        bicycleList.sort(bicycleBrandComparator::compare);
        bicycleList.forEach(bicycle -> System.out.println(bicycle.getBrand()));
    }
}

class Bicycle{
    private String brand;
    Bicycle(String brand){
        this.brand = brand;
    }

    Bicycle(String brand, int age){

    }

    public String getBrand() {
        return brand;
    }
}

class BicycleBrandComparator {
    public int compare(Bicycle a, Bicycle b){
       return a.getBrand().compareTo(b.getBrand());
    }
}
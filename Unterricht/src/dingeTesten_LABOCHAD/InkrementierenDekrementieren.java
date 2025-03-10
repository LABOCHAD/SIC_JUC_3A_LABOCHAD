package dingeTesten_LABOCHAD;

public class InkrementierenDekrementieren {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("Inkrementieren von x=5 mit x++: " + x++);
        x = 5;
        System.out.println("Inkrementieren von x=5 mit ++x: " + ++x);
        x = 5;
        System.out.println("Dekrementieren von x=5 mit x--: " + x--);
        x = 5;
        System.out.println("Dekrementieren von x=5 mit --x; " + --x);
        System.out.println();
        x = 5;
        System.out.println("Inkrementieren von x=5 mit x+1: " + x+1); //String Addition
        x = 5;
        System.out.println("Inkrementieren von x=5 mit (x+1): " + (x+1)); // int Addition
        x = 5;
        System.out.println("Inkrementieren von x=5 mit (x+=1): " + (x+=1)); // int Addition
    }


}

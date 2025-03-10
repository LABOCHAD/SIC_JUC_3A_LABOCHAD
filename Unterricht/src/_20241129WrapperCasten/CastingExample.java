package _20241129WrapperCasten;

public class CastingExample {
    public static void main(String[] args) {

        //Beispiel widening casting
        int num = 10;
        double doubleNum = num;  // Automatisches Casting von int zu double

        System.out.println("Der Wert von num (int): " + num);
        System.out.println("Der Wert von doubleNum (double): " + doubleNum);

        //Beispiel narrowing casting
        double doubleNum2 = 9.99;
        int intNum = (int) doubleNum;  // Manuelles Casting von double zu int

        System.out.println("Der Wert von doubleNum (double): " + doubleNum2);
        System.out.println("Der Wert von intNum (int): " + intNum);
    }
}

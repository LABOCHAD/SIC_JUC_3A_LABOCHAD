package _20241129WrapperCasten;

public class CastingExercise {
    public static void main(String[] args) {
        int numInt = 5;
        System.out.println("Integer: " + numInt);

        double numDbl = 9.999996;
        System.out.println("Double: " + numDbl);

        float numFlt = 69.0F;
        System.out.println("Float: " + numFlt);

        char chr = '7';
        System.out.println("Character: " + chr);

        boolean bool = true;
        System.out.println("Boolean: " + bool);

        long lngFromInt = numInt;
        System.out.printf("%nFrom Integer %d to long: %d", numInt, lngFromInt);
        double dblFromFlt = numFlt;
        System.out.printf("%nFrom Float %.2f to Double: %.2f", numFlt, dblFromFlt);

        int intFromDbl = (int) dblFromFlt;
        System.out.printf("%nFrom Double %.2f to Integer: %d", dblFromFlt, intFromDbl);

        short shtFromLng = (short) lngFromInt;
        System.out.printf("%nFrom Long %d to short: %d%n", lngFromInt, shtFromLng);

        //_______________
        int intFromBol = bool ? 1 : 0; //no method found for casting true to 1 directly
        System.out.println("Cast boolean to 0/1 indirectly: " + intFromBol);
        int intASCIFromChr = (int) chr;

        System.out.println("Integer from digit char " + chr + " (as ASCI-Code): " + intASCIFromChr); //https://www.ascii-code.com/55

        int intFromChr = Character.digit(chr, 10);
        System.out.println("Integer from digit char " + chr + " as itself: " + intFromChr);
    }
}

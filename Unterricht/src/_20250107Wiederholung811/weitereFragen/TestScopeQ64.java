package _20250107Wiederholung811.weitereFragen;

public class TestScopeQ64 {
    public static void main(String[] args) {
        int var1 = 200;
        System.out.print(doCalc(var1)); // 400 Rückgabe
        System.out.print(" " + var1); //200, wurde nicht verändert, anderes war Rückgabe
    }

    static int doCalc(int var2) {
        return var2 * 2;
    }
}

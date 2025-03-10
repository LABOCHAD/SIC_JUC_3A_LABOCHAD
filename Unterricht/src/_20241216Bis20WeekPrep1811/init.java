package _20241216Bis20WeekPrep1811;

public class init {

    public static void main(String[] args) {
        //Frage 7 (Oraclesimulation II)
        /*int x = 3;
        //((1+x) * 5 / x ) - 1 + (-1 + x)
        int y = ++x * 5 / x-- + --x;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
*/
        //Anmerkung: ++x oder --x: Hier wird zuerst inkrementiert/dekrementiert
        //           x++ oder x--: Hier wird anschließend (bspw. nach Berechnungen) inkrementiert/dekrementiert

        //Frage 15
        for(int i = 0; i<3; i++){
            for (int j = 0; j<2; j++){
                System.out.println("i: " +i);
                System.out.println("j: " +j);
                System.out.println(i * j + " ");
            }
        }
    }
}

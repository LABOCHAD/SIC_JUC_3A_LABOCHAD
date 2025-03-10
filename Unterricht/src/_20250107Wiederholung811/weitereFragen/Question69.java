package _20250107Wiederholung811.weitereFragen;

public class Question69 {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(1); //new Integer() ist veraltet
        //short und byte mit x = 1 gehen auch, long und double nicht und String auch nicht wegen der "
        switch (x) {
            case 1:
                System. out.println ("One");
                break;
            case 2:
                System. out. println ("Two");
                break;
        }
    }
}

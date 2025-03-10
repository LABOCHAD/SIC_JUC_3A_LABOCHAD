package _20250210GarbageCollector.garbageCollector;

public class EinfachesBeispiel {
    EinfachesBeispiel eB;

    public static void main(String[] args) {
        EinfachesBeispiel eb1 = new EinfachesBeispiel();
        EinfachesBeispiel eb2 = new EinfachesBeispiel();
        EinfachesBeispiel eb3 = new EinfachesBeispiel();

        eb1.eB = eb2;
        eb2.eB = eb3;
        eb3.eB = eb1;

        eb1 = null;
        eb2 = null;
        eb3 = null;
    }
}

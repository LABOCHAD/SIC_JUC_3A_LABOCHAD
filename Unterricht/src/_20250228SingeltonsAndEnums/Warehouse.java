package _20250228SingeltonsAndEnums;

class Warehouse {
    private static Warehouse instance;
    private int noodlePackages;
    private Warehouse() {
        noodlePackages = 100;
    }
    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }
    public void addBestand(int menge) {
        noodlePackages += menge;
        System.out.println("Bestand erhöht. Neuer Bestand: " + noodlePackages);
    }
    public void removeBestand(int menge) {
        if (menge <= noodlePackages) {
            noodlePackages -= menge;
            System.out.println("Bestand verringert. Neuer Bestand: " + noodlePackages);
        } else {
            System.out.println("Nicht genügend Bestand verfügbar!");
        }
    }
    public int getBestand() {
        return noodlePackages;
    }
}
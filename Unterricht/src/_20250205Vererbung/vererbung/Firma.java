package _20250205Vererbung.vererbung;

class Mitarbeiter {
    public void arbeitet() {
        System.out.println("Ich arbeite einfach");
    }

    protected void faehrtBus() {
        System.out.println("Ich fahre Bus");
    }
}

class Abteilungsleiter extends Mitarbeiter {
    private Mitarbeiter[] untergebene;

    public void arbeitet() {
        System.out.println("Ich leite eine Abteilung");
    }

    public void faehrtLambo() {
        System.out.println("Ich fahre Lambo");
    }

    public static void main(String[] args) {
        Abteilungsleiter a = new Abteilungsleiter();
        a.faehrtLambo();
        a.faehrtBus();
        Mitarbeiter m = new Abteilungsleiter();
        m.faehrtBus();
    }
}



package _20250205Vererbung.runtimePolymorphism;

class Mitarbeiter extends Arbeitnehmer{

    @Override
    void arbeitet(){
        System.out.println("Ich arbeite 35 Stunden die Woche");
    }

    @Override
    void pause(){
        System.out.println("Ich mache 3 Stunden Pause die Woche");
    }

    void helloTestMitarbeiter(){
        System.out.println("Hello Test - Mitarbeiter");
    }

    public static void main(String[] args) {
        Arbeitnehmer m = new Mitarbeiter();
        m.helloTest();
        m.arbeitet();
        m.pause();
        //m.helloTestMitarbeiter() ist nicht sichtbar!
        //Da zur Compilerzeit nur Referenztyp kennbar
        //Object o = new Mitarbeiter();
        //Compiler weiß nicht, ob das auch wirklich ein Mitarbeiter-Objekt ist

        Mitarbeiter m1 = (Mitarbeiter) m; //Hier ist Casting kein Problem (upcasting)
        m1.helloTestMitarbeiter(); // m ist immer vom Typ Arbeitnehmer -> der Cast wird durchgeführt,
                                    //damit die Referenz (m) zum Mitarbeiter wird
                                    //Dadurch können wir dann die Methoden in der Mitarbeiter-Klasse aufrufen
        //((Mitarbeiter)m).helloTestMitarbeiter();
        m1.helloTest(); //Mitarbeiter sieht die Methoden von Arbeitnehmer durch Vererbung


        Mitarbeiter m2 = new Mitarbeiter();
        Arbeitnehmer m3 = (Arbeitnehmer)m1;

        Arbeitnehmer a1 = new Arbeitnehmer();
        //Mitarbeiter m4 = (Mitarbeiter) a1; //Class-cast Exception -> Arbeitnehmer weiß nichts vom Mitarbeiter

        a1.arbeitet(); //Methode vom Arbeitnehmer
        m1.arbeitet(); //Methode vom Mitarbeiter
        m2.arbeitet(); //Methode vom Mitarbeiter
        m3.arbeitet(); //Methode vom Mitarbeiter



    }

}

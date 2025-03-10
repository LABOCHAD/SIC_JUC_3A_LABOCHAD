package _20250205Vererbung;

public class Quadrat extends Rechteck {

    Quadrat(double breite) {
        super(breite, breite); //macht irgendwie Sinn :D
    }

    @Override
    //gewünschter Override gemäß Aufgabenstellung
    public double berechneFlaeche() {
        return super.berechneFlaeche()*1;
    }

    //kein Override, sondern overload, weil andere Parameter. x*y schon in Rechteck
    public double berechneFlaeche(double neueSeitenlänge) {
        return neueSeitenlänge * neueSeitenlänge;
    }

    public static void main(String[] args) {
        Quadrat q = new Quadrat(5);
        System.out.println(q.berechneFlaeche());
        ; //aus superklasse, hierhin vererbt.
        System.out.println(q.berechneFlaeche(6));
        ; //overload aus dieser klasse
    }

}

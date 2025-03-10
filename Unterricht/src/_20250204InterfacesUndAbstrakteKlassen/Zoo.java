package _20250204InterfacesUndAbstrakteKlassen;

// Abstrakte Klasse abstrakteKlassen.Tier
abstract class Tier {
    protected String name;

    // Konstruktor
    public Tier(String name) {
        this.name = name;
    }

    // Abstrakte Methode: Muss von der ersten konkreten Klasse implementiert werden
    public abstract void geraeuschMachen();

    // Konkrete Methode: Gibt den Namen des Tiers aus
    public void zeigeTier() {
        System.out.println("Ich bin ein " + name + ".");
    }
}

// Interface Laufen mit einer abstrakten Methode
interface Laufen {
    void laufen();
}

// Abstrakte Klasse Säugetier erbt von abstrakteKlassen.Tier
abstract class Saeugetier extends Tier {
    public Saeugetier(String name) {
        super(name);
    }
}

// Abstrakte Klasse Vogel erbt von abstrakteKlassen.Tier
abstract class Vogel extends Tier {
    public Vogel(String name) {
        super(name);
    }
}

// Konkrete Klasse Löwe erbt von Säugetier und implementiert Laufen
class Loewe extends Saeugetier implements Laufen {
    public Loewe() {
        super("Löwe");
    }

    @Override
    public void geraeuschMachen() {
        System.out.println("Ich bin ein Löwe und brülle: Roar! 🦁");
    }

    @Override
    public void laufen() {
        System.out.println("Ich laufe mit meinen starken Beinen!");
    }
}

// Konkrete Klasse Papagei erbt von Vogel
class Papagei extends Vogel {
    public Papagei() {
        super("Papagei");
    }

    @Override
    public void geraeuschMachen() {
        System.out.println("Ich bin ein Papagei und sage: Hallo! 🦜");
    }
}

// Testklasse mit main-Methode
public class Zoo {
    public static void main(String[] args) {
        // Löwe-Objekt erstellen und Methoden aufrufen
        Loewe simba = new Loewe();
        simba.zeigeTier();
        simba.geraeuschMachen();
        simba.laufen();

        System.out.println();

        // Papagei-Objekt erstellen und Methoden aufrufen
        Papagei coco = new Papagei();
        coco.zeigeTier();
        coco.geraeuschMachen();
    }
}

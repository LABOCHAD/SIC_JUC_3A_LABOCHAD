package _20250204InterfacesUndAbstrakteKlassen.abstrakteKlassen;

abstract class Tier {
    abstract void makeSound();
    void schlafen() {
        System.out.println("Das abstrakteKlassen.Tier schläft.");
    }
}

abstract class Katze extends Tier {
    abstract void jagen();
}

class Hund extends Tier {
    void makeSound() {System.out.println("Wuff! Wuff!");}
}

class Hauskatze extends Katze {
    void makeSound() {
        System.out.println("Miau! Miau!");
    }

    void jagen() {
        System.out.println("Die abstrakteKlassen.Hauskatze jagt Mäuse");
    }
}

class Raubkatze extends Katze {
    void makeSound() {
        System.out.println("ROOARR!");
    }

    void jagen() {
        System.out.println("Die abstrakteKlassen.Raubkatze jagt Reh");
    }
}

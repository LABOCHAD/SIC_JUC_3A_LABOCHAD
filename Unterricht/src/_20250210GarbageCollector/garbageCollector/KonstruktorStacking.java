package _20250210GarbageCollector.garbageCollector;

class Tier {
    Tier() {
        System.out.println("Hallo ich bin Klasse Tier");
    }
}

class Katze extends Tier {
    Katze() {
        System.out.println("Hallo ich bin Klasse Katze");
    }
}

class Hauskatze extends Katze {
    Hauskatze() {
        System.out.println("Hallo ich bin Klasse Hauskatze"); //Ausgabe
    }
}

class StackExample {
    public static void main(String[] args) {
        Hauskatze c = new Hauskatze();
    }
}


package _20250210Aufgabe;
class Person2 {
    String name;

    public Person2(String name) {
        this.name = name;
        System.out.println(name + " created");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being garbage collected");
    }
}

public class GarbageCollectionDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Person2 p = new Person2("Person " + i);
        }

        System.gc(); // Request garbage collection
        System.out.println("Garbage collection requested!");
    }
}

/* Aufagbe 1
    Run the program multiple times and observe when objects are garbage collected.

    Aufagbe 2
    Increase the loop count and check how garbage collection behaves.

    Aufgabe 3
    Add Thread.sleep(1000); after System.gc(); to give GC time to run.
 */

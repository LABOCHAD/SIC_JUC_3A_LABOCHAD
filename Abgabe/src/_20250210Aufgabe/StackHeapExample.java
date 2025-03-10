package _20250210Aufgabe;

class Counter {
    int count;

    public Counter(int count) {
        this.count = count;
    }
}

public class StackHeapExample {
    public static void createObjects() {
        Runtime runtime = Runtime.getRuntime();

        long beforeMemory = runtime.totalMemory() - runtime.freeMemory(); // Get used memory before

        for (int i = 0; i < 10; i++) { // Create many objects to see memory usage
            Counter c = new Counter(i); // Allocated on heap
            int localValue = i; // Stored in stack (not affecting heap much)
            //System.out.println("Counter value: " + c.count + ", Local value: " + localValue); //if you want to observe that Counter objects are allocated on the heap while localValue is stored in the stack.
        }

        long afterMemory = runtime.totalMemory() - runtime.freeMemory(); // Get used memory after

        System.out.println("Memory used by objects: " + (afterMemory - beforeMemory) + " bytes");
    }

    public static void main(String[] args) {
        createObjects();
        System.gc(); // Request garbage collection
        System.out.println("End of program");
    }
}

/*
Memory Difference:

    The heap memory (afterMemory - beforeMemory) will increase significantly after creating many objects.
    The int localValue won’t contribute much because primitive types are stored in the stack and get discarded quickly.

Effect of Garbage Collection:

    If you call System.gc();, memory should be freed (though Java’s GC decides when to actually clean up).

Increase Loop Count:

    Try i < 1000000; and see a higher memory usage because the heap fills up with Counter objects.


 */
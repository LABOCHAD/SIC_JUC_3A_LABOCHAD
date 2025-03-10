package _20250228SingeltonsAndEnums;

public class Printer {
    private static Printer instance;
    private int totalNumberOfPages;

    private Printer() {
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void print(int pages) {
        System.out.println("\nPrinting in process...");

        for (int i = 0; i < pages; i++) {
            System.out.println("Printing page " + (i + 1));
        }

        System.out.println("\nFinished printing " + pages + " pages.");
        totalNumberOfPages += pages;
        System.out.println("Total number of pages printed: " + totalNumberOfPages);
    }


}

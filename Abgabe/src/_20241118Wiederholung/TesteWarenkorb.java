package _20241118Wiederholung;

/*
Erstelle ein Objekt des Warenkorbs und füge ihm 3-7 Preise hinzu

Teste nun alle anderen Methoden
 */

import java.util.Scanner;

/**
 * Test class for the shopping card.
 * Asks user how many prices he wants to enter.
 * Collects all entered prices and overloads them to the Arraylist.
 * Uses a scanner for user input, that's closed finally.
 * Numeric inputs to scanner must be followed by a nextLine()
 * in order to get red of needless break line,
 * those are unfortunately created by them.
 * Outputs count of prices to test the method.
 * Lets user decide which price he wants to compare for exceedances.
 * Outputs count of them and finally total of all prices is shown.
 */

public class TesteWarenkorb {
    static Scanner scanner = new Scanner(System.in);
    static ShoppingCart shoppingCart = new ShoppingCart();
    static int prodCountUser;


    public static void main(String[] args) {


        System.out.println();
        System.out.println("Test program for ShoppingCart");
        System.out.println("_____________________________");
        menu();

        scanner.close();
    }

    static void menu() {
        System.out.printf("%nWhat would you like to do?" +
                "%n(1) Add products to the cart by price" +
                "%n(2) Count products in the shopping cart" +
                "%n(3) Search through prices for exceedance of a certain price" +
                "%n(4) Sum up all prices to total" +
                "%n(5) exit" +
                "%n%nChoice: ");

        switch (scanner.next()) {
            case "1": {
                addPrices();
                break;
            }

            case "2": {
                System.out.printf("%nCount of products: %d", shoppingCart.countProducts());
                break;
            }

            case "3": {
                searchExceedances();
                break;
            }

            case "4": {
                System.out.printf("Total of all products: %.2f", shoppingCart.calculateTotal());
                break;
            }

            case "5": {
                return;
            }

            default: {
                System.out.printf("%nOoops. Are your sure? Try again!%n");
                menu();
            }
        }
        System.out.printf("%n__________________________________");
        menu();
    }

    /**
     * Asks user how many prices he wants to add.
     * Collects prices and adds them up in ArrayList.
     */
    static void addPrices() {
        System.out.printf("%nHow many prices would you like to add?: ");
        prodCountUser = scanner.nextInt();
        scanner.nextLine(); //get rid of unwanted line break from nextInt

        for (int i = 1; i <= prodCountUser; i++) {
            System.out.printf("%nEnter your price for product Number %d: ", i);
            shoppingCart.addProduct(scanner.nextDouble());
            scanner.nextLine();
        }
    }

    /**
     * Asks user which price he wants to look for exceedances with.
     */
    static void searchExceedances(){
        int exceedancesCount;
        System.out.printf("%nEnter a price to look how many products exceed it: ");
        exceedancesCount = shoppingCart.countWhenPriceIsOver(scanner.nextDouble());
        scanner.nextLine();
        System.out.printf("%nExceedance by %d products%n", exceedancesCount);
    }
}

package _20241209WdhKonzepte.StaticFinalSolution;

public class Calculator {
    public static void main(String[] args) {
        // Example radius for the circle
        double radius = 4.0;

        // Calculate and print the area of the circle
        double circleArea = Calculation.calculateCircleArea(radius);
        System.out.println("The area of the circle with radius " + radius + " is: " + circleArea);

        // Calculate and print the area of the rectangle
        double rectangleArea = Calculation.calculateRectangleArea();
        System.out.println("The area of the rectangle is: " + rectangleArea);
    }
}

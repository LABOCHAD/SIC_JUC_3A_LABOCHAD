package _20241209WdhKonzepte.StaticFinalSolution;

public class Calculation {
    // Method to calculate the area of a circle using PI
    public static double calculateCircleArea(double radius) {
        return Constants.PI * radius * radius;  // Area of a circle: PI * r^2
    }

    // Method to calculate the area of a rectangle using LENGTH and WIDTH
    public static double calculateRectangleArea() {
        return Constants.LENGTH * Constants.WIDTH;  // Area of a rectangle: Length * Width
    }
}

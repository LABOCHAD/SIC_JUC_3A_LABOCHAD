package _20250214Pflichtaufgabe.aufgabe1;
/*
Anmerkung: In Zukunft bitte die Formeln mitgeben.
Ich möchte mich auf die Implementierung konzentrieren
und keinen Flashback ins Abitur und den Physikunterricht.
Im Job muss man später ggf. auch Formeln pulen, sicher,
aber da bleibt man dran sitzen, bis es läuft, nicht nur 3,5h.
Das Heraussuchen hat mich sehr aufgehalten und abgelenkt.
*/
public class Aufgabe1Test {
    public static void main(String[] args) {
        mitKlassen();
        mitLambdas();
    }

    static void mitKlassen(){
        int cI = 10;
        int fI = 20;
        int kI = 30;

        CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheit();
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        CelsiusToKelvin celsiusToKelvin = new CelsiusToKelvin();
        KelvinToCelsius kelvinToCelsius = new KelvinToCelsius();

        System.out.println("\nVariante mit einzelnen Klassen");
        System.out.println("\nCelsiusToFahrenheit");
        double fd = celsiusToFahrenheit.convert(cI);
        System.out.printf("%d Grad Celsius in Fahrenheit: %.2f%n", cI, fd);

        System.out.println("\nFahrenheitToCelsius");
        double cd = fahrenheitToCelsius.convert(fI);
        System.out.printf("%d Grad Celsius in Fahrenheit: %.2f%n", fI, cd);

        System.out.println("\nCelsiusToKelvin");
        double kd = kelvinToCelsius.convert(cI);
        System.out.printf("%d Grad Celsius in Kelvin: %.2f%n", cI, kd);

        System.out.println("\nKelvinToCelsius");
        cd = celsiusToKelvin.convert(kI);
        System.out.printf("%d Kelvin in Grad Celsius: %.2f%n", kI, cd);
    }

    static void mitLambdas(){
        //Kelvin in Fahrenheit: K = F × 1,8 + 32 + 273,15

        System.out.println("\nVariante mit Lambdas");

        TemperatureConverter converter = f -> (f * 1.8 + 32 + 273.15); //Hier der Knackpunkt des Ganzen.
        double kelvin = 300;
        double fahrenheit = converter.convert(kelvin); //300K = 80,33F

        System.out.printf("%.2f Kelvin entsprechen %.2f Grad Fahrenheit.", kelvin, fahrenheit);
    }
}

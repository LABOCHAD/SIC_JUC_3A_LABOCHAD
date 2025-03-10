package _20250214Pflichtaufgabe.aufgabe1;

public class CelsiusToKelvin implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        //k = c -273.15
        return (temperature -273.15);
    }
}

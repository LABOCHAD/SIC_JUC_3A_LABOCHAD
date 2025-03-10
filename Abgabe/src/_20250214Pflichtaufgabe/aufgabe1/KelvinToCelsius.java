package _20250214Pflichtaufgabe.aufgabe1;

public class KelvinToCelsius implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        //c = k +273.15
        return (temperature +273.15);
    }
}

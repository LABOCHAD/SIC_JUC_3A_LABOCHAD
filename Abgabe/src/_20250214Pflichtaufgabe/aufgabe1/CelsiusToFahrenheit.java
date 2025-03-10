package _20250214Pflichtaufgabe.aufgabe1;

public class CelsiusToFahrenheit implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        //(°C * 1.8) + 32 = °F / °F = (9/5 × °C) + 32
        //f = (c * 1.8) +32
        return (temperature * 1.8) + 32;
    }
}

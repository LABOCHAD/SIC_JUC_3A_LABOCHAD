package _20250214Pflichtaufgabe.aufgabe1;

public class FahrenheitToCelsius implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        //(°F - 32) / 1.8 = °C // 9/5 = 1,8
        //c = (f - 32) / 1.8
        return (temperature - 32) * 1.8;
    }
}

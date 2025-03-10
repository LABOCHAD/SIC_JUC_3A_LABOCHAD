package _20241205AufgabeExceptions;

public class UngueltigeTemperaturException extends Exception {
    public UngueltigeTemperaturException(String message) {
        super(message);
    }

    public UngueltigeTemperaturException() {
        super("Temperatur unter absolutem Nullpunkt von -273,15°C!");
    }
}

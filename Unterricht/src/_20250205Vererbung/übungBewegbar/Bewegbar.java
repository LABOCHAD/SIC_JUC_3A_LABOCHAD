package _20250205Vererbung.übungBewegbar;

public interface Bewegbar {
    void bewege();
    default void beispiel(){
        System.out.println("Ich bin eine konkrete Methode des Interfaces Bewegbar.");
    }
}

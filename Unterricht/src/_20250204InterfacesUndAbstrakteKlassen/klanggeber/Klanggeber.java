package _20250204InterfacesUndAbstrakteKlassen.klanggeber;

public interface Klanggeber {

    //ist konkret und gehört den Objekten der implementierenden Klasse (darf nicht auch static sein)
    default void spieleTon(){
        System.out.println("Standardklang wird abgespielt...");
    }

    // gehört dem Interface und kann über Klanggeber.info() aufgerufen werden. (darf nicht auch default sein)
    static void info(){
        System.out.println("Alle Klanggeber erzeugen Töne.");
    }

    //automatisch public abstract, muss nicht geschrieben werden (ist automatisch abstrakt)
    void erzeugeKlang();

}

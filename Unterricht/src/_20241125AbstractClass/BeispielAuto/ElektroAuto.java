package _20241125AbstractClass.BeispielAuto;

public class ElektroAuto extends Auto {

    private int stromverbrauch;

    public ElektroAuto (int alter, String marke, int stromverbrauch){
        super(alter, marke);
        this.stromverbrauch = stromverbrauch;
    }

    @Override
    public void fahren(){
        System.out.println("Das Elektroauto hat einen Stromverbrauch von " + stromverbrauch);
    }
}

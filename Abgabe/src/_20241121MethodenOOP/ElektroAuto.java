package _20241121MethodenOOP;

public class ElektroAuto extends Auto{

    int stromverbrauch;

    public ElektroAuto (int alter, String marke, int stromverbrauch){
        super(alter, marke);
        this.stromverbrauch = stromverbrauch;
    }

    @Override
    public void fahren(){
        System.out.println("Das Auto fährt und verbraucht dabei: " + stromverbrauch + " kWh/100 km an Strom");
    }

    public int getStromverbrauch() {
        return stromverbrauch;
    }

}

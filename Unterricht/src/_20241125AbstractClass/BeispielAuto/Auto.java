package _20241125AbstractClass.BeispielAuto;
//TODO Baue das Vererbungskonzept so um, dass du min. eine abstrakte Klasse verwendest
public abstract class Auto {
    private int alter;
    private String marke;

    public Auto(int alter, String marke){
        this.alter = alter;
        this.marke = marke;
    }

    public abstract void fahren();

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }
}

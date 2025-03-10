package _20241125AbstractClass.BeispielAuto;

public class BenzinOderDieselAuto extends Auto {

    private String kraftstoff;

    public BenzinOderDieselAuto (int alter, String marke, String kraftstoff){
        super(alter, marke);
        this.kraftstoff = kraftstoff;
    }

    @Override
    public void fahren(){
        System.out.println("Das Auto fährt mit " + kraftstoff);
    }

    public void tanken() {
        //System.out.println("Das Benzinauto der Marke " + super.marke + " wird mit " + kraftstoff + " betankt.");
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }
}

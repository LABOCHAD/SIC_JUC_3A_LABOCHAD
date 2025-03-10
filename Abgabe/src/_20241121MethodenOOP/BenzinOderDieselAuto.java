package _20241121MethodenOOP;


public class BenzinOderDieselAuto extends Auto {
    private final String kraftstoff;

    public BenzinOderDieselAuto(int alter, String marke, String kraftstoff) {
        super(alter, marke);
        this.kraftstoff = kraftstoff;

    }

    @Override
    public void fahren() {
        System.out.println("Das Auto fährt und verbraucht dabei: " + kraftstoff);
    }

    public void tanken() { //warum hier super.marke, es wurde doch marke vererbt?
        System.out.println("Das Benzinauto der Marke " + super.marke + " wird mit " + kraftstoff + " betankt.");
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

}

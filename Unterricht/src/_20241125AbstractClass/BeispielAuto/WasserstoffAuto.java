package _20241125AbstractClass.BeispielAuto;

public class WasserstoffAuto extends Auto{

    WasserstoffAuto(int alter, String marke) {
        super(alter, marke);
    }

    @Override
    public void fahren() {
        System.out.println("Das Auto fährt mit Wasserstoff\n");
    }
}

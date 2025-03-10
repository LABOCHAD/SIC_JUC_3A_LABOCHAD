package _20250205ZooAufgabe;

// Spezialisierung Schlange
class Schlange extends Reptil{
    public Schlange(String name, int alter, boolean giftig) {
        super(name, alter, giftig);
    }

    @Override
    public void füttern(String futter) {
        if (futter.equalsIgnoreCase("kleine Tiere"))
            super.füttern(futter);
        else
            System.out.println(this.name + " scheint sein Futter nicht zu mögen und lässt es liegen.");
    }
}
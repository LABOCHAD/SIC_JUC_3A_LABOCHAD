package _20241121MethodenOOP;

/**
 * Superclass for cars.
 * Contains basics like age and brand.
 * Has only method for drive for now.
 */
public class Auto {
    private int alter;
    protected String marke;

    /**
     * Constructs a car.
     * @param alter age of car.
     * @param marke brand of car.
     */
    public Auto(int alter, String marke){
        this.alter = alter;
        this.marke = marke;
    }

    /**
     * Only a demonstrative method to
     * make the car drive virtually.
     */
    public void fahren(){
        System.out.println("Das Auto fährt.");
    }

    public String getMarke() {
        return marke;
    }

    public int getAlter() {
        return alter;
    }

}

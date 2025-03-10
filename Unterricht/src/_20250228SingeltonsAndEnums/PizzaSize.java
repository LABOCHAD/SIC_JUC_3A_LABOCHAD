package _20250228SingeltonsAndEnums;

enum PizzaSize {
    KLEIN("Klein", 26, 8.0),
    MITTEL("Mittel", 30, 10.0),
    GROSS("Groß", 32, 12.0),
    FAMILIE("Familie", 40, 20.0),
    PARTY("Party", 60, 40.0);

    private int durchmesser;
    private String name;
    private double grundpreis;

    PizzaSize(String name, int durchmesser, double grundpreis) {
        this.name = name;
        this.durchmesser = durchmesser;
        this.grundpreis = grundpreis;
    }

    public String toString() {
        return name + " \u2300" + durchmesser + "cm: " + grundpreis + "€";
    }

    public static void main(String[] args) {
        /*System.out.println(PizzaSize.FAMILIE.toString());

        System.out.println(Arrays.toString(PizzaSize.values()));

        for(PizzaSize s: PizzaSize.values()){
            System.out.println(s);
        }
        */
        System.out.println(PizzaSize.valueOf("FAMILIE"));
        System.out.println(Enum.valueOf(PizzaSize.class, "FAMILIE"));
    }
}

class Test{
    public double getPrice(PizzaSize p){
        switch (p){
            case KLEIN:
                return 8.00;
            case MITTEL:
                return 9.00;
            case GROSS:
                return 10.00;
            case PARTY:
                return 12.00;
            default:
                return 0;
        }
    }
}



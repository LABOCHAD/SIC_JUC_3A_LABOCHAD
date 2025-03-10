package _20241121MethodenOOP;

public class Main {
    public static void main(String[] args){
        Auto auto = new Auto(10, "BMW");
        BenzinOderDieselAuto benzinOderDieselAuto = new BenzinOderDieselAuto(25, "Opel", "Benzin");
        ElektroAuto elektroAuto = new ElektroAuto(5, "Tesla", 14);

        auto.fahren();
        benzinOderDieselAuto.fahren();
        elektroAuto.fahren();
    }
}

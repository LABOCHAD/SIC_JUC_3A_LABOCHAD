package _20241125AbstractClass.BeispielAuto;

public class Main {
    public static void main(String[] args){

        //Erstelle eine Objekt Auto - geht nicht mehr, da Auto jetzt eine abstrakte Klasse
        //Auto bwm = new Auto(20, "bwm");
        //bwm.fahren();

        //Erstelle ein Benzin-Auto
        Auto benzinOderDieslAuto = new BenzinOderDieselAuto(3, "BMW", "Diesel");
        benzinOderDieslAuto.fahren();

        //Erstelle ein ElektroAuto
        Auto tesla = new ElektroAuto(2, "Tesla", 100);
        tesla.fahren();

        BenzinOderDieselAuto auto = new BenzinOderDieselAuto(3, "BMW", "Diesel");
        auto.fahren();
    }
}

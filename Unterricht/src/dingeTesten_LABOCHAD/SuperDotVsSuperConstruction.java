package dingeTesten_LABOCHAD;

public class SuperDotVsSuperConstruction {

    class CD{
        String name;
        CD(String name){
            this.name = name;
        }
        CD(){}
    }

    class DVD extends CD{
        String name;
        DVD(String name){
            super(name); //einzige Möglichkeit bei obigem Konstruktor
            super.name = name; //geht nur mit Parameterlosem Konstruktor in CD
            this.name = name;
        }

        DVD(){
            this("irgendwas)");
        }
    }

}

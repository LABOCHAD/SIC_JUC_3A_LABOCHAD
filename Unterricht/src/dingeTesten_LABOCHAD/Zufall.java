package dingeTesten_LABOCHAD;

import java.util.Random;

public class Zufall {
    //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
    public static void main(String[] args) {
        Random rand = new Random(); //initiiere Zufallsgenerator
        int randomNumber = rand.nextInt(50); //Zahl  0 - 49

        while (randomNumber != 0) {
            System.out.println(randomNumber);
            randomNumber = rand.nextInt(50)+1; //Zufallsgenerator 1-50
        }


    }


}

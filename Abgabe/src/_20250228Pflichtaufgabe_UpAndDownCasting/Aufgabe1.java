package _20250228Pflichtaufgabe_UpAndDownCasting;

import DungeonCrawl.Project.Figures.Enemies.Enemy;
import DungeonCrawl.Project.Figures.Enemies.ShadowGolem;

//Aufgabe 1
//Explain Upcasting and Downcasting and write a Code Example
//
//Explain it with Objects and Primitive Datatypes
public class Aufgabe1 {
    public static void main(String[] args) {
        //Upcasting primitive
        double d = 100f;
        //Upcasting Object
        Exception e = new RuntimeException(); //ClassCastException
        Enemy enemy = new ShadowGolem(); //implicit upcast
        Object o = new String("Hi");
        //Integer i = (Integer) Short.valueOf((short)1); //Error

        //Downcasting primitive
        byte b = (byte) 100L; //blank input of 1 is promoted as an int,
        // that's why f and L suffix is needed as well, same with short
        //Downcasting Object
        ShadowGolem golem = (ShadowGolem) enemy;
        String s0 = (String) o; //bare casting, risky!
        String s1 = (o instanceof String) ? (String) o : null; //explicit upcast after testing
        String s2 = (o instanceof String string) ? string : null; //with pattern variable
        //RuntimeException re = (RuntimeException) new Exception(); //ClassCastException
        //Short s = (Short) Integer.valueOf(100); //Error
    }
}

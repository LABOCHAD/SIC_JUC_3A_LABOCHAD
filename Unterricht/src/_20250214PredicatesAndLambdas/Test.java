package _20250214PredicatesAndLambdas;

import java.util.ArrayList;

class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String up = "Alice";
        String down = "alice";
        System.out.println(down.compareTo(up)); //wie weit ist up, von down entfernt -> 32 vorwärts (Von Klammer aus)
        //Stell dir vor, du schwingst den Aufruf am Punkt, wie eine Kugel an einer Schnur
        //Es wird der Abstand des in der Klammer Stehenden zum Objekt auf dem aufgerufen wird zurückgegeben

        //in der ASCII-Tabelle kommen erst die Groß- und dann die Kleinbuchstaben.
        //https://www.torsten-horn.de/techdocs/ascii.htm
    }
}

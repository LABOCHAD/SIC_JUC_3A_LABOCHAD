package _20250212StringsundStringBuilder;

public class AufgabeStringBuilder {
    public static void main(String[] args) {
        String input = "ssapsthcamdnullotttsinereimmargorp"; //da war ein t zu viel
        StringBuilder sb = new StringBuilder(input);
        System.out.println("Input: " + sb.toString()); //Vorher Vergleich: toString nicht nötig

        //drehe String um
        sb.reverse();

        //entferne unnötiges t zwischen ist und toll
        sb.deleteCharAt(17);
        //oder der Ansatz von Thorsten
        //        index = builder.indexOf("toll");builder.insert(index, " ");//[...]

        //Füge fehlende Leerzeichen ein, nicht elegant aber funktioniert. Woher soll der sb wissen, wo ein wort beginnt?
        sb.insert(13, " "); //+1
        sb.insert(17, " "); //+2
        sb.insert(22, " "); //+3
        sb.insert(26, " "); //+4
        sb.insert(32, " "); //+5

        //Schreibe erstes P groß
        sb.replace(0, 1, "P");

        //Schreibe s von Spaß groß
        sb.setCharAt(sb.indexOf("spass"), 'S');

        //Ersetze ss am Ende durch ß!
        sb.delete(sb.indexOf("Spass"), sb.length());
        sb.append("Spaß!");

        //Nachher Vergleich
        System.out.println("Output: " + sb.toString());

    }
}

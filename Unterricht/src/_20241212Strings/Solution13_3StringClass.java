package _20241212Strings;

public class Solution13_3StringClass {

    //1. Erstellung verschiedener Strings und Ausgabe deren Länge
    static String string1 = "Hallo";
    static String string2 = "Welt!";
    static String string3 = "@Java macht Spaß";

    //3. Strings mit und ohne x
    static String stringWithX = "Das x ist ein x Test für Aufgabe x 3";
    static String getStringWithoutX = "Das ist ein Test für Aufgabe 3";

    //5. Strings longer than 4 and shorter
    static String stringLongerThanFour = "234567890";
    static String stringShorterThanFour = "123";

    //6. Different String arrays
    static String[] array1 = {"Hello", " ", "World", "!"};
    static String[] array2 = {"Java", null, "Programming"};
    static String[] array3 = null;
    static String[] array4 = {null, null, null};

    public static void main(String [] args) {
        stringLength();
        findIndexOfSpecialCharacter();
        determineToStringAndSubstring();

        //3. Testing with x and without x
        System.out.println("Counter spaces up to x: (with x) " + countSpacesUntilX(stringWithX));
        System.out.println("Counter spaces up to x: (without x) " + countSpacesUntilX(getStringWithoutX));

        //5. Testing with two different String length
        System.out.println("Before: " + stringLongerThanFour);
        System.out.println("After: " + maskStringWithX(stringLongerThanFour));
        System.out.println("Before: " + stringShorterThanFour);
        System.out.println("After: " + maskStringWithX(stringShorterThanFour));

        //6. Testing with different arrays
        System.out.println(concatenateStrings(array1));
        System.out.println(concatenateStrings(array2));
        System.out.println(concatenateStrings(array3));
        System.out.println(concatenateStrings(array4));

        //7. Bitte erst auskommentieren, und selbst lösen
        blackBox();

        createHTMLTable();
    }

    //1. Methode zur Ausgabe der Länge der verschiedenen Strings
    private static void stringLength() {
        System.out.println(string1.length());
        System.out.println(string2.length());
        System.out.println(string3.length());
    }

    //2. Methode, die indexOf verwendet, um die Position auszugeben, an der die zuvor erstellten Strings
    private static void findIndexOfSpecialCharacter(){
        //Define special characters. For example:
        char[] specialChars = {'#', '!', '@'};
        for(char special: specialChars) {
            System.out.println("Special character "+ special + ": " + string1.indexOf(special));
            System.out.println("Special character "+ special + ": " + string2.indexOf(special));
            System.out.println("Special character "+ special + ": " + string3.indexOf(special));
        }
    }

    //3. Die Methode soll einen String als Input akzeptieren und die Anzahl an Leerzeichen finden, bis sie ein x findet
    public static int countSpacesUntilX(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'x') {
                break;
            } else if (c == ' ') {
                count++;
            }
        }
        return count;
    }

    //4. Schreiben einer Methode, um festzustellen, ob die toString()- und substring()-Methoden der
    // String-Klasse eine internierte Zeichenkette zurückgeben oder nicht
    private static void determineToStringAndSubstring() {
        String original = "HelloWorld";
        String toStringResult = original.toString();
        System.out.println("toString() returns interned string: " + (original == toStringResult));
        String substringResult = original.substring(0, 5);
        String internedSubstringResult = substringResult.intern();
        System.out.println("substring() returns interned string: " + (substringResult == internedSubstringResult));
    }

    //5. Die Methode soll einen gegebenen String so umwandeln,
    // dass bis auf die letzten vier Zeichen, alle anderen ein 'X' erhalten.
    private static String maskStringWithX(String str) {
        if (str.length() <= 4) {
            return str;
        }
        StringBuilder masked = new StringBuilder();
        int length = str.length();
        masked.append("x".repeat(length - 4));
        masked.append(str.substring(length - 4));
        return masked.toString();
    }

    //6. Die Methode soll aus einem String-Array einen String machen.
    // Beachtet werden sollen auch die Fälle, in denen Teile des Arrays null sind.
    private static String concatenateStrings(String[] array) {
        if (array == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String str : array) {
            if (str != null) {
                result.append(str);
            }
        }
        return result.toString();
    }

    //7. Was gibt der vorgegebene Code aus?
    private static void blackBox() {
        String string = "a";
        String[] stringarray = { "a", string, string.substring(0, 1), new String("test"), ""+'a'};
        for (int i = 0; i<stringarray.length; i++) {
            System.out.println(i);
            System.out.println(string == stringarray[i]);
            System.out.println(string.equals(stringarray[i]));
        }
    }

    //8. Optional: Er stelle zwei Arrays: Einer mit Strings und einer mit int gefüllt.
    // Erstelle dann eine HTML-Tabelle, in der du mit Hilfe von printf und format jedem String einen int zuweist.
    private static void createHTMLTable() {
        String[] names = {"A", "B", "C"};
        int[] values = {1, 2, 3};
        System.out.printf("<table border=\"1\">\n");
        System.out.printf(" <tr><th>Name</th><th>Value</th></tr>\n");
        StringBuilder htmlTable = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            htmlTable.append(String.format(" <tr><td>%s</td><td>%d</td></tr>\n", names[i], values[i]));
        }
        System.out.printf("</table>\n");
        htmlTable.append("</table>\n");
        System.out.println(htmlTable);
    }
}

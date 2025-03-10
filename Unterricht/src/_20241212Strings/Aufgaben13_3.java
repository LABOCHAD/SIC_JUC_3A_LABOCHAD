package _20241212Strings;

public class Aufgaben13_3 {
    public static void main(String[] args) {

        System.out.println("\nAufgabe 1");
        String s1 = "Hello\nWorld"; //sollte 11 statt 12 sein
        String s2 = "Hi\tthere"; //sollte 8 statt 9 sein
        char t = '\t', n = '\n'; //cool, das geht ja wirklich
        System.out.format("s1 (%s), length = %d%n", s1, s1.length());
        System.out.format("s2 (%s), length = %d%n", s2, s2.length());

        System.out.println("\nAufgabe 2");
        System.out.format("s1 (%s), index of \\n = %d%n", s1, s1.indexOf(n));
        System.out.format("s2 (%s), index of \\t = %d%n", s2, s2.indexOf(t));

        System.out.println("\nAufgabe 3");
        countSpacesTillX("I have 3 spaces");
        countSpacesTillX("0 1 x 3 4");

        System.out.println("\nAufgabe 4");
        aufgabe4();

        System.out.println("\nAufgabe 5");
        String s5 = "0123456789";
        System.out.printf("%s has been taken by method and we got %s from it.%n", s5, aufgabe5(s5));
        //It hasn't been changed, 'cause strings are immutable.
        String s52 = "0123";
        System.out.printf("%s has been taken by method and we got %s from it.%n", s52, aufgabe5(s52));


        System.out.println("\nAufgabe 6");
        aufgabe6();

    }

    //zu Aufgabe 3 (return wurde nicht gefordert)
    public static void countSpacesTillX(String s) {
        int spaces = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                spaces++;
            if (c == 'x')
                break;
        }
        System.out.format("Numbers of spaces found in \"%s\": %d%n", s, spaces);
    }

    public static void aufgabe4() {
        //check if toString() and substring return interned strings (stored in heap, string pool)
        String h = "hello";
        String h2 = "hello";

        String hw = "hello world"; //if substring returns interned String, h == hw.substring(0,5) should be true

        int n = 10; //if toString returns interned String, should be same reference as "10" -> s == Integer.toString(n)
        String s = "10";

        //Gegenprobe
        System.out.println("Strings with equal (native) literals refer to the same heap address: " + (h == h2));

        //I deep dived into the string class and came to the cloning method in Arrays (chars),
        //a clone is never same referred ( x.clone() != x)
        System.out.printf("The substring() method returns an interned string: %s%n", h == hw.substring(0, 5)); //5 is exclusive
        System.out.printf("The toString() method returns an interned string: %s%n", h == Integer.toString(n)); //both are false
    }

    public static String aufgabe5(String s) {
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length() - 4; i++) {
            sArr[i] = 'X';
        }
        StringBuilder stringBuilder = new StringBuilder(); //suggestion by IDE
        for (char c : sArr) {
            stringBuilder.append(c); //my solution was just concatenating within the loop (s += c)
        }
        return stringBuilder.toString(); //for matching return type again
    }

    public static void aufgabe6(){
        String[] test1 = {"1", "2", "3"};
        String[] test2 = {"1", null, "2"};
        String[] test3 = {null, null, null};
        String[] test4 = {" ", "\n ", "\t "};
        System.out.println("Test1: " + concatenateStringArray(test1));
        System.out.println("Test2: " + concatenateStringArray(test2));

        try {
            System.out.println("Test3: " + concatenateStringArray(test3));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Test4: " + concatenateStringArray(test4));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    //zu Aufgabe 6
    public static String concatenateStringArray(String[] strArr) {
        StringBuilder retStr = new StringBuilder(); //again suggested by IDE
        for (String s : strArr) {
            if (s == null || s.isBlank()) //.isBlank checks if only whitespaces are contained
                s = ""; //so string won't be appended with "null"

            retStr.append(s);
        }
        if (retStr.toString().isEmpty())
            throw new RuntimeException("No processable String has been passed in the array!");
        return retStr.toString();
    }
}

package _20250212Aufgabe;

public class Aufgaben6Bis10 {
    public static void main(String[] args) {
        System.out.println("\nAufgabe 6");
        System.out.println(getEndergebnisAppend("Hallo", "Welt"));

        System.out.println("\nAufgabe 7");
        String[] arr = {"Hallo", " ", "Welt", "!", " Wie", " geht's?"};
        appendMehrereStrings(arr);

        System.out.println("\nAufgabe 8");
        getEndergebnisReverse("Hello ", "World");

        System.out.println("\nAufgabe 9");
        System.out.println(getEndergebnisInsert("Hello", "World"));

        System.out.println("\nAufgabe 10");
        reverseEveryWord("Hallo Welt, ich bin Dominik.");
        reverseEveryWord("Am Zehnten Zehnten um Zehn Uhr zehn zogen zehn zahme Ziegen zehn Zentner Zucker zum Züricher Zoo.");
        reverseEveryWord("Meinst du, dass sie die Gedanken genommen haben, " +
                         "die wir gedacht haben, und wollen, dass wir denken, dass unsere Gedanken, die wir gedacht haben, " +
                         "die Gedanken sind, die wir jetzt denken? Denkst du das?");

    }

    static String getEndergebnisAppend(String s, String s1) {
        return new StringBuffer(s).append(s1).toString();
    }

    static void appendMehrereStrings(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }

    static void getEndergebnisReverse(String s, String s2) {
        StringBuilder builder = new StringBuilder(s);
        builder.append(s2);
        builder.reverse();
        System.out.println(builder.toString());
    }

    static String getEndergebnisInsert(String s, String s2) {
        StringBuilder builder = new StringBuilder(s);
        builder.append(s2); //HelloWorld
        builder.insert(builder.indexOf(s2), " ");
        return builder.toString();
    }

    static void reverseEveryWord(String sentence) {
        if (!sentence.contains(" ")) {
            System.err.println("Input seems not to be a sentence. Please retry.");
            return;
        }

        String[] words = sentence.split(" "); //it is astonishing how good ultimate's suggestion can become
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            word = new StringBuilder(word).reverse().append(" ").toString();
            words[i] = word;
        }
        for (String word : words) {
            System.out.print(word);
        }
        System.out.println();
    }
}

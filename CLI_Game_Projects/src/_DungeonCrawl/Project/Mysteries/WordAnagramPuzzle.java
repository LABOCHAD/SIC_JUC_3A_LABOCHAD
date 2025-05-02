package _DungeonCrawl.Project.Mysteries;

public class WordAnagramPuzzle extends Mystery{

    public WordAnagramPuzzle(String question, String rightAnswer){
        super(question, rightAnswer);
    }

    /**
     * Predefined puzzle, in case no other is passed.
     */
    public WordAnagramPuzzle(){
        super("There's nothing to LISTEN to, when it is: ???", "silent");
    }

    @Override
    public void outputQuestion() {
        System.out.printf("Find the anagram to the word written in capitals: %n%s%n", question);
    }

}
//https://sites.ualberta.ca/~jcc/Funny/anagrams.html
//https://www.thewordfinder.com/funny-anagrams.php
//consider fetching some of them later from a list randomly
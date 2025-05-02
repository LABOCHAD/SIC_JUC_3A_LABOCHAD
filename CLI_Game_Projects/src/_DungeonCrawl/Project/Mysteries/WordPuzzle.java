package _DungeonCrawl.Project.Mysteries;

public class WordPuzzle extends Mystery{

    public WordPuzzle(String question, String rightAnswer){
        super(question, rightAnswer);
    }

    /**
     * Predefined puzzle, in case no other is passed.
     */
    public WordPuzzle(){
        super("""           
                                d  p  d  j  t  r  z
                                f  u  h  f  r  d  l
                                c  v  n  p  r  h  g
                                w  t  n  g  w  s  f
                                h  w  f  g  e  v  h
                                w  s  r  w  f  o  f
                                s  x  g  x  w  f  n
                                """, "dungeon");
    }

    @Override
    public void outputQuestion() {
        System.out.printf("Find the word in the grid below: %n%s%n", question);
    }

}
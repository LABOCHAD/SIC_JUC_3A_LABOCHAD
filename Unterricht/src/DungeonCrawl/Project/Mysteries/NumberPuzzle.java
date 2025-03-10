package DungeonCrawl.Project.Mysteries;

public class NumberPuzzle extends Mystery{

    public NumberPuzzle(String question, String rightAnswer){
        super(question, rightAnswer);
    }

    /**
     * Predefined puzzle, in case no other is passed.
     */
    public NumberPuzzle(){
        super("5, 1, 3, 4, 2","1, 2, 3, 4, 5");
    }

    @Override
    public void outputQuestion() {
        System.out.printf("Bring the following numbers in the right order: %n%s%n", question);
    }

}
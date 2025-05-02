package _DungeonCrawl.Project.Mysteries;

import static _DungeonCrawl.Project.GamePlay.random;

public class MathPuzzle extends Mystery{
    protected static int x = random.nextInt(50);
    protected static int y = random.nextInt(50);

    public MathPuzzle(String question, String rightAnswer){
        super(question, rightAnswer);
    }

    /**
     * Provides randomized math problem
     * when no specific details are passed.
     */
    public MathPuzzle(){
        super((x + " + " + y), Integer.toString(x + y));
    }

    @Override
    public void outputQuestion() {
        System.out.printf("Solve following math task: %s = ", question);
    }

}

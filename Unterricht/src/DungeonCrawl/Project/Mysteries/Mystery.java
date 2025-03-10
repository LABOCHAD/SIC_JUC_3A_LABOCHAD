package DungeonCrawl.Project.Mysteries;

import java.util.Scanner;

public abstract class Mystery {
    protected String question;
    protected String rightAnswer;

    /**
     * Predefined puzzle, in case no other is passed.
     */
    public Mystery(String question, String rightAnswer) {
        this.rightAnswer = rightAnswer;
        this.question = question;
    }

    /**
     * Verifies if puzzle has been solved correctly
     * by comparing given answer with intended one.
     * @param answer entered try to solve the mystery.
     * @return if the answer was correct or not.
     */
    public boolean isSolved(String answer) {
        return (answer.equalsIgnoreCase(rightAnswer));
    }

    /**
     * Asking the puzzle's question by specific output.
     */
    public abstract void outputQuestion();

    /**
     * Makes the user try to solve, till
     * the answer is correct. According to
     * decision tree given to the task.
     * @param scanner passed by gameplay
     */
    public void solve(Scanner scanner) {
        boolean solved;
        do {
            outputQuestion();
            solved = isSolved(scanner.nextLine());
            System.out.println((solved) ? "Your answer was correct." : "Your answer was wrong, try again.");
        } while (!solved);
    }

}

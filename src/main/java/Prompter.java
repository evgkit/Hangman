import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public void play() {
        while (game.getRemainingTries() > 0 && !game.isSolved()) {
            displayProgress();
            promptForGuess();
        }

        if (game.isSolved()) {
            System.out.printf("Congratulations! You won with %d tries remaining", game.getRemainingTries());
        } else {
            System.out.printf("Boomer the word was %s.   :(\n", game.getAnswer());
        }
    }

    private boolean promptForGuess() {
        boolean isHit = false;
        boolean isValidGuess = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidGuess) {
            try {
                System.out.print("Enter a letter:  ");
                String guessInput = scanner.nextLine();
                isHit = game.applyGuess(guessInput);
                isValidGuess = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s.  Please try again.\n", iae.getMessage());
            }
        }

        return isHit;
    }

    private void displayProgress() {
        System.out.printf(
            "You have %d tries left to solve:  %s\n",
            game.getRemainingTries(),
            game.getCurrentProgress()
        );
    }

    // TODO: As a prompter, I should know the name of the guesser so that things can appear more friendly.
    // TODO: As a prompter, I should know the highest score, so that it can be used to encourage competition
}
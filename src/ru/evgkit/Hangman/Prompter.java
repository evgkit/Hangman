package ru.evgkit.Hangman;

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

    public boolean promptForGuess() {
        boolean isHit = false;
        boolean isValidGuess = false;

        Scanner scanner = new Scanner(System.in);

        while (!isValidGuess) {
            try {
                System.out.print("Enter a letter:  ");
                String guessAsString = scanner.nextLine();
                char guess = guessAsString.charAt(0);

                isHit = game.applyGuess(guess);
                isValidGuess = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s.  Please try again.\n", iae.getMessage());
            }
        }
        return isHit;
    }

    public void displayProgress() {
        System.out.printf(
            "You have %d tries left to solve:  %s\n",
            game.getRemainingTries(),
            game.getCurrentProgress()
        );
    }

}
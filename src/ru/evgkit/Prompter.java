package ru.evgkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
  private Game mGame;
  
  public Prompter(Game game) {
    mGame = game;
  }
  
  public void play() {
    while (mGame.getRemainingTries() > 0) {
      displayProgress();
      promptForGuess();
    }
  }
  
  public boolean promptForGuess() {
    boolean isHit = false;
    boolean isValidGuess = false;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (!isValidGuess) {

      try {
        System.out.print("Enter a letter:  ");
        String guessAsString = br.readLine();
        char guess = guessAsString.charAt(0);

        isHit = mGame.applyGuess(guess);
        isValidGuess = true;
      } catch (IllegalArgumentException | IOException iae) {
        System.out.printf("%s.  Please try again.\n", iae.getMessage());
      }
    }
    return isHit;
  }
  
  public void displayProgress() {
    System.out.printf("You have %d tries left to solve:  %s\n",
                      mGame.getRemainingTries(),
                      mGame.getCurrentProgress());
  }
  
}
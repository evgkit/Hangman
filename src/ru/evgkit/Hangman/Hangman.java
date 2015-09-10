package ru.evgkit.Hangman;

public class Hangman {

    public static void main(String[] args) {
        if (0 == args.length) {
            System.out.println("Please enter the word.");
            System.exit(0);
        }

        Game game = new Game(args[0]);

        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
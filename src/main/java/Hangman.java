public class Hangman {

    public static void main(String[] args) {
        if (0 == args.length) {
            System.out.println("Usage:  java Hangman <answer>");
            System.err.println("answer is required");
            System.exit(1);
        }

        Game game = new Game(args[0]);

        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
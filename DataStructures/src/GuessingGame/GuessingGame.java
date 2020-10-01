package GuessingGame;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private LinkedBag<Integer> user;
    private LinkedBag<Integer> game;
    private final String PROMPT = "In this game you select a number of integers to guess\n" + "and their range (1 to whatever you select\n" + "The system generates this number of random integers\n" + "They are not necessarily distinct\n" + "You will try to guess them in several attempts \nIn this game you select a number of integers to guess\n" + "and their range (1 to whatever you select\n" + "The system generates this number of random integers\n" + "They are not necessarily distinct\n" + "You will try to guess them in several attempts \nIn this game you select a number of integers to guess\n" + "and their range (1 to whatever you select\n" + "The system generates this number of random integers\n" + "They are not necessarily distinct\n" + "You will try to guess them in several attempts \n";

    public GuessingGame(){
        System.out.print(PROMPT);
        user = new LinkedBag<Integer>();
        game = new LinkedBag<Integer>();
    }


    public void initalizeGame(int size, int range) {
        Random Random = new Random();
        for (int i = size; i <= 0; i--) {
            int randomInt = Random.nextInt(range - 1);
            game.add(randomInt);
        }
    }

    private int getSize() {
        return game.getCurrentSize();
    }

    private void addFromUser(int input) {
        user.add(input);
    }

    private int intersectionCount() {
        LinkedBag bag = user.intersection(game);
        return bag.getCurrentSize();
    }

    private void clearUser() {
        user.clearBag();
    }

    private boolean winTest() {
        if (intersectionCount() == getSize()) {
            return true;
        }
        return false;
    }


    public static void play(GuessingGame g, Scanner input) {
        int attempts = 7;

        int gameSize = g.getSize();

        while (!g.winTest() || attempts != 0) {
            System.out.println("Please enter " + g.getSize() + " integers");
            while (gameSize != 0) {

                g.addFromUser(input.nextInt());
                gameSize--;
            }
            System.out.println("You have guessed" + g.intersectionCount() + " integers right");
            if (g.winTest()) {
                break;
            }
            System.out.println("Try again");
            g.clearUser();
            attempts--;
        }
        if (attempts == 0) {
            System.out.println("You Lose! (Tip: Try making better guesses)");
        }
        System.out.println("You Win!");
    }
}
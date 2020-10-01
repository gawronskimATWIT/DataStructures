package GuessingGame;
import java.util.Scanner;
public class GameTest {

    public static void main(String[] args){
        boolean playAgain = false;
        GuessingGame game = new GuessingGame();
    Scanner input = new Scanner(System.in);
do {
    System.out.println("How many numbers do you want to guess? ");
    int size = input.nextInt();
    System.out.println("Specify the range : 0 to (your choice) ");
    int range = input.nextInt();
 game.initalizeGame(size,range);
 game.play(game,input);
System.out.println("Do you want to play again? (Y/N)");
String userChar = input.nextLine();
if(userChar.equals("Y")){
    playAgain = true;
}
}while(playAgain);


    }}

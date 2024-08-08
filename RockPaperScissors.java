import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
  public static void main(String[] args) {
     String[] rps = {"r", "p", "s"};
      Scanner scanner = new Scanner(System.in);

      while (true) {
        String ComputerTurn = rps[new Random().nextInt(rps.length)];
        String PlayerMove;

        while (true) {
          System.out.println("Enter your move (r, p or s): ");
          PlayerMove = scanner.nextLine();
          if (PlayerMove.equals("r") || PlayerMove.equals("p") || PlayerMove.equals("s")) {
            break;
          }
          System.out.println(PlayerMove + " is not a valid move.");
        }
        System.out.println("Computer played: " + ComputerTurn);

        if (PlayerMove.equals(ComputerTurn)) {
          System.out.println("You tied! Try again.");
        }
        else if (PlayerMove.equals("r") && ComputerTurn.equals("s") || 
                 PlayerMove.equals("p") && ComputerTurn.equals("r")) {
          System.out.println(PlayerMove + " beats " + ComputerTurn + ". \nYou win!");
        }
        else {
          System.out.println(ComputerTurn + " beats " + PlayerMove + ". \nYou lose!");
        }

        System.out.println("Play again? (y/n)");
        String playAgain = scanner.nextLine();

        if (playAgain.equals("n")) {
          break;
        }

      }

      scanner.close();
    
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        // get words
        Scanner scanner = new Scanner(new File("words_alpha.txt"));
        Scanner keyBoard = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while(scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        // hangman word
        String word = words.get(rand.nextInt(words.size()));

        List<Character> guessedLetters = new ArrayList<>();

        
        int wrongGuesses = 0;
        while (true) {
      
            // print hangman
            printHangman(wrongGuesses);

            if (wrongGuesses >= 6) {
                System.out.println("You lost.");
                System.out.println("The word was: " + word);
                break;
            }

            // print the current state
            printGameState(word, guessedLetters);
            // get player to guess
            if (!getPlayerToGuess(keyBoard, word, guessedLetters)) {
                wrongGuesses++;
            }

            // the letters are all guessed
            if (printGameState(word, guessedLetters)) {
                System.out.println("You win!");
                break;
            }
            // give a chance to guess word
            System.out.println("Can you guess the word?: ");
            if (keyBoard.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            }
            // they got the word wrong
            else {
                System.out.println("Nope! try again. \n");
            }
            
        }
        scanner.close();
        keyBoard.close();
    }

    public static boolean printGameState(String word, List<Character> guessedLetters) {
        int correctLetters = 0;

        System.out.println("");

        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctLetters++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println("");

        return (word.length() == correctLetters);
    }
    

    public static boolean getPlayerToGuess(Scanner keyBoard, String word, List<Character> guessedLetters ) {
        System.out.println("\nPlease guess a letter: ");
        String letterGuessed = keyBoard.nextLine();
        guessedLetters.add(letterGuessed.charAt(0));

        return word.contains(letterGuessed);

    }

    public static void printHangman(Integer wrongGuesses) {
        // scaffold
        System.out.println(" -------");
        System.out.println(" |     |");

        // head
        if (wrongGuesses >= 1) {
            System.out.println(" O");
        }

        // arms
        if (wrongGuesses >= 2) {
            System.out.print("\\ ");
            if (wrongGuesses >= 3) {
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }

        // body
        if (wrongGuesses >= 4) {
            System.out.println(" |");
        }

        // legs
        if (wrongGuesses >= 5) {
            System.out.print("/ ");
            if (wrongGuesses >= 6) {
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
    }
}

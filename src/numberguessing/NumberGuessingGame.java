//Console game where the user guesses a random number between 1 and 100

package numberguessing;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "y";
        System.out.println("------NUMBER GUESSING GAME------");

        do {
            System.out.println("\nSelect difficulty:");
            System.out.println("1. Easy (10 attempts)");
            System.out.println("2. Hard (5 attempts)");
            System.out.println("3. Unlimited (guess until you get it)");
            System.out.print("Enter your choice: ");
            int level = scanner.nextInt();
            int maxAttempts;
            if (level == 1) {
                maxAttempts = 10;
            } else if (level == 2) {
                maxAttempts = 5;
            } else if (level == 3) {
                maxAttempts = Integer.MAX_VALUE;
            } else {
                System.out.println("Invalid choice. Please select 1-3.");
                continue;
            }
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nI am thinking of a number between 1 and 100.");
            if (level == 3) {
                System.out.println("You have unlimited attempts.");
            } else {
                System.out.println("You have " + maxAttempts + " attempts.");
            }
            while (attempts < maxAttempts) {
                System.out.print("\nAttempt " + (attempts + 1) + " - Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please guess between 1 and 100.");
                    continue;
                }
                attempts++;
                if (guess == secretNumber) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    hasWon = true;
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }
            if (!hasWon) {
                System.out.println("\nGame over! The number was " + secretNumber + ".");
            }

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
//Console game where the player competes against the computer and the score is tracked.

package rockpaperscissors;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        int playerScore = 0;
        int computerScore = 0;
        int draws = 0;
        int choice;

        System.out.println("------ROCK PAPER SCISSORS------");

        do {
            System.out.println("\n1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 3) {
                String playerChoice = choices[choice - 1];
                String computerChoice = choices[random.nextInt(3)];

                System.out.println("You chose: " + playerChoice);
                System.out.println("Computer chose: " + computerChoice);

                if (playerChoice.equals(computerChoice)) {
                    System.out.println("It's a draw!");
                    draws++;
                } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors"))
                        || (playerChoice.equals("Paper") && computerChoice.equals("Rock"))
                        || (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
                    System.out.println("You win this round!");
                    playerScore++;
                } else {
                    System.out.println("Computer wins this round!");
                    computerScore++;
                }

                System.out.println("Score -> You: " + playerScore + " | Computer: " + computerScore + " | Draws: " + draws);
            } else if (choice != 4) {
                System.out.println("Invalid choice. Please select 1-4.");
            }
        } while (choice != 4);

        System.out.println("\nFinal Score -> You: " + playerScore + " | Computer: " + computerScore + " | Draws: " + draws);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
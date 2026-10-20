//Menu-driven calculator that performs basic arithmetic operations.

package calculator;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n------CALCULATOR------");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double firstNumber = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double secondNumber = scanner.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result: " + (firstNumber + secondNumber));
                        break;
                    case 2:
                        System.out.println("Result: " + (firstNumber - secondNumber));
                        break;
                    case 3:
                        System.out.println("Result: " + (firstNumber * secondNumber));
                        break;
                    case 4:
                        if (secondNumber == 0) {
                            System.out.println("Error: Cannot divide by zero.");
                        } else {
                            System.out.printf("Result: %.2f%n", firstNumber / secondNumber);
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please select 1-5.");
            }
        } while (choice != 5);

        System.out.println("Thanks for calculating.");
        scanner.close();
    }
}

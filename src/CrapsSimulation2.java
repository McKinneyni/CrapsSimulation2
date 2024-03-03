import java.util.Random;
import java.util.Scanner;

public class CrapsSimulation2 {
    public static void main(String[] args) {
        // Create a Random  generating random numbers
        Random rnd = new Random();
        // Create a Scanner object  reading user input
        Scanner scanner = new Scanner(System.in);
        // Variable to control  play-again loop
        boolean playAgain = true;

        // Main game loop
        while (playAgain) {
            // Generate random numbers for dice rolls
            int die1 = rnd.nextInt(6) + 1; // Roll for die1, range 1-6
            int die2 = rnd.nextInt(6) + 1; // Roll for die2, range 1-6
            int sum = die1 + die2; // Calculate the sum of both dice
            // Print out the dice roll results
            System.out.printf("You rolled %d + %d = %d%n", die1, die2, sum);

            // Check the initial roll outcomes
            if (sum == 2 || sum == 3 || sum == 12) {
                // If the sum is 2, 3, or 12: Craps, player loses
                System.out.println("Craps! You lost.");
            } else if (sum == 7 || sum == 11) {
                // If the sum is 7 or 11: Natural, player wins
                System.out.println("Natural! You won.");
            } else {
                // For any other sum, the game goes into point mode
                int point = sum; // The sum now becomes the point
                System.out.printf("Point is set to %d. Rolling for point...%n", point);

                // Loop to roll for the point
                boolean rollingForPoint = true;
                while (rollingForPoint) {
                    die1 = rnd.nextInt(6) + 1; // Re-roll die1
                    die2 = rnd.nextInt(6) + 1; // Re-roll die2
                    sum = die1 + die2; // Calculate new sum
                    // Print the result of each roll while trying for the point
                    System.out.printf("You rolled %d + %d = %d%n", die1, die2, sum);

                    if (sum == point) {
                        // If the player rolls the point, they win
                        System.out.println("Made point! You won.");
                        rollingForPoint = false; // Exit the rolling for point loop
                    } else if (sum == 7) {
                        // If the player rolls a 7, they lose
                        System.out.println("Got a seven! You lost.");
                        rollingForPoint = false; // Exit the rolling for point loop
                    } else {
                        // If neither condition is met, keep rolling for the point
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask the player if they want to play again
            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes"); // Read and evaluate response
        }

        // Close the Scanner object to prevent resource leak
        scanner.close();
        // Game over message
        System.out.println("Game Over. Thank you for playing!");
    }
}

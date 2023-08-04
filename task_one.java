import java.util.Random;
import java.util.Scanner;

public class task_one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a random number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts in each round.");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempt(s).");
                    score++;
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("y");
        }

        System.out.println("Your final score: " + score);
        System.out.println("Thanks for playing! Goodbye!");
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerAChoice = getValidChoice(scanner, "Player A: Enter R, P, or S: ");
            String playerBChoice = getValidChoice(scanner, "Player B: Enter R, P, or S: ");

            displayResults(playerAChoice, playerBChoice);

            System.out.print("Play again? (Y/N): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("Y"));

        scanner.close();
    }

    private static String getValidChoice(Scanner scanner, String prompt) {
        String choice;
        while (true) {
            System.out.print(prompt);
            choice = scanner.next();
            if (choice.equalsIgnoreCase("R") || choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return choice;
    }

    private static void displayResults(String playerAChoice, String playerBChoice) {
        System.out.println("Player A chose: " + playerAChoice);
        System.out.println("Player B chose: " + playerBChoice);

        if (playerAChoice.equals(playerBChoice)) {
            System.out.println("It's a Tie!");
        } else if ((playerAChoice.equals("R") && playerBChoice.equals("S")) ||
                (playerAChoice.equals("P") && playerBChoice.equals("R")) ||
                (playerAChoice.equals("S") && playerBChoice.equals("P"))) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}

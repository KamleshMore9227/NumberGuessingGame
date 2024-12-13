import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameByKamlesh {
    public static void main(String[] args) {

        while (true) {
            System.out.println();
            System.out.println("## Press 1 to play the game");
            System.out.println("## Press 2 to display the rules");
            System.out.println("## Press anything else to exit");
            System.out.println();

            Scanner in = new Scanner(System.in);

            int menuChoice = in.nextInt();
            if (menuChoice == 1) {
                beginGame();
            } else if (menuChoice == 2) {
                printRules();
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("Thank you for playing the number guessing game.");

    }

    public static void beginGame() {
        int chances = 0;
        boolean won = false;

        System.out.println("*************************************");
        System.out.println("Welcome to the number guessing game.");
        System.out.println();
        System.out.println("Select a difficulty:");
        System.out.println();
        System.out.println("1) Easy - 10 chances");
        System.out.println("2) Medium - 5 chances");
        System.out.println("3) Hard - 3 chances");
        System.out.println("*************************************");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            chances = 10;
        } else if (choice == 2) {
            chances = 5;
        } else if (choice == 3) {
            chances = 3;
        } else {
            System.out.println("Please enter a valid choice");
            return;
        }

        Random rand = new Random();
        final int numberToGuess = rand.nextInt(101);

        while (chances > -1) {
            System.out.println();
            System.out.println("Enter your guess:");

            int guess = sc.nextInt();
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed it!");
                won = true;
                break;
            } else {
                chances--;
                if (chances == 0) {
                    break;
                }

//                System.out.println("Wrong! Try again. Number of remaining chances: " + chances);
                if (guess > numberToGuess) {
                    System.out.println();
                    System.out.println("Wrong! Try again. The number is lesser than your guess. ");
                    System.out.println("Number of remaining chances: " + chances);
                } else {
                    System.out.println();
                    System.out.println("Wrong! Try again. The number is greater than your guess. ");
                    System.out.println("Number of remaining chances: " + chances);
                }
            }
        }

        if (!won) {
            System.out.println();
            System.out.println("You lost! The number was " + numberToGuess + "!");
        }
    }

    public static void printRules() {
        System.out.println();
        System.out.println("                RULES");
        System.out.println();
        System.out.println("The computer will choose a random number from ");
        System.out.println("0 to 100. You will be given a number of chances ");
        System.out.println("to guess the number according to the difficulty ");
        System.out.println("you choose. Have fun!");
        System.out.println();
    }
}
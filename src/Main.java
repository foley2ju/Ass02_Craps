import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int die1 = 0;
        int die2 = 0;
        String playAgain = "";
        boolean done = false;

        do {
            // FIRST ROLL
            die1 = rnd.nextInt(1, 7);
            die2 = rnd.nextInt(1, 7);
            final int firstSum = die1 + die2;
            System.out.println("The first die rolls " + die1 + ".");
            System.out.println("The second die rolls " + die2 + ".");
            System.out.printf("%d + %d = %d %n", die1, die2, firstSum);

            // CHECKS IF WIN OR LOSE
            if (firstSum == 7 || firstSum == 11) {
                System.out.println("You win!");
                return;
            }
            if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
                System.out.println("You crapped out. You lose...");
                return;
            }

            // NEITHER WIN OR LOSE, KEEP ROLLING
            // Rolling until the new sum matches the first one or is equal to 7.
            int newSum = 0;
            while (newSum != firstSum && newSum != 7) {
                die1 = rnd.nextInt(1, 7);
                die2 = rnd.nextInt(1, 7);
                newSum = die1 + die2;
                System.out.println("The first die rolls " + die1 + ".");
                System.out.println("The second die rolls " + die2 + ".");
                System.out.printf("%d + %d = %d %n", die1, die2, newSum);
            }

            if (newSum == firstSum) {
                System.out.println("You win!");
            } else {
                System.out.println("You crapped out. You lose...");
            }

            System.out.println("Play again? Y/N");
            playAgain = in.nextLine();
            if (playAgain.equalsIgnoreCase("Y")) {
                System.out.println("Playing again:");
            } else if (playAgain.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("Enter a valid input.");
            }

        } while (!done);
    }
}
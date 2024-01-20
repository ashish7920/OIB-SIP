import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
         
        System.out.println("\nEnter the number of rounds you want to play");
        int rnds=sc.nextInt(); 
        int maxAtt = 5;
        int totScore = 0;

       
        System.out.println("\nYou have " + rnds + " rounds and " + maxAtt + " attempts per round.");

        for (int i = 1; i <= rnds; i++) {
            int randomNumber = (int) (Math.random() * 100) + 1; 
            int guessCount = 0;

            System.out.println("\nRound " + i + ": Guess a number between 1 and 100:");

            while (guessCount < maxAtt) {
                guessCount++;
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    int points = 10 - guessCount;
                    totScore += points;
                    System.out.println("Congratulations! You guessed the number in " + guessCount + " attempts. You earned " + points + " points!");
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("The number is greater than "+guess+"! Try again. Attempts remaining: " + (maxAtt - guessCount));
                } else {
                    System.out.println("The number is lesser than "+guess+"! Try again. Attempts remaining: " + (maxAtt - guessCount));
                }
            }

            if (guessCount == maxAtt) {
                System.out.println("You ran out of attempts. The number was " + randomNumber + ".");
            }
        }

        System.out.println("\nGame over! Your total score is " + totScore + ".");

        sc.close();
    }
}

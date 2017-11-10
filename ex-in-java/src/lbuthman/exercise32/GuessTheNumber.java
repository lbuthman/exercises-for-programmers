package lbuthman.exercise32;

import java.util.Scanner;

import static tools.Tools.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        int BEGINNER_LEVEL = 10;
        int INTERMEDIATE_LEVEL = 100;
        int ADVANCED_LEVEL = 1000;

        Scanner input = getScanner();

        println("Let's play Guess The Number!");

        print("Pick a difficulty level (1, 2, 3): ");
        int level = input.nextInt();
        int range = 0;

        if (level == 1) { range = BEGINNER_LEVEL; }
        else if (level == 2) {range = INTERMEDIATE_LEVEL; }
        else if (level == 3 ) {range = ADVANCED_LEVEL; }

        int answer = getRandomNumber(range);
        print("I have my number. What is your guess? ");

        int i = 1;
        int guess = input.nextInt();
        while (true) {

            if (guess == answer) {
                print("You got it in " + i + " guesses!");
                break;
            }

            print(checkGuess(answer, guess));
            guess = input.nextInt();
            i++;
        }

    }

    private static int getRandomNumber(int range) {
        return (int) (Math.random() * range) + 1;
    }

    private static String checkGuess(int answer, int guess) {
        if (answer > guess) {
            return "Too low. Guess again: ";
        } else {
            return "Too high. Guess again: ";
        }
    }
}

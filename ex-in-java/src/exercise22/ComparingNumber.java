package exercise22;

import java.util.Scanner;

import static tools.Tools.*;

public class ComparingNumber {
    public static void main(String[] args){
        Scanner input = getScanner();

        print("Enter the first integer: ");
        int firstNumber = input.nextInt();

        print("Enter the second integer: ");
        int secondNumber = input.nextInt();

        print("Enter the third integer: ");
        int thirdNumber = input.nextInt();

        if (firstNumber == secondNumber && secondNumber == thirdNumber) {
            println("Hmmm, all these numbers are the same. Why do you insist on wasting my time?");
            return;
        }

        int largestNumber = firstNumber > secondNumber ? firstNumber : secondNumber;

        if (largestNumber < thirdNumber) { largestNumber = thirdNumber; }

        println("The largest number of the three is " + largestNumber);

    }
}

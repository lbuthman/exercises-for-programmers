package lbuthman.exercise26;

import java.util.Scanner;

import static tools.Tools.*;

public class CreditCardPayoffCalculator {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("What is your current balance? ");
        double balance = input.nextDouble();

        print("What is the APR on the card? ");
        double apr = input.nextDouble() / 100.0;

        print("What is your current monthly payment? ");
        double payment = input.nextDouble();

        double months = calculateMonthsUntilPaidOff(balance, apr, payment);

        println("It will take " + ((int) Math.ceil(months)) + " months to pay off this card.");

    }

    private static double calculateMonthsUntilPaidOff(double b, double apr, double p) {

        double i = apr / 365.0; //daily rate

        double numerator = Math.log(1 + b/p * (1 - Math.pow((1 + i), 30)));

        double denominator = Math.log(1 + i);

        return (-1 / 30.0) * (numerator / denominator);
    }
}

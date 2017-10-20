package lbuthman.exercise12;

import java.text.DecimalFormat;
import java.util.Scanner;

import static tools.Tools.*;

public class SimpleInterest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        Scanner input = getScanner();

        print("Enter the principal amount: ");
        double principal = input.nextDouble();

        print("Enter the interest rate: ");
        double interestRate = input.nextDouble();
        double ratePercent = interestRate / 100;

        print("Enter the number of years: ");
        double years = input.nextDouble();

        double amount = calculateSimpleInterest(principal, ratePercent, years);

        print("After " + years + " years at " + interestRate + "%, " +
                "the investment will be worth $" + df.format(amount));
    }

    private static double calculateSimpleInterest(double principle, double ratePercent, double years) {

        return principle * (1 + (ratePercent * years));
    }
}

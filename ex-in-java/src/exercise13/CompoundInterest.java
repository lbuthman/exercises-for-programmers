package exercise13;

import java.text.DecimalFormat;
import java.util.Scanner;

import static tools.Tools.*;

public class CompoundInterest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        Scanner input = getScanner();

        print("What is the principal amount? ");
        double principal = input.nextDouble();

        print("What is the rate? ");
        double rate = input.nextDouble();
        double ratePercentage = rate / 100;

        print("What is the number of years? ");
        double years = input.nextDouble();

        print("How many times is the interest compounded each year? ");
        double timesCompoundedPerYear = input.nextDouble();

        double innerEvaluation = (1 + (ratePercentage / timesCompoundedPerYear));
        double exponentialEvaluation = Math.pow(innerEvaluation, (timesCompoundedPerYear * years));

        double amount = principal * exponentialEvaluation;

        print("A $" + df.format(principal) + " investment at " + rate + "% for " + years + " years " +
                "compounded " + timesCompoundedPerYear + " times per year is $" + df.format(amount));

    }
}

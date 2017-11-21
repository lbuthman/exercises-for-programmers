package exercise14;

import static tools.Tools.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner input = getScanner();

        print("What is the order amount? ");
        double amount = input.nextDouble();

        print("What is the state? ");
        String state = input.next();

        double subtotal = amount;
        double tax = 0;
        if (state.contains("WI")) {
            tax = 5.5 / 100;
            tax *= subtotal;
            println("The tax is $" + df.format(tax));
        }

        println("The total is $" + df.format(subtotal + tax));
    }
}

package lbuthman.exercise11;

import static tools.Tools.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {

        double EXCHANGE_RATE = 1.18;

        Scanner input = getScanner();

        print("How many euros are you exchanging? ");
        double euros = input.nextDouble();

        DecimalFormat df = new DecimalFormat("0.00");
        double usd = euros * EXCHANGE_RATE;

        print(euros + " euros at an exchange rate of " + EXCHANGE_RATE + " is " + "$" + df.format(usd));
    }
}

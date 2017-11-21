package exercise10;

import java.util.Scanner;

import static tools.Tools.*;

public class SelfCheckout {
    public static void main(String[] args) {
        Double TAX_RATE = 0.055;

        Scanner input = getScanner();

        int i = 1;
        double subtotal = 0;
        while (true) {
            double item = 0;
            int quantity = 0;

            print("Enter the price of item " + i + " or 'q' to quit: ");
            try {
                item = input.nextDouble();
            } catch (Exception e) {
                break;
            }

            print("Enter the quantity of item " + i + ": ");
            quantity = input.nextInt();

            subtotal += item * quantity;
            i++;
        }

        println("Subtotal:\t$" + subtotal);

        double tax = subtotal * TAX_RATE;
        println("Tax:\t\t$" + tax);
        println("Total:\t\t$" + (subtotal + tax));
    }
}

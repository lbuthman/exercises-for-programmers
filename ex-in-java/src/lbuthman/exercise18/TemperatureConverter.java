package lbuthman.exercise18;

import java.text.DecimalFormat;
import java.util.Scanner;

import static tools.Tools.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner input = getScanner();

        println("Press 'C' to convert Fahrenheit to Celsius");
        println("Press 'F' to convert Celsius to Fahrenheit");
        print("Your choice: ");
        String cOrF = input.next();

        if (cOrF.equals("C")) {
            print("Please enter the temperature in Fahrenheit: ");
            double fahrenheit = input.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            println("The temperature in Celsius is " + df.format(celsius));
        } else {
            print("Please enter the temperature in Celsius: ");
            double celsius = input.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            println("The temperature in Fahrenheit is " + df.format(fahrenheit));
        }
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit - 32) * (5 / 9.0));
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * (9.0 / 5)) + 32;
    }
}

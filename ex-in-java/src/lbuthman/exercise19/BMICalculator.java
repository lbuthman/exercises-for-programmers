package lbuthman.exercise19;

import java.text.DecimalFormat;
import java.util.Scanner;

import static tools.Tools.*;

public class BMICalculator {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner input = getScanner();

        println("Let's get your height in feet and inches.");
        print("First, enter feet: ");
        double feet = input.nextDouble();

        print("Next, enter inches: ");
        double inches = input.nextDouble();

        double heightInInches = feet * 12 + inches;

        print("Finally, how much do you weight? ");
        double weight = input.nextDouble();

        double bmi = (weight / ( Math.pow(heightInInches, 2)) * 703);

        println("Your BMI is " + df.format(bmi));
        if (bmi < 18.5) {
            println("You are underweight.");
        }
        else if (bmi > 25) {
            println("You are overweight.");
        }
        else {
            println("You are within the ideal weight range.");
        }
    }
}

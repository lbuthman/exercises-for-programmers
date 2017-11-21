package exercise17;

import static tools.Tools.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BloodAlcoholCalculator {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        double WATER_IN_BLOOD = 0.806;
        double GRAMS_TO_SWEDISH_STANDARDS = 1.2;
        double BODY_WATER_MALE = 0.58;
        double BODY_WATER_FEMALE = 0.49;
        double KILOGRAMS_TO_POUNDS = 0.453592;
        double METABOLISM = 0.017;
        double CONVERT_TO_PERMILLAGE = 10;

        Scanner input = getScanner();

        print("How many drinks have you had? ");
        double drinks = input.nextDouble();

        print("What is your weight in pounds? ");
        double weight = input.nextDouble() * KILOGRAMS_TO_POUNDS;

        print("Enter 'm' for male or 'f' for female: ");
        double bloodWater = input.next().contains("m") ? BODY_WATER_MALE : BODY_WATER_FEMALE;

        print("How many hours has it been since your last drink? ");
        int hours = input.nextInt();

        double bac = ((WATER_IN_BLOOD * drinks * GRAMS_TO_SWEDISH_STANDARDS)
                / (weight * bloodWater) - METABOLISM * hours) * CONVERT_TO_PERMILLAGE;
        println("Your blood alcohol content is " + df.format(bac) + "%");

        if (bac >= 0.08) {
            print("It is not legal for you to drive.");
        } else {
            print("It is legal for you to drive. Be careful :)");
        }
    }
}

package lbuthman.exercise7;

import java.util.Scanner;

import static tools.Tools.*;

public class FeetToMeterCalculator {
    public static void main(String[] args) {

        Scanner input = getScanner();

        print("What is the length of the room in feet? ");
        double length = input.nextDouble();

        print("What is the width of the room in feet? ");
        double height = input.nextDouble();

        println("You entered dimensions of " + length + " feet by " + height + " feet.");

        Square square = new Square(length, height);

        double areaInFeet = square.calculateAreaInFeet(square);
        double areaInMeters = square.calculateAreaInMeters(square);

        println("The area is: ");
        println(areaInFeet + " square feet.");
        println(areaInMeters + " square meters.");

    }
}

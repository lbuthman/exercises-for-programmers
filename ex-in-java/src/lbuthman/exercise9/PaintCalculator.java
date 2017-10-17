package lbuthman.exercise9;

import java.util.Scanner;

import static tools.Tools.*;

public class PaintCalculator {
     private static int GALLONS_IN_FEET = 350;

    public static void main(String[] args) {
        Scanner input = getScanner();

        print("Enter the length of your room: ");
        int length = input.nextInt();

        print("Enter the width of your room: ");
        int width = input.nextInt();

        int gallons = 0;
        int area = length * width;
        int a = area;

        while (a > 0) {
            gallons++;
            a -= GALLONS_IN_FEET;
        }

        print("To paint a " + area + " foot room, you will need " + gallons + " gallons of paint.");

    }
}

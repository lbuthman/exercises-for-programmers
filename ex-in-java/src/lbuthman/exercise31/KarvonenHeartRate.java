package lbuthman.exercise31;

import java.util.Scanner;

import static tools.Tools.*;

public class KarvonenHeartRate {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("What is your age? ");
        int age = input.nextInt();

        print("What is your resting heart rate? ");
        int restingHR = input.nextInt();

        println("Intensity\t|  Rate");
        println("---------\t|--------");

        for (int i=55; i<=95; i+=5) {
            println("\t" + i + "%\t\t|  " + calculateTargetHR(age, restingHR, (i / 100.0)) + " bpm");
        }
    }

    private static int calculateTargetHR(int age, int restingHR, double intensity) {
        return (int) Math.round((((220 - age) - restingHR) * intensity) + restingHR);
    }
}

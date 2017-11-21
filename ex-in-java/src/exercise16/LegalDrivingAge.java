package exercise16;

import static tools.Tools.*;

import java.util.Scanner;

public class LegalDrivingAge {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("What is your age? ");
        int age = input.nextInt();

        print(checkAge(age));
    }

    private static String checkAge(int age) {
        return age >= 16 ? "You are old enough to legally drive." : "You are not old enough to legally drive.";
    }
}

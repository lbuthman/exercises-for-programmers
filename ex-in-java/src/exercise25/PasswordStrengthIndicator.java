package exercise25;

import java.util.Scanner;

import static tools.Tools.*;

public class PasswordStrengthIndicator {

    private final static int VERY_WEAK = 1;
    private final static int WEAK = 2;
    private final static int STRONG = 4;
    private final static int VERY_STRONG = 5;

    public static void main(String[] args) {
        Scanner input = getScanner();

        print("Enter the password you with to test: ");
        String password = input.next();

        int strengthValue = passwordValidator(password);

        String strength;
        if (strengthValue >= VERY_STRONG) { strength = "very strong"; }
        else if (strengthValue >= STRONG) { strength = "strong"; }
        else if (strengthValue >= WEAK) { strength = "weak"; }
        else if (strengthValue >= VERY_WEAK) { strength = "very weak"; }
        else { strength = "error"; }

        if (strength.equals("error")) {
            println("Your password could not be checked at this time.");
            return;
        }

        println("Value: " + strengthValue);
        println("The password \"" + password + "\" a " + strength + " password.");
    }

    private static int passwordValidator(String password) {

        int v = 0;
        v += hasDigits(password) ? 1 : 0;
        v += hasLetters(password) ? 2 : 0;
        v += hasEightCharacters(password) ? 1 : 0;
        v += hasSpecialCharacter(password) ? 1 : 0;

        return v;
    }

    private static boolean hasDigits(String p) {
        return p.matches(".*[\\d]+.*");
    }

    private static boolean hasLetters(String p) {
        return p.matches(".*[a-zA-Z]+.*");
    }

    private static boolean hasEightCharacters(String p) {
        return p.length() >= 8;
    }

    private static boolean hasSpecialCharacter(String p) {
        return p.matches(".*[\\W]+.*");
    }
}

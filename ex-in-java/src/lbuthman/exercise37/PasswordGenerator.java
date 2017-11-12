package lbuthman.exercise37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner input = getScanner();

        List<String> specialCharacters = new ArrayList<>(
                Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*"));
        List<String> numbers = new ArrayList<>(
                Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));

        print("What's the minimum length? ");
        int minLength = input.nextInt();

        print("How many special characters? ");
        int specialLength = input.nextInt();

        print("How many numbers? ");
        int numLength = input.nextInt();

        List<String> passwordCharacters = new ArrayList<>();

        for (int i=0; i<specialLength; i++) {
            passwordCharacters.add(generateSpecialCharacter(specialCharacters));
        }

        for (int i=0; i<numLength; i++) {
            passwordCharacters.add(generateNumbers(numbers));
        }

        int remainingCharacters = minLength - specialLength - numLength;
        for (int i=0; i<remainingCharacters; i++) {
            if (i % 2 == 0) {
                passwordCharacters.add(generateCharacter('A'));
            }
            else {
                passwordCharacters.add(generateCharacter('a'));
            }
        }

        String password = generatePassword(passwordCharacters);
        println("Your new password is " + password);

    }

    private static String generatePassword(List<String> passwordCharacters) {

        StringBuilder password = new StringBuilder();
        int originalSize = passwordCharacters.size();
        for (int i=0; i<originalSize; i++) {
            int random = (int) (Math.random() * passwordCharacters.size());
            String s = passwordCharacters.get(random);
            password.append(s);
            passwordCharacters.remove(s);
        }

        return password.toString();
    }

    private static String generateSpecialCharacter(List<String> specialCharacters) {
        int random = (int) (Math.random() * specialCharacters.size());
        return specialCharacters.get(random);
    }

    private static String generateNumbers(List<String> numbers) {
        int random = (int) (Math.random() * numbers.size());
        return numbers.get(random);
    }

    private static String generateCharacter(char charCase) {
        int random = (int) (Math.random() * 52);
        char randomChar = (char) (charCase + random % 26);
        return String.valueOf(randomChar);
    }
}

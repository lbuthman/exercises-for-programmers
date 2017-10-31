package lbuthman.exercise24;

import java.util.Arrays;
import java.util.Scanner;

import static tools.Tools.*;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner input = getScanner();

        println("Enter two strings and I'll tell you if they are anagrams.");

        print("Enter the first string: ");
        String firstString = input.next();

        print("Enter the second string: ");
        String secondString = input.next();

        String result = isAnagram(firstString, secondString) ? " are anagrams." : " are not anagrams.";

        print("\"" + firstString + "\" and " + "\"" + secondString + "\"" + result);
    }

    private static boolean isAnagram(String s, String t) {
        char[] sChars = s.toLowerCase().replace("[\\s]", "").toCharArray();
        char[] tChars = t.toLowerCase().replace("[\\s]", "").toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}

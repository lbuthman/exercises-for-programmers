package lbuthman.exercise15;

import static tools.Tools.*;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("What is the password? ");
        String password = input.next();

        if (password.equals("floatingCastle")) {
            print("You got it!");
        } else {
            print("I don't know who you are.");
        }
    }
}

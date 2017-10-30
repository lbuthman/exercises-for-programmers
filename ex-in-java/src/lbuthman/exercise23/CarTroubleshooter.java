package lbuthman.exercise23;

import java.util.Scanner;

import static tools.Tools.*;

public class CarTroubleshooter {
    public static void main(String[] args) {
        Scanner input = getScanner();
        String decision;
        int marker;

        println("Welcome to the Auto Troubleshooter Helper! Let's get started.");

        while (true) {
            askQuestionOne();
            decision = input.next();

            if (decision.equals("Y")) {
                askQuestionTwo();
                marker = 2;
            } else {
                askQuestionThree();
                marker = 3;
            }
            decision = input.next();

            if (marker == 2) {
                if (decision.equals("Y")) {
                    println("Clean terminals and try starting again. ");
                    break;
                } else {
                    println("Replace cables and try again. ");
                    break;
                }
            } else {
                if (decision.equals("Y")) {
                    println("Replace the battery.");
                    break;
                } else {
                    askQuestionFour();
                }
            }
            decision = input.next();

            if (decision.equals("Y")) {
                println("Check spark plug connections.");
                break;
            } else {
                askQuestionFive();
            }
            decision = input.next();

            if (decision.equals("Y")) {
                println("Check to make sure the choke is opening and closing.");
                break;
            } else {
                println("Get it in for service.");
                break;
            }
        }
    }

    private static void askQuestionOne() {
        print("Is the car silent when you turn the key? ");
    }

    private static void askQuestionTwo() {
        print("Are the battery terminals corroded? ");
    }

    private static void askQuestionThree() {
        print("Does the car make a clicking noise? ");
    }

    private static void askQuestionFour() {
        print("Does the car crank but fail to startup? ");
    }

    private static void askQuestionFive() {
        print("Does your car have fuel injection? ");
    }
}

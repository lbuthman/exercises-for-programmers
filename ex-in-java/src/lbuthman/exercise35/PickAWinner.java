package lbuthman.exercise35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class PickAWinner {
    public static void main(String[] args) {
        Scanner input = getScanner();

        println("Ready to play?");
        List<String> contestants = new ArrayList<>();

        while (true) {
            print("Enter a name: ");
            String c = input.nextLine();
            if (c.equals("")) {
                break;
            } else {
                contestants.add(c);
            }
        }

        int randInt = (int) (Math.random() * contestants.size());

        println("The winner is " + contestants.get(randInt));
    }
}

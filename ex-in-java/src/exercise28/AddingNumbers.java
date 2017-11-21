package exercise28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class AddingNumbers {
    public static void main(String[] args) {
        int LOOP_ITERATIONS = 5;

        Scanner input = getScanner();

        println("Welcome! Please type in " + LOOP_ITERATIONS + " whole numbers and I'll add them for you.");

        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<LOOP_ITERATIONS; i++) {
            print((i + 1) + " Enter a whole number: ");
            numbers.add(input.nextInt());
        }

        println("The total is " + numbers.stream().mapToInt(Integer::intValue).sum() + ".");
    }
}

package lbuthman.exercise34;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class YoureFired {
    public static void main(String[] args) {
        Scanner input = getScanner();

        List<String> employees = new ArrayList<>();
        employees.add("Jackie Chan");
        employees.add("Chuck Norris");
        employees.add("Chucky Cheese");
        employees.add("Ninja Sifl");
        employees.add("Ninja Oly");

        println("There are " + employees.size() + " employees.");
        printEmployees(employees);

        print("Who are you going to fire? ");

        String firedEmployee = input.nextLine();

        employees.remove(firedEmployee);

        println("There are now " + employees.size() + " employees.");
        printEmployees(employees);

    }

    private static void printEmployees(List<String> employees) {
        for (String e: employees) {
            println(e);
        }
    }
}

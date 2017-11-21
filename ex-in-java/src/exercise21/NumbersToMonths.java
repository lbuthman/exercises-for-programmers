package exercise21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static tools.Tools.*;

public class NumbersToMonths {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("Please enter the number of the month: ");

        int monthNumber = input.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            println("Sorry, that was not a valid month ... good try.");
            return;
        }

        Map<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        println("The name of the month is " + months.get(monthNumber));
    }
}

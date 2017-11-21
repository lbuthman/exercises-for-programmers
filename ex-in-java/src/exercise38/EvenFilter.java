package exercise38;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static tools.Tools.*;

public class EvenFilter {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("Enter a list of numbers, separate by spaces: ");
        String inputNumbers = input.nextLine();

        Pattern pattern = Pattern.compile(" ");
        List<Integer> numbers = pattern.splitAsStream(inputNumbers)
                                    .map(Integer::valueOf)
                                    .collect(Collectors.toList());

        String evenNumbers = filterEvenNumbers(numbers);
        println("The even numbers are: " + evenNumbers);
    }

    private static String filterEvenNumbers(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer n: numbers) {
            if (n % 2 == 0) {
                stringBuilder.append(n);
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}

package lbuthman.exercise36;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class Statistics {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");
        Scanner input = getScanner();

        List<Double> times = new ArrayList<>();
        while (true) {
            print("Enter a number: ");
            try {
                double n = Integer.parseInt(input.nextLine());
                times.add(n);
            }
            catch (Exception e) {
                break;
            }
        }

        double minimum = calculateMinimum(times);
        double maximum = calculateMaximum(times);

        print("Numbers: " + times.get(0));

        for (int i=1; i<times.size(); i++) {
            print(", " + times.get(i));
        }

        double mean = calculateAverage(times);

        double standardDeviation = calculateStandardDeviation(times, mean);

        println("");
        println("The average is " + mean);
        println("The minimum is " + minimum);
        println("The maximum is " + maximum);
        println("The standard deviation is " + df.format(standardDeviation));
        println("Goodbye");
    }

    private static double calculateAverage(List<Double> numbers) {
        double total = 0;
        for (Double n: numbers) {
            total += n;
        }
        return total / numbers.size();
    }

    private static double calculateMinimum(List<Double> numbers) {
        double minimum = numbers.get(0);
        for (Double n : numbers) {
            minimum = minimum < n ? minimum : n;
        }
        return minimum;
    }

    private static double calculateMaximum(List<Double> numbers) {
        double maximum = numbers.get(0);
        for (Double n: numbers) {
            maximum = maximum > n ? maximum : n;
        }
        return maximum;
    }

    private static double calculateStandardDeviation(List<Double> numbers, double mean) {
        List<Double> differencesFromMean = new ArrayList<>();
        double totalOfDifferencesFromMean = 0;

        for (int i=0; i<numbers.size(); i++) {
            double difference =  numbers.get(i) - mean;
            differencesFromMean.add(Math.pow(difference, 2));
            totalOfDifferencesFromMean += differencesFromMean.get(i);
        }

        double meanOfDifferencesFromMean = totalOfDifferencesFromMean / differencesFromMean.size();
        return Math.sqrt(meanOfDifferencesFromMean);
    }
}

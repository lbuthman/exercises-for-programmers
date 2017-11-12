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

        double total = times.get(0);
        double minimum = times.get(0);
        double maximum = times.get(0);

        print("Numbers: " + times.get(0));

        for (int i=1; i<times.size(); i++) {
            print(", " + times.get(i));
            total += times.get(i);
            minimum = minimum < times.get(i) ? minimum : times.get(i);
            maximum = maximum > times.get(i) ? maximum : times.get(i);
        }

        double mean = total / times.size();

        List<Double> differencesFromMean = new ArrayList<>();
        double totalOfDifferencesFromMean = 0;
        for (int i=0; i<times.size(); i++) {
            double difference =  times.get(i) - mean;
            differencesFromMean.add(Math.pow(difference, 2));

            totalOfDifferencesFromMean += differencesFromMean.get(i);
        }

        double meanOfDifferencesFromMean = totalOfDifferencesFromMean / differencesFromMean.size();
        double standardDeviation = Math.sqrt(meanOfDifferencesFromMean);

        println("");
        println("The average is " + mean);
        println("The minimum is " + minimum);
        println("The maximum is " + maximum);
        println("The standard deviation is " + df.format(standardDeviation));
    }
}

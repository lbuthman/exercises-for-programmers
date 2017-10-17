package lbuthman.exercise8;

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import static tools.Tools.*;


public class MainV2 {
    public static void main(String[] args) {

        Scanner scanner = getScanner();

        print("How many hungry folks you got? ");
        int numOfPeople = scanner.nextInt();

        List<Integer> slicesPerPerson = new ArrayList<>();

        for (int i=0; i<numOfPeople; i++) {
            print( (i+1) + ". How many pieces? ");
            slicesPerPerson.add(scanner.nextInt());
        }

        int totalSlices = 0;
        for (Integer slices: slicesPerPerson) {
            totalSlices += slices;
        }

        Map<String,Integer> pizzasToOrder = new HashMap<>();
        pizzasToOrder.put("Small", 0);
        pizzasToOrder.put("Medium", 0);
        pizzasToOrder.put("Large", 0);

        while (totalSlices > 0) {
            if (totalSlices <= Pizza.SMALL.pieces) {
                Integer temp = pizzasToOrder.get("Small");
                temp++;
                pizzasToOrder.put("Small", temp);
                totalSlices -= Pizza.SMALL.pieces;
            } else if (totalSlices <= Pizza.MEDIUM.pieces) {
                Integer temp = pizzasToOrder.get("Medium");
                temp++;
                pizzasToOrder.put("Medium", temp);
                totalSlices -= Pizza.MEDIUM.pieces;
            } else {
                Integer temp = pizzasToOrder.get("Large");
                temp++;
                pizzasToOrder.put("Large", temp);
                totalSlices -= Pizza.LARGE.pieces;
            }
        }

        String pizzaOrder = "";

        if (pizzasToOrder.get("Small") > 0) {
            pizzaOrder += pizzasToOrder.get("Small") + " Small, ";
        }

        if (pizzasToOrder.get("Medium") > 0) {
            pizzaOrder += pizzasToOrder.get("Medium") + " Medium, ";
        }

        if (pizzasToOrder.get("Large") > 0) {
            pizzaOrder += pizzasToOrder.get("Large") + " Large";
        }

        print("You will need to buy " + pizzaOrder + ".");
    }
}

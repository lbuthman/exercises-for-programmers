package lbuthman.exercise8;

import java.util.Scanner;
import static tools.Tools.*;

public class PizzaParty1 {
    public static void main(String[] args) {

        int SLICES_PER_PIZZA = 8;

        Scanner scanner = getScanner();

        print("How many hungry folks you got? ");
        int people = scanner.nextInt();

        print("How many pizzas do you have? ");
        int pizzas = scanner.nextInt();

        int totalSlices = pizzas * SLICES_PER_PIZZA;

        int slicesPerPerson = totalSlices / people;
        int leftOverSlices = totalSlices - (people * slicesPerPerson);

        println("Each person gets " + slicesPerPerson + " slices of pizza.");

        if (leftOverSlices == 1) {
            println("There is one extra slice. Better move fast ...");

        }
        else if (leftOverSlices > 0){
            println("There are " + leftOverSlices + " extra slices. Game on!");

        } else {
            println("Sorry, there are no extra slices. Order some more?");
        }

    }
}

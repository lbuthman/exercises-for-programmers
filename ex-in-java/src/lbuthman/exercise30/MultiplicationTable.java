package lbuthman.exercise30;

import static tools.Tools.*;

public class MultiplicationTable {
    public static void main(String[] args) {

        println("Hello, and welcome to a simple 12 x 12 multiplication table. Exciting.");

        for (int i=0; i<=12; i++) {
            for (int j=0; j<=12; j++) {
                println(i + " x " + j + " = " + (i * j));
            }
        }
    }
}

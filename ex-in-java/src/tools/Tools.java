package tools;

import java.util.Scanner;

public class Tools {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void print(Object o) {
        System.out.print(o.toString());
    }

    public static void println(Object o) {
        System.out.println(o.toString());
    }
}

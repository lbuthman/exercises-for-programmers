package exercise33;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tools.Tools.*;

public class Magic8Ball {

    static Scanner input = getScanner();

    public static void main(String[] args) {

        List<String> responses = new ArrayList<>();
        responses.add("It is certain.");
        responses.add("As I see it, yes.");
        responses.add("Reply hazy try again.");
        responses.add("Don't count on it.");
        responses.add("It is decidedly so.");
        responses.add("Most likely.");
        responses.add("Ask again later.");
        responses.add("My reply is no.");
        responses.add("Without a doubt.");
        responses.add("Outlook good.");
        responses.add("Better not tell you now.");
        responses.add("My sources say no.");
        responses.add("Yes definitely.");
        responses.add("Yes.");
        responses.add("Cannot predict now.");
        responses.add("Outlook not so good.");
        responses.add("You may rely on it.");
        responses.add("Signs point to yes.");
        responses.add("Concentrate and ask again.");
        responses.add("Very doubtful.");

        println("Welcome to Omniscient Magic 8 Ball.");

        while (true) {

            print("Ready to ask a question? (y or n) ");
            boolean anotherQuestion = (input.next().equals("y"));

            if (!anotherQuestion) { break; }

            askQuestion();

            println(" " + responses.get(getRandomInt()));
        }

        println("Goodbye.");
    }

    private static void askQuestion() {
        println("Picture your question in your mind's eye my child");

        int i = 0;
        print("Thinking .");
        while (i < 10) {
            print("..");
            try { Thread.sleep(1000); }
            catch (Exception e) { e.printStackTrace(); }
            i++;
        }
    }

    private static int getRandomInt() {
        return (int) (Math.random() * 20) + 1;
    }
}

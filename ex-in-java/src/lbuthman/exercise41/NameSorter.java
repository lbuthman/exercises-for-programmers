package lbuthman.exercise41;

import java.nio.file.Path;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import static tools.Tools.*;

public class NameSorter {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get("files","names.txt"));
            lines.forEach(names::add);
            lines.close();

        }
        catch (IOException e) {
            print("Error");
        }

        println("Total of " + names.size() + " names");
        println("------------------");
        for (String s: names) {
            println(s);
        }
    }
}

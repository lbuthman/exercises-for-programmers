package lbuthman.exercise45;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static tools.Tools.*;

public class WordFinder {
    public static void main(String[] args) {
        Scanner input = getScanner();

        Path path = Paths.get(".","/files/old.txt");
        Charset charset = StandardCharsets.UTF_8;

        println("Let's replace some text!");
        print("What name do you want to give the new file? ");
        String fileName = input.next();

        try {
            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("utilize", "use");
            Path newPath = Paths.get(".", "/files/" + fileName + ".txt");
            Files.write(newPath, content.getBytes(charset));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

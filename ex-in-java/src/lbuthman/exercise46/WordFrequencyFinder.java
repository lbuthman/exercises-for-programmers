package lbuthman.exercise46;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static tools.Tools.*;

public class WordFrequencyFinder {
    public static void main(String[] args) {

        Path path = Paths.get(".", "/files/words.txt");
        Charset charset = StandardCharsets.UTF_8;
        String content = null;

        try {
            content = new String(Files.readAllBytes(path), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] wordArray = content.split(" |\n");
        Map<String, Integer> wordMap = new LinkedHashMap<>();

        for (String s: wordArray) {
            if (wordMap.containsKey(s)) {
                int i = wordMap.get(s) + 1;
                wordMap.replace(s, i);
            } else {
                wordMap.put(s, 1);
            }
        }

        wordMap = wordMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        wordMap.forEach((k, v) -> println(k + ": " + String.join("", Collections.nCopies(v, "*"))));

    }
}

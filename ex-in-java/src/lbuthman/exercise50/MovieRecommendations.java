package lbuthman.exercise50;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static tools.Tools.*;
import static tools.Keys.*;

public class MovieRecommendations {
    public static void main(String[] args) {
        final String BASE = "https://api.themoviedb.org/3/search/movie?api_key=";
        final String KEY = getMovieKey();
        final String QUERY = "&query=";

        Scanner input = getScanner();

        print("Enter the name of a movie: ");
        String title = input.next();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;

        try {
            root = objectMapper.readTree(new URL(BASE + KEY + QUERY + title));
        }
        catch (IOException e) {
            println(e.getCause());
        }

        JsonNode content = root.get("results");

        for (int i=0; i<content.size(); i++) {
            JsonNode item = content.get(i);
            println("***");
            println("\tTitle: " + item.get("title").asText());
            println("\tRelease Date: " + item.get("release_date").asText());
            println("\tDescription: " + item.get("overview").asText());
            println("");
            double score = item.get("vote_average").asDouble();
            if (score > 7) {
                println("\tYou should watch this movie right now!!");
            }
            else if (score > 5) {
                println("\tThis might not suck ...");
            }
            else if (score == 0) {
                println("\tThis movie might not be out yet, because it doesn't have a score.");
            }
            else {
                println("\tAvoid this movie at all costs");
            }
            println("***");
        }
    }
}

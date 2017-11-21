package exercise48;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static tools.Tools.*;
import static tools.Keys.*;

public class GrabbingWeather {
    public static void main(String[] args) {
        final String BASE = "https://api.wunderground.com/api/";
        final String KEY = getWU();
        final String QUERY = "/forecast10day/q/";
        final String POST_SCRIPT = ".json";

        Scanner input = getScanner();

        print("What state are you in? ");
        String state = input.next();
        input.nextLine();

        print("What city are you in? ");
        String city = input.nextLine();
        String queryCity = city.replace(" ", "_");

        print("How many days forecast do you want? ");
        int numberOfDays = input.nextInt();
        numberOfDays = numberOfDays <= 10 ? numberOfDays : 10;

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;

        try {
            println("(searching ...)");
            root = objectMapper.readTree(new URL(BASE + KEY + QUERY + state + "/" + queryCity + POST_SCRIPT));
        }
        catch (IOException e) {
            println(e.getCause());
        }

        JsonNode content = root.get("forecast");
        content = content.get("simpleforecast");
        content = content.get("forecastday");

        println(city + ", " + state + " Weather:");
        for (int i=1; i<=numberOfDays; i++) {
            JsonNode date = content.get(i).get("date");
            println(date.get("weekday").asText() + " " + date.get("monthname").asText() + " " +
                    date.get("day") + ", " + date.get("year"));
            println("  High: " + content.get(i).get("high").get("fahrenheit").asText());
            println("  Low: " + content.get(i).get("low").get("fahrenheit").asText());
        }

    }
}

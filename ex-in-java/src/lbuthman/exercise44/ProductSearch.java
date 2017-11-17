package lbuthman.exercise44;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

import static tools.Tools.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

public class ProductSearch {
    public static void main(String[] args) {
        Scanner input = getScanner();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        String json = null;
        String productName;

        try {
            FileInputStream jsonFile = new FileInputStream(new File("./files/products.json"));
            json = IOUtils.toString(jsonFile);
            root = mapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            print("What is the Product name? ");
            productName = input.next();

            if (json.contains(productName)) {
                break;
            }
            print("Sorry, that product was not found in our inventory.");
        }


        JsonNode products = root.get("products");
        for (int i=0; i<products.size(); i++) {
            if (products.get(i).get("name").textValue().equals(productName)) {
                println("Name: " + products.get(i).get("name").textValue());
                println("Price: " + numberFormat.format(products.get(i).get("price").asDouble()));
                println("Quantity on Hand: " + products.get(i).get("quantity").asInt());
            }
        }
    }
}

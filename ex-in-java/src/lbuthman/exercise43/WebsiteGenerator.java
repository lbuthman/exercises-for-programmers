package lbuthman.exercise43;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static tools.Tools.*;
import org.apache.commons.io.FileUtils;

public class WebsiteGenerator {
    public static void main(String[] args) {
        Scanner input = getScanner();

        print("Enter site name: ");
        String siteName = input.next();

        print("Enter Author name: ");
        input.nextLine(); //clear previous newline character
        String author = input.nextLine();

        print("Do you want a Javascript folder? (y or n) ");
        boolean shouldMakeJSFolder = input.next().equals("y");

        print("Do you want a CSS folder? (y or n) ");
        boolean shouldMakeCSSFolder = input.next().equals("y");

        String rootPath = "./" + siteName;
        createFolder(rootPath);

        String indexHtmlContents = generateIndexHtml(siteName, author);
        String indexHtmlPath = rootPath + "/index.html";
        createFile(indexHtmlPath, indexHtmlContents);

        if (shouldMakeJSFolder) {
            String jsPath = rootPath + "/js";
            createFolder(jsPath);
        }

        if (shouldMakeCSSFolder) {
            String cssPath = rootPath + "/css";
            createFolder(cssPath);
        }

    }

    private static String generateIndexHtml(String siteName, String author) {
        String index = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" +
            "<head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta name=\"author\" content=\"" + author + "\">\n" +
            "  <title>" + siteName + "</title>\n" +
            "</head>\n" + "<body>\n" + "\n" + "</body>\n" + "</html>";

        return index;
    }

    private static void createFolder(String path) {
        File site = new File(path);
        boolean isSuccessful = site.mkdir();
        if (isSuccessful) {
            println("Created " + path);
        } else {
            println(path+ " folder could not be created.");
        }
    }

    private static void createFile(String path, String contents) {
        try {
            FileUtils.write(new File(path), contents);
            println("Created " + path);
        }
        catch (IOException e) {
            println("index.html could not be created.");
        }
    }
}

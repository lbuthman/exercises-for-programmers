package exercise47;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static tools.Tools.*;

public class WhoIsInSpace {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;

        try {
            root = objectMapper.readTree(new URL("http://api.open-notify.org/astros.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode content = root.get("people");
        int maxNameLength = 0;
        int maxCraftLength = 0;
        List<SpaceMan> spaceManList = new ArrayList<>();

        for (int i=0; i<content.size(); i++) {
            String name = content.get(i).get("name").asText();
            String craft = content.get(i).get("craft").asText();
            spaceManList.add(new SpaceMan(name, craft));

            maxNameLength = maxNameLength > name.length() ? maxNameLength : name.length();
            maxCraftLength = maxCraftLength > craft.length() ? maxCraftLength : craft.length();
        }

        print("Name");
        println(String.format("%" + (maxNameLength + 4) + "s",  "Craft"));
        print(String.join("", Collections.nCopies(maxNameLength + 1, "-")) + "|");
        println(String.join("", Collections.nCopies(maxCraftLength + 3, "-")));

        for (SpaceMan spaceMan: spaceManList) {
            print(String.format("%" + (maxNameLength + 1) + "s", spaceMan.getName()));
            print("|");
            println(String.format("%" + (maxCraftLength + 1) + "s", spaceMan.getCraft()));
        }
    }
}

class SpaceMan {
    private String name;
    private String craft;

    SpaceMan(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }
}

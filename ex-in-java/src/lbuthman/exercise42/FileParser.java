package lbuthman.exercise42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static tools.Tools.*;

public class FileParser {
    public static void main(String[] args) {

        List<People> peoples = new ArrayList<>();
        BufferedReader bufferedReader;
        String line;
        String csvSplitBy = ",";
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(0);

        int columnOneMax = 0;
        int columnTwoMax = 0;
        int columnThreeMax = 0;

        try {
            bufferedReader = new BufferedReader(
                    new FileReader("/Users/lbuthman/IdeaProjects/exercises-for-programmers/files/employees.csv"));

            while ((line = bufferedReader.readLine()) != null) {
                String[] onePerson = line.split(csvSplitBy);
                peoples.add(new People(onePerson[1], onePerson[0], Integer.parseInt(onePerson[2])));

                int columnOneSize = onePerson[0].length();
                int columnTwoSize = onePerson[1].length();
                int columnThreeSize = onePerson[2].length();

                columnOneMax = columnOneSize > columnOneMax ? columnOneSize : columnOneMax;
                columnTwoMax = columnTwoSize > columnTwoMax ? columnTwoSize : columnTwoMax;
                columnThreeMax = columnThreeSize > columnThreeMax ? columnThreeSize : columnThreeMax;
            }

            bufferedReader.close();

        }
        catch (IOException e) {
            print("Error");
        }

        print(String.format("%" + (columnOneMax + 1) + "s", "Last"));
        print(String.format("%" + (columnTwoMax + 2) + "s", "First"));
        println(String.format("%" + (columnThreeMax + 6) + "s", "Salary"));
        println("-------------------------------");

        for (People p: peoples) {
            print(String.format("%" + (columnOneMax + 1) + "s", p.getLastName()));
            print(String.format("%" + (columnTwoMax + 2) + "s", p.getFirstName()));
            println(String.format("%" + (columnThreeMax + 6) + "s", numberFormat.format(p.getSalary())));
        }

    }
}

class People {
    String firstName;
    String lastName;
    Integer salary;

    People(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

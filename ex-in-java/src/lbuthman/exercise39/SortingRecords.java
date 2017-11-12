package lbuthman.exercise39;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static tools.Tools.*;

public class SortingRecords {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(
                new Employee("John", "Johnson", "Manager", LocalDate.parse("2016-12-31")));
        employees.add(
                new Employee("Tou", "Xiong", "Software Engineer", LocalDate.parse("2016-10-05")));
        employees.add(
                new Employee("Michaela", "Michaelson", "District Manager", LocalDate.parse("2015-12-19")));
        employees.add(
                new Employee("Jake", "Jacobson", "Programmer"));
        employees.add(
                new Employee("Jacquelyn", "Jackson", "DBA"));
        employees.add(
                new Employee("Sally", "Weber", "Web Developer", LocalDate.parse("2015-12-18")));

        //employees.sort((Employee e1, Employee e2) -> e1.getLastName().compareTo(e2.getLastName()));
        employees.sort(Comparator.comparing(Employee::getLastName));

        println("First Name\t|\tLastName\t|\tPosition\t|\tSeparation Date");
        println("----------------------------------------------------------------");

        for (Employee e: employees) {
            print(e.getFirstName() + "\t\t");
            print(e.getLastName() + "\t\t");
            print(e.getPosition() + "\t\t");
            if (e.getSeparationDate() != null) {
                println(e.getSeparationDate().toString());
            }
            else {
                println("");
            }
        }
    }
}

class Employee {

    private String firstName;
    private String lastName;
    private String position;
    private LocalDate separationDate;

    Employee(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    Employee(String firstName, String lastName, String position, LocalDate separationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.separationDate = separationDate;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getSeparationDate() {
        return separationDate;
    }

    public void setSeparationDate(LocalDate separationDate) {
        this.separationDate = separationDate;
    }
}

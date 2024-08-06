package pro.sky.skyproempl;


import java.lang.String;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Employee employee = (Employee) a;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }
    public String toString() {
        return String.format("%s %s",
                firstName, lastName);
    }

}

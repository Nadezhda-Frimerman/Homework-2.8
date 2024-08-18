package pro.sky.skyproempl;


import java.lang.String;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Employee employee = (Employee) a;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                department == employee.department &&
                Double.compare(salary, employee.salary) == 0;
    }

    public String toString() {
        return firstName + " " + lastName + " " + "department: " + department + " salary: " + salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }
}
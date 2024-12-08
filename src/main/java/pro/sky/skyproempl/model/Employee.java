package pro.sky.skyproempl.model;


import java.lang.String;
import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private Integer department;
    private Double salary;

    public Employee(String firstName, String lastName, Integer department, Double salary) {
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
        return Objects.equals(this.firstName, employee.firstName) &&
                Objects.equals(this.lastName, employee.lastName) &&
                Integer.compare(this.department, employee.department) == 0 &&
                Double.compare(this.salary, employee.salary) == 0;
    }

    public String toString() {
        return firstName + " " + lastName + " " + "department: " + department + " salary: " + salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDepartment() {
        return department;
    }
}
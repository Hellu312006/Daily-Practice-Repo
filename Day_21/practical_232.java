package Day_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Employee class for Custom Sorting
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Salary: Rs." + salary;
    }
}

// Q12: Custom Sorting in ArrayList using Comparator
public class practical_232 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Rahul Verma", 65000));
        employees.add(new Employee(101, "Aman Gupta", 85000));
        employees.add(new Employee(104, "Priya Sharma", 52000));
        employees.add(new Employee(102, "Sneha Patel", 95000));

        System.out.println("=== Original Employee List ===");
        for (Employee e : employees) System.out.println(e);

        // 1. Sort by Salary (Ascending) using Comparator
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\n--- Sorted by Salary (Lowest to Highest) ---");
        for (Employee e : employees) System.out.println(e);

        // 2. Sort by Name Alphabetically
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("\n--- Sorted Alphabetically by Name ---");
        for (Employee e : employees) System.out.println(e);
    }
}

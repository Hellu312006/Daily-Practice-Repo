package Day_08;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee() {
        this.id = 100;
        this.name = "Unknown Employee";
        this.department = "Bench / Trainee";
        this.salary = 25000.0;
        System.out.println("Default Constructor invoked. Base values initialized.");
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        System.out.println("Parameterized Constructor invoked for: " + name);
    }

    public void displayDetails() {
        System.out.println("Employee ID:   " + id);
        System.out.println("Name:          " + name);
        System.out.println("Department:    " + department);
        System.out.println("Salary:        $" + salary);
        System.out.println("----------------------------------------");
    }
}

public class practical_801 {
    public static void main(String[] args) {
        System.out.println("=== Creating employee1 using Default Constructor (Base Values) ===");
        Employee employee1 = new Employee();
        employee1.displayDetails();

        System.out.println("=== Creating employee2 using Parameterized Constructor ===");
        Employee employee2 = new Employee(102, "John Doe", "Engineering", 80000.0);
        employee2.displayDetails();
    }
}

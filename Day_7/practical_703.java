package Day_7;

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void displayDetails() {
        System.out.println("Employee ID:      " + id);
        System.out.println("Employee Name:    " + name);
        System.out.println("Designation:      " + designation);
        System.out.println("Monthly Salary:   $" + salary);
        System.out.println("Annual Salary:    $" + calculateAnnualSalary());
        System.out.println("---------------------------------");
    }
}

public class practical_703 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Amit Sharma", "Software Engineer", 5000.0);
        Employee emp2 = new Employee(102, "Pooja Patel", "Project Manager", 8500.0);

        System.out.println("--- Employee 1 Details ---");
        emp1.displayDetails();

        System.out.println("--- Employee 2 Details ---");
        emp2.displayDetails();
    }
}

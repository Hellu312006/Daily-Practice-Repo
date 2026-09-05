package Day_17;

// Q5: Create abstract class Employee with calculateSalary().

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void calculateSalary() {
        System.out.println("Full-Time Employee: " + name + " | Salary: Rs. " + monthlySalary);
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    void calculateSalary() {
        double totalSalary = hoursWorked * hourlyRate;
        System.out.println("Part-Time Employee: " + name + " | Salary: Rs. " + totalSalary);
    }
}

public class practical_175 {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee("Alex", 50000.0);
        Employee emp2 = new PartTimeEmployee("Bob", 40, 500.0);

        emp1.calculateSalary();
        emp2.calculateSalary();
    }
}

package Day_32;

// ============================================================================
// Practical 230 / Day 32: Demonstration of Inheritance in Java
// Covers:
// 1. Single Inheritance (Person -> Employee)
// 2. Multilevel Inheritance (Person -> Employee -> Manager)
// 3. Hierarchical Inheritance (Person -> Student)
// 4. Use of 'super' keyword (Constructor & Method invocation)
// 5. Method Overriding (@Override)
// ============================================================================

// ----------------------------------------------------------------------------
// Base / Parent / Super Class
// ----------------------------------------------------------------------------
class Person {
    protected String name;
    protected int age;

    // Parent constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public void role() {
        System.out.println("Role : General Person");
    }
}

// ----------------------------------------------------------------------------
// 1. Single Inheritance (Employee extends Person)
// ----------------------------------------------------------------------------
class Employee extends Person {
    protected int empId;
    protected double salary;

    public Employee(String name, int age, int empId, double salary) {
        super(name, age); // Calling superclass constructor
        this.empId = empId;
        this.salary = salary;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Reusing parent display logic
        System.out.println("Emp ID : " + empId);
        System.out.printf("Salary : $%.2f\n", salary);
    }

    @Override
    public void role() {
        System.out.println("Role   : Corporate Employee");
    }
}

// ----------------------------------------------------------------------------
// 2. Multilevel Inheritance (Manager extends Employee -> Employee extends Person)
// ----------------------------------------------------------------------------
class Manager extends Employee {
    private String department;

    public Manager(String name, int age, int empId, double salary, String department) {
        super(name, age, empId, salary); // Calling Employee constructor
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Dept   : " + department);
    }

    @Override
    public void role() {
        System.out.println("Role   : Department Manager");
    }

    public void conductMeeting() {
        System.out.println(name + " is conducting a team sync meeting for " + department + ".");
    }
}

// ----------------------------------------------------------------------------
// 3. Hierarchical Inheritance (Student also extends Person)
// ----------------------------------------------------------------------------
class Student extends Person {
    private String studentId;
    private String course;

    public Student(String name, int age, String studentId, String course) {
        super(name, age); // Calling Person constructor
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID : " + studentId);
        System.out.println("Course     : " + course);
    }

    @Override
    public void role() {
        System.out.println("Role       : University Student");
    }
}

// ----------------------------------------------------------------------------
// Main Driver Class
// ----------------------------------------------------------------------------
public class practical_230 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 230: Inheritance Demonstration in Java ===");
        System.out.println("=============================================================\n");

        // 1. Single Inheritance Demonstration
        System.out.println("--- 1. Single Inheritance (Person -> Employee) ---");
        Employee emp = new Employee("Alice Johnson", 28, 101, 65000.00);
        emp.displayDetails();
        emp.role();

        // 2. Multilevel Inheritance Demonstration
        System.out.println("\n--- 2. Multilevel Inheritance (Person -> Employee -> Manager) ---");
        Manager mgr = new Manager("Bob Smith", 42, 201, 115000.00, "Software Engineering");
        mgr.displayDetails();
        mgr.role();
        mgr.conductMeeting();

        // 3. Hierarchical Inheritance Demonstration
        System.out.println("\n--- 3. Hierarchical Inheritance (Person -> Student) ---");
        Student student = new Student("Charlie Brown", 20, "STU987", "Computer Science");
        student.displayDetails();
        student.role();

        System.out.println("\n=============================================================");
        System.out.println("Inheritance practical executed successfully!");
        System.out.println("=============================================================");
    }
}

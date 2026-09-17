package Day_28;

// ============================================================================
// Practical 285: Demonstrate Types of Inheritance and 'super' Keyword in Java
// ============================================================================

// 1. Base / Super Class
class Person {
    String name;
    int age;

    // Parameterized Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}

// 2. Single Inheritance: Employee extends Person
class Employee extends Person {
    int employeeId;
    double salary;

    Employee(String name, int age, int employeeId, double salary) {
        super(name, age); // Calling superclass (Person) constructor
        this.employeeId = employeeId;
        this.salary = salary;
    }

    // Overriding displayInfo and calling super.displayInfo()
    @Override
    void displayInfo() {
        super.displayInfo(); // Reusing parent's display logic
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary     : $" + salary);
    }
}

// 3. Multilevel Inheritance: Manager extends Employee (which extends Person)
class Manager extends Employee {
    String department;

    Manager(String name, int age, int employeeId, double salary, String department) {
        super(name, age, employeeId, salary); // Calling Employee constructor
        this.department = department;
    }

    void conductMeeting() {
        System.out.println(name + " is conducting a meeting for " + department + " department.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Department : " + department);
    }
}

// 4. Hierarchical Inheritance: Student also extends Person
class Student extends Person {
    String course;
    double grade;

    Student(String name, int age, String course, double grade) {
        super(name, age);
        this.course = course;
        this.grade = grade;
    }

    void study() {
        System.out.println(name + " is studying " + course + ".");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Course     : " + course);
        System.out.println("Grade      : " + grade);
    }
}

public class practical_285 {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("=== Practical 285: Inheritance Demo in Java   ===");
        System.out.println("=================================================\n");

        // 1. Single Inheritance Demonstration
        System.out.println("--- 1. Single Inheritance (Employee extends Person) ---");
        Employee emp = new Employee("Alice Smith", 28, 101, 75000.0);
        emp.displayInfo();

        System.out.println("\n-------------------------------------------------");

        // 2. Multilevel Inheritance Demonstration
        System.out.println("--- 2. Multilevel Inheritance (Manager -> Employee -> Person) ---");
        Manager mgr = new Manager("Bob Johnson", 40, 102, 120000.0, "Engineering");
        mgr.displayInfo();
        mgr.conductMeeting();

        System.out.println("\n-------------------------------------------------");

        // 3. Hierarchical Inheritance Demonstration
        System.out.println("--- 3. Hierarchical Inheritance (Student extends Person) ---");
        Student stu = new Student("Charlie Brown", 20, "Computer Science", 3.9);
        stu.displayInfo();
        stu.study();

        System.out.println("\n=================================================");
        System.out.println("Program executed successfully!");
    }
}

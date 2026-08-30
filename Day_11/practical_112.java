package Day_11;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age:  " + age);
    }
}

class StudentInfo extends Person {
    int rollNo;
    String course;

    public StudentInfo(String name, int age, int rollNo, String course) {
        super(name, age);
        this.rollNo = rollNo;
        this.course = course;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course:  " + course);
    }
}

class EmployeeInfo extends Person {
    int empId;
    double salary;

    public EmployeeInfo(String name, int age, int empId, double salary) {
        super(name, age);
        this.empId = empId;
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary:      $" + salary);
    }
}

public class practical_112 {
    public static void main(String[] args) {
        System.out.println("=== Student Details ===");
        StudentInfo student = new StudentInfo("Aarav Sharma", 20, 101, "Computer Science");
        student.display();
        System.out.println("-----------------------");
        System.out.println();

        System.out.println("=== Employee Details ===");
        EmployeeInfo employee = new EmployeeInfo("Pooja Patel", 28, 2045, 65000.0);
        employee.display();
        System.out.println("-----------------------");
    }
}

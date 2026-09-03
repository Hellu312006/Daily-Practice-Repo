package Day_15;

// Q10: Person -> Student -> CollegeStudent (Multilevel Inheritance with constructors, variables, and methods)

class Person10 {
    String name;

    // Person Constructor
    Person10(String name) {
        this.name = name;
    }

    // Person Method
    void displayPerson() {
        System.out.println("Name:           " + name);
    }
}

class Student10 extends Person10 {
    int rollNo;

    // Student Constructor invoking Person Constructor using super
    Student10(String name, int rollNo) {
        super(name);
        this.rollNo = rollNo;
    }

    // Student Method
    void displayStudent() {
        displayPerson();
        System.out.println("Roll Number:    " + rollNo);
    }
}

class CollegeStudent extends Student10 {
    String collegeName;
    String branch;

    // CollegeStudent Constructor invoking Student Constructor using super
    CollegeStudent(String name, int rollNo, String collegeName, String branch) {
        super(name, rollNo);
        this.collegeName = collegeName;
        this.branch = branch;
    }

    // CollegeStudent Method to display all information
    void displayAll() {
        displayStudent();
        System.out.println("College Name:   " + collegeName);
        System.out.println("Branch:         " + branch);
    }
}

public class practical_160 {
    public static void main(String[] args) {
        System.out.println("=== College Student Complete Information ===");

        // Creating CollegeStudent object with all details
        CollegeStudent cs = new CollegeStudent("Hely", 101, "ABC Institute of Technology", "Computer Engineering");

        // Displaying all details
        cs.displayAll();
    }
}

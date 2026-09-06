package Day_18;

// Q10: Multiple Inheritance using Interfaces (Printable & Showable -> Student)

interface Printable {
    void print();
}

interface Showable {
    void show();
}

class Student implements Printable, Showable {
    private int rollNo;
    private String name;
    private String branch;

    Student(int rollNo, String name, String branch) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
    }

    // Implementing method from Printable interface
    @Override
    public void print() {
        System.out.println("--- Printing Student Details ---");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
    }

    // Implementing method from Showable interface
    @Override
    public void show() {
        System.out.println("Displaying Student: " + name + " (" + branch + ")");
    }
}

public class practical_190 {
    public static void main(String[] args) {
        Student student = new Student(101, "Priya Sharma", "Computer Science");

        // Executing method from Printable
        student.print();

        System.out.println();

        // Executing method from Showable
        student.show();
    }
}

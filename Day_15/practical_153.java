package Day_15;

// Q3: Person -> Student and display name and roll number

class Person {
    String name = "Hely";
}

class Student extends Person {
    int rollNo = 101;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

public class practical_153 {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}

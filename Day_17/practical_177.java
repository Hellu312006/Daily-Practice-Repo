package Day_17;

// Q7: Create abstract class Person with abstract role() and implement it in Student and Teacher.

abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void role();
}

class Student extends Person {
    Student(String name) {
        super(name);
    }

    @Override
    void role() {
        System.out.println(name + " is a Student: Studies subjects and attends lectures.");
    }
}

class Teacher extends Person {
    Teacher(String name) {
        super(name);
    }

    @Override
    void role() {
        System.out.println(name + " is a Teacher: Teaches students and evaluates exams.");
    }
}

public class practical_177 {
    public static void main(String[] args) {
        Person p1 = new Student("Rahul");
        Person p2 = new Teacher("Dr. Sharma");

        p1.role();
        p2.role();
    }
}

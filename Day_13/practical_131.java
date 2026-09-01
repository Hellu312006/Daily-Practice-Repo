package Day_13;

class Student {
    String name;
    static String college = "ABC College";

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " - " + college);
    }
}

public class practical_131 {
    public static void main(String[] args) {
        Student s1 = new Student("Hely");
        Student s2 = new Student("Rahul");
        Student s3 = new Student("Amit");

        s1.display();
        s2.display();
        s3.display();
    }
}

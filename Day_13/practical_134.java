package Day_13;

class StudentCounter {
    String name;
    static int count = 0; // Static variable shared among all instances

    StudentCounter(String name) {
        this.name = name;
        count++; // Increment counter whenever a new object is created
        System.out.println("Object created for: " + this.name + " | Current Count = " + count);
    }

    static void displayTotalCount() {
        System.out.println("----------------------------------------");
        System.out.println("Total Objects Created: " + count);
    }
}

public class practical_134 {
    public static void main(String[] args) {
        System.out.println("=== Static Counter Demonstration ===");

        StudentCounter s1 = new StudentCounter("Hely");
        StudentCounter s2 = new StudentCounter("Rahul");
        StudentCounter s3 = new StudentCounter("Amit");

        StudentCounter.displayTotalCount();
    }
}

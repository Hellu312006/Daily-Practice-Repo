package Day_13;

class Calculate {

    static String college = "ABC College";

    // 1. Static method to change static variable
    static void changeCollege(String newCollege) {
        college = newCollege;
    }

    // 2. Static method to perform calculation without creating an object
    static int cube(int x) {
        return x * x * x;
    }
}

public class practical_135 {
    public static void main(String[] args) {

        // Calling static method for calculation (No object needed)
        int result = Calculate.cube(5);
        System.out.println("Cube of 5: " + result);

        // Accessing and modifying static variable via static method
        System.out.println("Original College: " + Calculate.college);
        
        Calculate.changeCollege("GTU University");
        System.out.println("Updated College:  " + Calculate.college);
    }
}

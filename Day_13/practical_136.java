package Day_13;

public class practical_136 {

    // Static method for addition
    static int add(int a, int b) {
        return a + b;
    }

    // Static method for multiplication
    static int multiply(int a, int b) {
        return a * b;
    }

    // Static method to find maximum
    static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        // Calling static methods directly without creating an object
        System.out.println("Addition:       " + add(x, y));
        System.out.println("Multiplication: " + multiply(x, y));
        System.out.println("Maximum:        " + findMax(x, y));
    }
}

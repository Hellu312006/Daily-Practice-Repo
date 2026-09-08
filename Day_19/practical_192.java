package Day_19;

// Q2: Array index out of bounds exception handle karna
public class practical_192 {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };
        int invalidIndex = 7;

        try {
            System.out.println("Element: " + numbers[invalidIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index limit se bahar hai! (" + e.getMessage() + ")");
        }

        System.out.println("Program successfully continue hua.");
    }
}

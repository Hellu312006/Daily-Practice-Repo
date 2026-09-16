package Day_27;

import java.util.Scanner;

// ============================================================================
// Practical 282: Handle exception inside a method
// ============================================================================

public class practical_282 {

    // 1. Method to divide two numbers and handle ArithmeticException inside
    public static void divide(int num, int den) {
        System.out.println("Calling divide(" + num + ", " + den + ")...");
        try {
            int result = num / den;
            System.out.println("-> Success: Result is " + result);
        } catch (ArithmeticException e) {
            System.out.println("-> [Exception Handled in divide()]: Cannot divide by zero (" + e.getMessage() + ")");
        }
    }

    // 2. Method to convert string to integer and handle NumberFormatException inside
    public static void parseAge(String ageText) {
        System.out.println("Calling parseAge(\"" + ageText + "\")...");
        try {
            int age = Integer.parseInt(ageText);
            System.out.println("-> Success: Valid age entered: " + age);
        } catch (NumberFormatException e) {
            System.out.println("-> [Exception Handled in parseAge()]: Invalid number format for input \"" + ageText + "\"");
        }
    }

    // 3. Method to access array element and handle ArrayIndexOutOfBoundsException inside
    public static void printArrayElement(int[] array, int index) {
        System.out.println("Calling printArrayElement(array, " + index + ")...");
        try {
            int val = array[index];
            System.out.println("-> Success: Element at index " + index + " is " + val);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-> [Exception Handled in printArrayElement()]: Index " + index + " is out of bounds!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Practical 282: Handle Exception Inside a Method ===\n");

        // Test 1: Division Method
        System.out.println("--- Test 1: divide() Method ---");
        divide(100, 5);  // Valid
        divide(100, 0);  // Exception handled internally

        // Test 2: Number Parsing Method
        System.out.println("\n--- Test 2: parseAge() Method ---");
        parseAge("25");      // Valid
        parseAge("twenty");  // Exception handled internally

        // Test 3: Array Access Method
        System.out.println("\n--- Test 3: printArrayElement() Method ---");
        int[] scores = { 85, 90, 95 };
        printArrayElement(scores, 1);   // Valid
        printArrayElement(scores, 10);  // Exception handled internally

        // Interactive Testing
        System.out.println("\n--- Test 4: Interactive Input ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int n = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int d = scanner.nextInt();

        // Main calls the method; exception (if any) is handled inside divide()
        divide(n, d);

        scanner.close();
        System.out.println("\nMain method completed successfully without crashing!");
    }
}

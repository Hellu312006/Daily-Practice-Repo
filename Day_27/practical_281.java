package Day_27;

import java.util.Scanner;

// ============================================================================
// Practical 281: Handle Multiple Different Exceptions
// ============================================================================

public class practical_281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 281: Handle Multiple Different Exceptions ===\n");

        System.out.println("Choose a scenario to test exception handling:");
        System.out.println("1. Division by Zero (ArithmeticException)");
        System.out.println("2. Invalid Array Index (ArrayIndexOutOfBoundsException)");
        System.out.println("3. Invalid String to Number Parsing (NumberFormatException)");
        System.out.println("4. Calling method on Null (NullPointerException)");
        System.out.println("5. Normal execution (No exception)");
        System.out.print("\nEnter choice (1-5): ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter numerator: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter denominator (try 0): ");
                    int den = Integer.parseInt(scanner.nextLine());
                    int divResult = num / den;
                    System.out.println("Result: " + divResult);
                    break;

                case 2:
                    int[] arr = { 10, 20, 30, 40, 50 };
                    System.out.println("Array size is 5 (Valid indices: 0 to 4)");
                    System.out.print("Enter array index to access (try 10): ");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("Value at index " + index + " = " + arr[index]);
                    break;

                case 3:
                    System.out.print("Enter a string to convert to integer (try 'abc'): ");
                    String text = scanner.nextLine();
                    int parsedNum = Integer.parseInt(text);
                    System.out.println("Successfully parsed number: " + parsedNum);
                    break;

                case 4:
                    String nullString = null;
                    System.out.println("Accessing length of a null string...");
                    System.out.println("Length: " + nullString.length());
                    break;

                case 5:
                    System.out.println("Running normal flow without any exceptions!");
                    int a = 100, b = 5;
                    System.out.println("Result: 100 / 5 = " + (a / b));
                    break;

                default:
                    System.out.println("Invalid choice selected.");
                    break;
            }

        } catch (ArithmeticException e) {
            System.out.println("\n[Caught ArithmeticException]: Cannot divide by zero -> " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n[Caught ArrayIndexOutOfBoundsException]: Index is out of range -> " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\n[Caught NumberFormatException]: Invalid number format -> " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("\n[Caught NullPointerException]: Attempted to access null object -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[Caught General Exception]: " + e.getMessage());
        } finally {
            System.out.println("\n[Finally Block]: Cleanup operations executed. Scanner closed.");
            scanner.close();
        }

        System.out.println("\nProgram execution completed safely without crashing.");
    }
}

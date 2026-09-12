package Day_23;

import java.util.Scanner;

// Q6: Multiple catch blocks to handle different exceptions from specific to general
public class practical_246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Multiple Catch Blocks Demonstration ===");

        try {
            System.out.print("Enter first integer (dividend): ");
            String inputA = scanner.nextLine();
            int a = Integer.parseInt(inputA); // May throw NumberFormatException

            System.out.print("Enter second integer (divisor/index): ");
            String inputB = scanner.nextLine();
            int b = Integer.parseInt(inputB); // May throw NumberFormatException

            int divResult = a / b; // May throw ArithmeticException (if b == 0)
            System.out.println("Division result: " + a + " / " + b + " = " + divResult);

            int[] sampleArray = { 100, 200, 300, 400 };
            System.out.println("Array value at index " + b + ": " + sampleArray[b]); // May throw ArrayIndexOutOfBoundsException

            String text = (a > 10) ? "Antigravity Java Practice" : null;
            System.out.println("Text length: " + text.length()); // May throw NullPointerException if a <= 10

        } catch (NumberFormatException e) {
            System.out.println("[Catch 1 - NumberFormatException]: Input is not a valid integer -> " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("[Catch 2 - ArithmeticException]: Cannot divide by zero -> " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[Catch 3 - ArrayIndexOutOfBoundsException]: Array index out of range -> " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("[Catch 4 - NullPointerException]: Cannot call method on null reference -> " + e.getMessage());
        } catch (Exception e) {
            // General / parent exception block must always be at the end
            System.out.println("[Catch 5 - General Exception]: Unhandled exception -> " + e.getMessage());
        } finally {
            System.out.println("Finally Block: Cleaning up resources.");
            scanner.close();
        }

        System.out.println("Execution finished normally.");
    }
}

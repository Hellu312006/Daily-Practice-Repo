package Day_23;

import java.util.Scanner;

// Q5: Comprehensive Exception Handling Demo using try-catch-finally
// Handles: ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException, NumberFormatException
public class practical_245 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("  Comprehensive Exception Handling with try-catch-finally");
        System.out.println("=================================================");
        System.out.println("1. Test ArithmeticException (Division by zero)");
        System.out.println("2. Test ArrayIndexOutOfBoundsException (Invalid array index)");
        System.out.println("3. Test NullPointerException (Null reference method call)");
        System.out.println("4. Test NumberFormatException (Invalid string parsing)");
        System.out.println("5. Test Normal / Successful Execution");
        System.out.print("Select an option (1-5): ");

        try {
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    System.out.println("\n[Running Test 1: ArithmeticException]");
                    System.out.print("Enter numerator: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter denominator: ");
                    int den = Integer.parseInt(scanner.nextLine());
                    int result = num / den;
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    System.out.println("\n[Running Test 2: ArrayIndexOutOfBoundsException]");
                    int[] numbers = { 10, 20, 30, 40, 50 };
                    System.out.print("Enter index to access (0-4): ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Value at index " + idx + ": " + numbers[idx]);
                    break;

                case 3:
                    System.out.println("\n[Running Test 3: NullPointerException]");
                    String str = null;
                    System.out.println("Attempting to access str.length() where str = null...");
                    System.out.println("Length: " + str.length());
                    break;

                case 4:
                    System.out.println("\n[Running Test 4: NumberFormatException]");
                    System.out.print("Enter an integer value: ");
                    String text = scanner.nextLine();
                    int parsedVal = Integer.parseInt(text);
                    System.out.println("Successfully parsed integer: " + parsedVal);
                    break;

                case 5:
                    System.out.println("\n[Running Test 5: Successful Execution]");
                    System.out.println("All operations completed smoothly without exceptions.");
                    break;

                default:
                    System.out.println("\nInvalid choice selected.");
                    break;
            }

        } catch (ArithmeticException e) {
            System.out.println("\n[Handled ArithmeticException]: Cannot divide by zero -> " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n[Handled ArrayIndexOutOfBoundsException]: Array index is out of bounds -> " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("\n[Handled NullPointerException]: Object reference is null -> " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\n[Handled NumberFormatException]: Invalid number format -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[Handled General Exception]: " + e.getMessage());
        } finally {
            System.out.println("\n[Finally Block]: Resource cleanup & closing scanner (Always executed).");
            scanner.close();
        }

        System.out.println("=================================================");
        System.out.println("Program execution finished cleanly.");
        System.out.println("=================================================");
    }
}

package Day_23;

import java.util.Scanner;

// Q4: Handle NumberFormatException using try-catch-finally
public class practical_244 {

    // Method to convert string to integer
    public static int parseAge(String input) {
        return Integer.parseInt(input.trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 4. String Parsing (NumberFormatException Demo) ===");

        try {
            System.out.print("Enter your age (integer only): ");
            String inputStr = scanner.nextLine();

            int age = parseAge(inputStr);
            System.out.println("Valid integer input received! Age: " + age);

            if (age >= 18) {
                System.out.println("Eligible for voting.");
            } else {
                System.out.println("Not eligible for voting.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input cannot be formatted into an integer!");
            System.out.println("Details: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Resource closed.");
            scanner.close();
        }

        System.out.println("Program resumed normal execution.");
    }
}

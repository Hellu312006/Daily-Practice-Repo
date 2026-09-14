package Day_25;

import java.util.Scanner;

// Practical 267: Handle NumberFormatException
public class practical_267 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 267: Handle NumberFormatException ===");

        try {
            System.out.print("Enter a number (string format to convert): ");
            String input = scanner.nextLine();

            // Attempting to parse the string into an integer
            int number = Integer.parseInt(input);
            System.out.println("Successfully parsed integer: " + number);
            System.out.println("Square of the number: " + (number * number));

        } catch (NumberFormatException e) {
            System.out.println("\n[Error: NumberFormatException Caught]");
            System.out.println("Invalid numeric input! Could not parse into an integer.");
            System.out.println("Message: " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed: Resource cleanup.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}

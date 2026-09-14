package Day_25;

import java.util.Scanner;

// Practical 270: Create a method using throws keyword
public class practical_270 {

    // Method that uses 'throws' keyword to declare an exception
    public static double calculatePercentage(int obtainedMarks, int totalMarks) throws IllegalArgumentException, ArithmeticException {
        if (totalMarks == 0) {
            throw new ArithmeticException("Total marks cannot be zero.");
        }
        if (obtainedMarks < 0 || totalMarks < 0) {
            throw new IllegalArgumentException("Marks cannot be negative.");
        }
        if (obtainedMarks > totalMarks) {
            throw new IllegalArgumentException("Obtained marks cannot exceed total marks.");
        }

        return ((double) obtainedMarks / totalMarks) * 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 270: Method using 'throws' Keyword ===");

        try {
            System.out.print("Enter obtained marks: ");
            int obtained = scanner.nextInt();

            System.out.print("Enter total marks: ");
            int total = scanner.nextInt();

            // Calling method that declares exceptions with throws
            double percentage = calculatePercentage(obtained, total);
            System.out.printf("Calculated Percentage: %.2f%%\n", percentage);

        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("\n[Exception Caught in main()]: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[Unexpected Error]: " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed: Resources released.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}

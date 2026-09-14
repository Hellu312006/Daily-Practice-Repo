package Day_25;

import java.util.Scanner;

// Practical 269: Print exception message using getMessage()
public class practical_269 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Practical 269: Print Exception Message using getMessage() ===");

        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            System.out.print("Enter character index to access (0 to " + (text.length() - 1) + "): ");
            int index = scanner.nextInt();

            char ch = text.charAt(index);
            System.out.println("Character at index " + index + " is: '" + ch + "'");

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\n[Exception Caught]");
            System.out.println("Exception Class : " + e.getClass().getName());
            System.out.println("getMessage()    : " + e.getMessage());
            System.out.println("Explanation     : Cannot access specified index -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[General Exception Caught]");
            System.out.println("getMessage(): " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed: Scanner closed.");
            scanner.close();
        }

        System.out.println("Program completed successfully.");
    }
}

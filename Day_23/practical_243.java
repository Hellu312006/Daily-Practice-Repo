package Day_23;

// Q3: Handle NullPointerException using try-catch-finally
public class practical_243 {

    static void checkStringLength(String str) {
        System.out.println("String content: " + str);
        System.out.println("String length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
    }

    public static void main(String[] args) {
        System.out.println("=== 3. Null Reference Handling (NullPointerException Demo) ===");

        String validText = "Java Programming";
        String nullText = null;

        // Test 1: Valid object reference
        try {
            System.out.println("\n--- Testing with valid string ---");
            checkStringLength(validText);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("Finally block 1: Cleanup completed for Test 1.");
        }

        // Test 2: Null object reference
        try {
            System.out.println("\n--- Testing with null string ---");
            checkStringLength(nullText);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Attempted to invoke method on a null reference!");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            System.out.println("Finally block 2: Cleanup completed for Test 2 (Always executes!).");
        }

        System.out.println("\nProgram execution completed safely.");
    }
}

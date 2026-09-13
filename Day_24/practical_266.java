package Day_24;

import java.util.Scanner;

// 1. Custom Exception Class
class StudentEligibilityException extends Exception {
    public StudentEligibilityException(String message) {
        super(message);
    }
}

// Practical 266: Student Eligibility Program using try-catch, throw, throws, and custom exception
public class practical_266 {

    // 2. Method using 'throws' keyword to declare that it can throw the custom exception
    public static void checkEligibility(String name, int age, double percentage, double attendance) 
            throws StudentEligibilityException {
        
        System.out.println("\n--- Verifying Eligibility for: " + name + " ---");

        // 3. Using 'throw' keyword to raise custom exception on rule violations
        if (age < 17 || age > 30) {
            throw new StudentEligibilityException("Age Ineligible: Age (" + age + ") must be between 17 and 30 years.");
        }

        if (percentage < 60.0) {
            throw new StudentEligibilityException("Academic Ineligible: Percentage (" + percentage + "%) is below required 60.0%.");
        }

        if (attendance < 75.0) {
            throw new StudentEligibilityException("Attendance Ineligible: Attendance (" + attendance + "%) is below required 75.0%.");
        }

        // When all conditions are satisfied
        System.out.println("CONGRATULATIONS " + name + "! You are ELIGIBLE for admission and scholarship.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println(" Student Admission & Scholarship Eligibility System ");
        System.out.println("=========================================================");

        // 4. 'try-catch' block to handle exceptions gracefully
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            System.out.print("Enter 12th Board Percentage (%): ");
            double percentage = scanner.nextDouble();

            System.out.print("Enter Attendance Percentage (%): ");
            double attendance = scanner.nextDouble();

            // Calling method with throws declaration
            checkEligibility(name, age, percentage, attendance);

        } catch (StudentEligibilityException e) {
            System.out.println("\n [Eligibility Status: REJECTED]");
            System.out.println("Reason: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n [Input Error]: Invalid input format! (" + e.getMessage() + ")");
        } finally {
            // 5. 'finally' block for resource cleanup
            System.out.println("\n[System]: Verification process completed. Scanner closed.");
            scanner.close();
        }

        System.out.println("=========================================================");
    }
}

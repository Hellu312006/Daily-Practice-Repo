package Day_23;

import java.util.Scanner;

// Q15: Student Eligibility Program using try-catch, throw, throws, and custom exceptions
public class practical_255 {

    // Method using 'throws' and 'throw' to validate student admission/scholarship eligibility
    public static void verifyStudentEligibility(String studentName, int age, double marks)
            throws AgeException, MarksException {

        System.out.println("\n-------------------------------------------------");
        System.out.println("Processing Application for: " + studentName);
        System.out.println("Age: " + age + " | Marks: " + marks + "%");

        // 1. Age Validation
        if (age < 0) {
            throw new AgeException("Invalid Age: Age cannot be negative (" + age + ")");
        } else if (age < 17 || age > 25) {
            throw new AgeException("Age Ineligible: " + studentName + " (Age " + age + ") is outside eligible range (17-25 years)");
        }

        // 2. Marks Validation
        if (marks < 0 || marks > 100) {
            throw new MarksException("Invalid Marks: Marks must be between 0 and 100. Provided: " + marks);
        } else if (marks < 60.0) {
            throw new MarksException("Academic Ineligible: " + studentName + " scored " + marks + "%. Minimum 60% required!");
        }

        // 3. If all criteria pass
        System.out.println(">>> STATUS: CONGRATULATIONS! " + studentName + " is ELIGIBLE for College Admission & Scholarship! <<<");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("   STUDENT ELIGIBILITY VERIFICATION SYSTEM");
        System.out.println("   (Demonstrating try-catch-finally, throw, throws, Custom Exceptions)");
        System.out.println("=========================================================");

        // Test Case Array for automated batch processing demonstration
        String[] sampleNames = { "Aarav Sharma", "Neha Verma", "Kabir Singh", "Ananya Sen" };
        int[] sampleAges = { 19, 15, 22, 20 };
        double[] sampleMarks = { 85.5, 92.0, 48.0, 110.0 };

        System.out.println("\n=== Batch Test Verification ===");
        for (int i = 0; i < sampleNames.length; i++) {
            try {
                // Method call wrapped in try block
                verifyStudentEligibility(sampleNames[i], sampleAges[i], sampleMarks[i]);
            } catch (AgeException e) {
                System.out.println(">>> REJECTED [Age Criterion]: " + e.getMessage());
            } catch (MarksException e) {
                System.out.println(">>> REJECTED [Marks Criterion]: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(">>> REJECTED [General Error]: " + e.getMessage());
            } finally {
                System.out.println("[Log]: Completed audit record for " + sampleNames[i] + ".");
            }
        }

        // Interactive User Input Section
        System.out.println("\n=========================================================");
        System.out.println("=== Live Applicant Eligibility Check ===");
        System.out.println("=========================================================");

        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Student Marks (%): ");
            double marks = Double.parseDouble(scanner.nextLine());

            verifyStudentEligibility(name, age, marks);

        } catch (AgeException e) {
            System.out.println("\n[Admission Result]: FAILED -> " + e.getMessage());
        } catch (MarksException e) {
            System.out.println("\n[Admission Result]: FAILED -> " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\n[Input Error]: Please enter valid numerical values for age and marks.");
        } catch (Exception e) {
            System.out.println("\n[Unexpected Error]: " + e.getMessage());
        } finally {
            System.out.println("\n[System]: Application session closed. Resources released successfully.");
            scanner.close();
        }

        System.out.println("=========================================================");
        System.out.println("Eligibility verification process finished cleanly.");
        System.out.println("=========================================================");
    }
}

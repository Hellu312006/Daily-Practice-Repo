package Day_34;

import java.util.ArrayList;

// ============================================================================
// Practical 251 / Day 34: Student Marks ArrayList - Total & Average Calculation
// Tasks:
// - Create ArrayList to store student subject marks
// - Calculate Total Marks
// - Calculate Average / Percentage
// - Determine Grade based on Average
// ============================================================================

public class practical_251 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 251: Student Marks Total & Average ===");
        System.out.println("=============================================================\n");

        // 1. Store subject names and corresponding marks
        String[] subjects = { "Mathematics", "Physics", "Chemistry", "Computer Science", "English" };

        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(92); // Mathematics
        marks.add(85); // Physics
        marks.add(78); // Chemistry
        marks.add(96); // Computer Science
        marks.add(89); // English

        // 2. Display Subject-wise Marks
        System.out.println("--- Subject-wise Marks ---");
        for (int i = 0; i < marks.size(); i++) {
            System.out.printf("  %-18s : %3d / 100\n", subjects[i], marks.get(i));
        }

        // 3. Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // 4. Calculate Average Percentage
        int maxPossibleMarks = marks.size() * 100;
        double average = (double) totalMarks / marks.size();

        // 5. Determine Grade
        String grade;
        if (average >= 90) {
            grade = "A+ (Outstanding)";
        } else if (average >= 80) {
            grade = "A (Excellent)";
        } else if (average >= 70) {
            grade = "B (Good)";
        } else if (average >= 60) {
            grade = "C (Satisfactory)";
        } else if (average >= 50) {
            grade = "D (Pass)";
        } else {
            grade = "F (Fail)";
        }

        // 6. Print Summary Report
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("--- Performance Report Summary ---");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Subjects  : " + marks.size());
        System.out.println("Total Marks     : " + totalMarks + " / " + maxPossibleMarks);
        System.out.printf("Average Marks   : %.2f%%\n", average);
        System.out.println("Assigned Grade  : " + grade);

        System.out.println("\n=============================================================");
        System.out.println("Practical 251 executed successfully!");
        System.out.println("=============================================================");
    }
}

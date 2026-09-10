package Day_21;

import java.util.ArrayList;
import java.util.Scanner;

// Q14: Dynamic user input processing, statistical calculation, and filtering
public class practical_234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbersList = new ArrayList<>();

        System.out.println("=== Enter 6 Integers ===");
        for (int i = 1; i <= 6; i++) {
            System.out.print("Enter number " + i + ": ");
            numbersList.add(scanner.nextInt());
        }

        System.out.println("\nAll Numbers: " + numbersList);

        // 1. Calculate Sum & Average
        int sum = 0;
        for (int num : numbersList) {
            sum += num;
        }
        double average = (double) sum / numbersList.size();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));

        // 2. Separate Even and Odd Numbers
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int num : numbersList) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        System.out.println("\nEven Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);

        scanner.close();
    }
}

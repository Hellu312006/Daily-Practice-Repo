package Day_20;

import java.util.ArrayList;
import java.util.Scanner;

// Q14: Take 5 numbers from user and store them in ArrayList
public class practical_219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> userNumbers = new ArrayList<>();

        System.out.println("Enter 5 numbers:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = sc.nextInt();
            userNumbers.add(num);
        }

        System.out.println("\n=== Numbers Stored in ArrayList ===");
        System.out.println("ArrayList: " + userNumbers);

        System.out.println("\nDisplaying elements with indices:");
        for (int i = 0; i < userNumbers.size(); i++) {
            System.out.println("Index " + i + " -> " + userNumbers.get(i));
        }

        sc.close();
    }
}

package Day_20;

import java.util.ArrayList;

// Q6: Check whether a number exists using contains()
public class practical_211 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(25);
        numbers.add(50);
        numbers.add(75);
        numbers.add(100);

        System.out.println("Numbers List: " + numbers);

        int searchNum1 = 50;
        int searchNum2 = 90;

        // Checking existence using contains()
        if (numbers.contains(searchNum1)) {
            System.out.println(searchNum1 + " is present in the ArrayList.");
        } else {
            System.out.println(searchNum1 + " is NOT present in the ArrayList.");
        }

        if (numbers.contains(searchNum2)) {
            System.out.println(searchNum2 + " is present in the ArrayList.");
        } else {
            System.out.println(searchNum2 + " is NOT present in the ArrayList.");
        }
    }
}

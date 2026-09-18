package Day_29;

public class practical_289 {
    public static void main(String[] args) {
        // Array of numbers
        int[] marks = {85, 92, 78, 64, 99, 73};

        // 1. Calculate Sum and Average
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        double average = (double) sum / marks.length;

        // 2. Find Maximum and Minimum element
        int max = marks[0];
        int min = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
            if (marks[i] < min) {
                min = marks[i];
            }
        }

        // 3. Display Results
        System.out.println("Array Elements: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n---------------------------");
        System.out.println("Sum of elements: " + sum);
        System.out.printf("Average of elements: %.2f\n", average);
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }
}

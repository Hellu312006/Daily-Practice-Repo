package Day_29;

public class practical_288 {
    public static void main(String[] args) {
        // 1. Declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // 2. Access elements by index (starts at 0)
        System.out.println("First element: " + numbers[0]);
        System.out.println("Second element: " + numbers[1]);

        // 3. Modify an element
        numbers[2] = 99; // Changes 30 to 99
        System.out.println("Updated third element: " + numbers[2]);

        // 4. Get the length of the array
        System.out.println("Array length: " + numbers.length);

        // 5. Print all elements using a loop
        System.out.print("All elements: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}

package Day_31;

public class practical_299 {
    public static void main(String[] args) {
        // 1. Merging Two Arrays into a Third Array
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] merged = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            merged[arr1.length + i] = arr2[i];
        }

        System.out.print("Merged Array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println("\n-------------------------------------------");

        // 2. Finding Duplicate Elements in an Array
        int[] numbers = {10, 20, 30, 20, 40, 50, 30, 60, 10};

        System.out.print("Duplicate Elements: ");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.print(numbers[i] + " ");
                    break;
                }
            }
        }
        System.out.println("\n-------------------------------------------");

        // 3. Finding Common Elements Between Two Arrays (Intersection)
        int[] setA = {10, 20, 30, 40, 50};
        int[] setB = {30, 40, 50, 60, 70};

        System.out.print("Common Elements (Intersection): ");
        for (int i = 0; i < setA.length; i++) {
            for (int j = 0; j < setB.length; j++) {
                if (setA[i] == setB[j]) {
                    System.out.print(setA[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}

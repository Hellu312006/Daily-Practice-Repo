package Day_2;

public class practical_205 {
    public static void main(String[] args) {
        int[] arr = { 12, 45, 78, 34, 56, 90 };
        int target = 78;

        int index = linearSearch(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

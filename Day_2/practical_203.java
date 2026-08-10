package Day_2;

public class practical_203 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 78, 34, 56, 90};
        int target = 34; 
        boolean found = false;

        for (int num : arr) {
            if (num == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(target + " exists in the array.");
        } else {
            System.out.println(target + " does not exist in the array.");
        }
    }
}

package Day_2;

public class practical_207 { 
    public static void main(String[] args) {
        
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int target = 50;
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
    
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        
        return -1; 
    }
}

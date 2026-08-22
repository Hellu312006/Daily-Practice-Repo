package Day_02;

public class practical_202 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int sum = 0;
        for(int i=0;i<arr.length;i++){
             sum += arr[i];
        }
        for(int num : arr) {
            System.out.println(num);
        }
        System.out.println("sum of numbers=" + sum);
    }
}

          
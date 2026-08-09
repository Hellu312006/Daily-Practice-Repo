package Day_1;

import java.util.Scanner;

public class practical_4 {
    public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
        System.out.println("enter number a");
        int a = sc.nextInt();
        System.out.println("enter number b");
        int b = sc.nextInt();
        System.out.println("sum =" + (a+b));
        System.out.println("diffrence =" + (a-b));
        System.out.println("product = " + (a*b));
        System.out.println("divison = " + (a/b));
        System.out.println("module =" +(a%b));
      }
    }     
}

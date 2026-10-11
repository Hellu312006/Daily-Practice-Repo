package Day_39;

import java.util.Scanner;

public class practical_314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);

        sc.close();
    }
}

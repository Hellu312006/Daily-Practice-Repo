package Day_20;

import java.util.ArrayList;

// Q7: Find total elements using size()
public class practical_212 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        System.out.println("Initial Size: " + students.size());

        students.add("Aarav");
        students.add("Diya");
        students.add("Ishaan");
        students.add("Ananya");

        System.out.println("Students List: " + students);
        System.out.println("Total elements in ArrayList (Size): " + students.size());

        // Adding more elements
        students.add("Kabir");
        System.out.println("Size after adding one more student: " + students.size());
    }
}

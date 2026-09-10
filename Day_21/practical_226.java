package Day_21;

import java.util.ArrayList;

// Q6: Complete ArrayList CRUD Operations & Remove by Index vs Object
public class practical_226 {
    public static void main(String[] args) {
        System.out.println("=== 1. ArrayList CRUD Operations Demo ===");

        // Create
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("C++");
        skills.add("JavaScript");
        System.out.println("Initial List: " + skills);

        // Read
        System.out.println("Skill at index 2: " + skills.get(2));

        // Update
        skills.set(1, "TypeScript"); // Replaces Python with TypeScript
        System.out.println("After Update (index 1 -> TypeScript): " + skills);

        // Delete (by Value and by Index)
        skills.remove("C++"); // Remove by object/value
        skills.remove(0); // Remove by index (removes "Java")
        System.out.println("After Removals: " + skills);

        // Search
        System.out.println("Does list contain 'TypeScript'? " + skills.contains("TypeScript"));
        System.out.println("Index of 'JavaScript': " + skills.indexOf("JavaScript"));

        System.out.println("\n=== 2. Interview Trap: Integer remove(int) vs remove(Object) ===");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        System.out.println("Numbers List: " + numbers);

        // numbers.remove(1) removes the element at INDEX 1 (200)
        numbers.remove(1);
        System.out.println("After remove(1) [Index 1 removed]: " + numbers);

        // To remove the value 300 (Object), we must pass Integer.valueOf(300)
        numbers.remove(Integer.valueOf(300));
        System.out.println("After remove(Integer.valueOf(300)) [Value removed]: " + numbers);
    }
}

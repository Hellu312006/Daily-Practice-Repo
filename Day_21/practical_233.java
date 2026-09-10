package Day_21;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

// Q13: Intersection, Union, and subList operations on ArrayLists
public class practical_233 {
    public static void main(String[] args) {
        ArrayList<String> frontendTech = new ArrayList<>();
        frontendTech.add("HTML");
        frontendTech.add("CSS");
        frontendTech.add("JavaScript");
        frontendTech.add("React");
        frontendTech.add("TypeScript");

        ArrayList<String> fullstackTech = new ArrayList<>();
        fullstackTech.add("JavaScript");
        fullstackTech.add("React");
        fullstackTech.add("Node.js");
        fullstackTech.add("Java");
        fullstackTech.add("SQL");

        System.out.println("Frontend Tech: " + frontendTech);
        System.out.println("Fullstack Tech: " + fullstackTech);

        // 1. Intersection (Common elements using retainAll)
        ArrayList<String> commonTech = new ArrayList<>(frontendTech);
        commonTech.retainAll(fullstackTech);
        System.out.println("\n1. Common Technologies (Intersection): " + commonTech);

        // 2. Union (Combining both lists without duplicates)
        LinkedHashSet<String> unionSet = new LinkedHashSet<>(frontendTech);
        unionSet.addAll(fullstackTech);
        ArrayList<String> allTech = new ArrayList<>(unionSet);
        System.out.println("2. All Combined Tech (Union): " + allTech);

        // 3. SubList extraction (from index 1 to 4)
        List<String> subTechnologies = frontendTech.subList(1, 4);
        System.out.println("3. SubList of Frontend Tech (Index 1 to 3): " + subTechnologies);
    }
}

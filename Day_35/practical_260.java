package Day_35;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// ============================================================================
// Practical 260 / Day 35: Print and Traverse HashMap using entrySet()
// Tasks:
// - Populate a HashMap with product inventory (Product Name -> Price)
// - Print entries using standard enhanced for-loop over entrySet()
// - Print entries using Iterator over entrySet()
// - Print formatted tabular report using entrySet()
// - Modify values in-place using entry.setValue()
// ============================================================================

public class practical_260 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 260: Traverse & Print using entrySet() ===");
        System.out.println("=============================================================\n");

        // 1. Populate HashMap
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("Laptop", 74999.00);
        productPrices.put("Wireless Mouse", 899.50);
        productPrices.put("Mechanical Keyboard", 3499.00);
        productPrices.put("HD Monitor", 14500.00);
        productPrices.put("USB-C Hub", 1999.00);

        // 2. Method 1: Enhanced For-Loop over entrySet()
        System.out.println("--- Method 1: Enhanced For-Loop over entrySet() ---");
        Set<Map.Entry<String, Double>> entrySet = productPrices.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            String product = entry.getKey();
            Double price = entry.getValue();
            System.out.println("  Product: " + product + " | Price: Rs. " + price);
        }

        // 3. Method 2: Iterator with entrySet()
        System.out.println("\n--- Method 2: Iterator with entrySet() ---");
        Iterator<Map.Entry<String, Double>> iterator = productPrices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            System.out.println("  [Key: " + entry.getKey() + "] => [Value: " + entry.getValue() + "]");
        }

        // 4. Method 3: In-place modification via entry.setValue() (Apply 10% Festive Discount)
        System.out.println("\n--- Method 3: In-Place Modification via entry.setValue() (10% Discount) ---");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            double discountedPrice = entry.getValue() * 0.90;
            entry.setValue(discountedPrice);
        }
        System.out.println("Discount applied to all products successfully!");

        // 5. Formatted Tabular Report
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-5s | %-25s | %-15s\n", "No.", "Product Name", "Discounted Price");
        System.out.println("-------------------------------------------------------------");
        int index = 1;
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.printf("%-5d | %-25s | Rs. %,10.2f\n", index++, entry.getKey(), entry.getValue());
        }
        System.out.println("-------------------------------------------------------------");

        System.out.println("\n=============================================================");
        System.out.println("Practical 260 executed successfully!");
        System.out.println("=============================================================");
    }
}

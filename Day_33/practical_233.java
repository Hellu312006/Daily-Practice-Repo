package Day_33;

// ============================================================================
// Practical 233 / Day 33: Program to Swap Two Numbers in Java
// Covers 5 different approaches:
// 1. Using a Temporary (Third) Variable
// 2. Using Arithmetic Operators (+ and -) [Without 3rd variable]
// 3. Using Bitwise XOR Operator (^) [Without 3rd variable, avoids overflow]
// 4. Using Arithmetic Operators (* and /) [Without 3rd variable, non-zero]
// 5. Using Single-Line Expression in Java
// ============================================================================

public class practical_233 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 233: Swapping Two Numbers in Java ===");
        System.out.println("=============================================================\n");

        int num1 = 25;
        int num2 = 75;

        // --------------------------------------------------------------------
        // Approach 1: Using a Temporary Variable (Most Common & Safe)
        // --------------------------------------------------------------------
        System.out.println("--- 1. Using a Temporary (Third) Variable ---");
        int a = num1, b = num2;
        System.out.println("Before Swap : a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After Swap  : a = " + a + ", b = " + b);

        // --------------------------------------------------------------------
        // Approach 2: Using Addition and Subtraction (No 3rd Variable)
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Using Addition & Subtraction (+ and -) ---");
        a = num1;
        b = num2;
        System.out.println("Before Swap : a = " + a + ", b = " + b);

        a = a + b; // a now holds the sum (25 + 75 = 100)
        b = a - b; // b becomes original a (100 - 75 = 25)
        a = a - b; // a becomes original b (100 - 25 = 75)

        System.out.println("After Swap  : a = " + a + ", b = " + b);

        // --------------------------------------------------------------------
        // Approach 3: Using Bitwise XOR Operator (Fastest & No Overflow)
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Using Bitwise XOR (^) Operator ---");
        a = num1;
        b = num2;
        System.out.println("Before Swap : a = " + a + ", b = " + b);

        a = a ^ b; // a XOR b
        b = a ^ b; // (a XOR b) XOR b = a (original a)
        a = a ^ b; // (a XOR b) XOR a = b (original b)

        System.out.println("After Swap  : a = " + a + ", b = " + b);

        // --------------------------------------------------------------------
        // Approach 4: Using Multiplication and Division (No 3rd Variable)
        // Note: Assumes neither number is zero to avoid ArithmeticException
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Using Multiplication & Division (* and /) ---");
        a = num1;
        b = num2;
        System.out.println("Before Swap : a = " + a + ", b = " + b);

        if (a != 0 && b != 0) {
            a = a * b; // a holds product
            b = a / b; // b becomes original a
            a = a / b; // a becomes original b
            System.out.println("After Swap  : a = " + a + ", b = " + b);
        } else {
            System.out.println("Cannot use * and / when one of the numbers is 0.");
        }

        // --------------------------------------------------------------------
        // Approach 5: Single-Line Swapping Expression in Java
        // --------------------------------------------------------------------
        System.out.println("\n--- 5. Using Single-Line Expression in Java ---");
        a = num1;
        b = num2;
        System.out.println("Before Swap : a = " + a + ", b = " + b);

        // Execution order: a is assigned to b, and b receives (old a + old b) - new a
        b = (a + b) - (a = b);

        System.out.println("After Swap  : a = " + a + ", b = " + b);

        System.out.println("\n=============================================================");
        System.out.println("Practical 233 executed successfully!");
        System.out.println("=============================================================");
    }
}

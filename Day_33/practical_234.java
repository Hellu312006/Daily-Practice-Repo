package Day_33;

// ============================================================================
// Practical 234 / Day 33: Conversion between Decimal (Integer) & Binary in Java
// Covers:
// 1. Decimal to Binary Conversion:
//    - Approach A: Custom Mathematical Method (Modulo & Division by 2)
//    - Approach B: Custom Bitwise Operator Method (Bit-shifting & Masking)
//    - Approach C: Built-in Method (Integer.toBinaryString)
// 2. Binary to Decimal Conversion:
//    - Approach A: Custom Mathematical Method (Positional Powers of 2)
//    - Approach B: Custom String Traversal Method (Horner's Rule)
//    - Approach C: Built-in Method (Integer.parseInt with Radix 2)
// ============================================================================

public class practical_234 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 234: Decimal <-> Binary Number Conversion ===");
        System.out.println("=============================================================\n");

        int[] sampleDecimals = { 0, 9, 23, 42, 156, 255 };
        String[] sampleBinaries = { "0", "1001", "10111", "101010", "10011100", "11111111" };

        // ====================================================================
        // SECTION 1: DECIMAL TO BINARY CONVERSIONS
        // ====================================================================
        System.out.println("-------------------------------------------------------------");
        System.out.println("PART 1: DECIMAL TO BINARY CONVERSION");
        System.out.println("-------------------------------------------------------------");

        for (int decimal : sampleDecimals) {
            String binaryCustomMath = decimalToBinaryMath(decimal);
            String binaryBitwise = decimalToBinaryBitwise(decimal);
            String binaryBuiltIn = Integer.toBinaryString(decimal);

            System.out.println("Decimal Number       : " + decimal);
            System.out.println("  1. Math (Modulo/Div): " + binaryCustomMath);
            System.out.println("  2. Bitwise Ops (&,>>): " + binaryBitwise);
            System.out.println("  3. Built-in (Java)  : " + binaryBuiltIn);
            System.out.println();
        }

        // ====================================================================
        // SECTION 2: BINARY TO DECIMAL CONVERSIONS
        // ====================================================================
        System.out.println("-------------------------------------------------------------");
        System.out.println("PART 2: BINARY TO DECIMAL CONVERSION");
        System.out.println("-------------------------------------------------------------");

        for (String binary : sampleBinaries) {
            int decimalMath = binaryToDecimalMath(Long.parseLong(binary));
            int decimalString = binaryToDecimalString(binary);
            int decimalBuiltIn = Integer.parseInt(binary, 2);

            System.out.println("Binary String        : " + binary);
            System.out.println("  1. Math (Powers of 2): " + decimalMath);
            System.out.println("  2. String Traversal : " + decimalString);
            System.out.println("  3. Built-in (Radix 2): " + decimalBuiltIn);
            System.out.println();
        }

        // ====================================================================
        // SECTION 3: STEP-BY-STEP TRACE DEMONSTRATION
        // ====================================================================
        System.out.println("-------------------------------------------------------------");
        System.out.println("PART 3: STEP-BY-STEP CONVERSION TRACE (For N = 45)");
        System.out.println("-------------------------------------------------------------");
        traceDecimalToBinary(45);
        System.out.println();
        traceBinaryToDecimal("101101");

        System.out.println("\n=============================================================");
        System.out.println("Practical 234 executed successfully!");
        System.out.println("=============================================================");
    }

    // ------------------------------------------------------------------------
    // Method 1A: Decimal to Binary using Modulo & Division
    // ------------------------------------------------------------------------
    public static String decimalToBinaryMath(int n) {
        if (n == 0) return "0";

        StringBuilder binary = new StringBuilder();
        int temp = n;
        while (temp > 0) {
            int remainder = temp % 2;
            binary.append(remainder);
            temp /= 2;
        }
        return binary.reverse().toString();
    }

    // ------------------------------------------------------------------------
    // Method 1B: Decimal to Binary using Bitwise Operators
    // ------------------------------------------------------------------------
    public static String decimalToBinaryBitwise(int n) {
        if (n == 0) return "0";

        StringBuilder binary = new StringBuilder();
        int temp = n;
        while (temp > 0) {
            int lastBit = temp & 1; // Extracts the least significant bit
            binary.append(lastBit);
            temp >>= 1;            // Right shift by 1 bit (equivalent to temp / 2)
        }
        return binary.reverse().toString();
    }

    // ------------------------------------------------------------------------
    // Method 2A: Binary to Decimal using Math (Positional Powers of 2)
    // ------------------------------------------------------------------------
    public static int binaryToDecimalMath(long binaryNum) {
        int decimal = 0;
        int power = 0;

        while (binaryNum > 0) {
            long lastDigit = binaryNum % 10;
            decimal += (int) (lastDigit * Math.pow(2, power));
            binaryNum /= 10;
            power++;
        }
        return decimal;
    }

    // ------------------------------------------------------------------------
    // Method 2B: Binary to Decimal using String Traversal (Horner's Rule)
    // ------------------------------------------------------------------------
    public static int binaryToDecimalString(String binaryStr) {
        int decimal = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            char bit = binaryStr.charAt(i);
            decimal = decimal * 2 + (bit - '0');
        }
        return decimal;
    }

    // ------------------------------------------------------------------------
    // Helper: Step-by-Step Trace for Decimal -> Binary
    // ------------------------------------------------------------------------
    public static void traceDecimalToBinary(int n) {
        System.out.println("Tracing Decimal To Binary for " + n + ":");
        int temp = n;
        StringBuilder result = new StringBuilder();
        int step = 1;

        while (temp > 0) {
            int rem = temp % 2;
            int next = temp / 2;
            System.out.printf("  Step %d: %d / 2 = %d, Remainder = %d\n", step++, temp, next, rem);
            result.append(rem);
            temp = next;
        }
        System.out.println("  Reversing remainders: " + result.reverse().toString());
    }

    // ------------------------------------------------------------------------
    // Helper: Step-by-Step Trace for Binary -> Decimal
    // ------------------------------------------------------------------------
    public static void traceBinaryToDecimal(String binary) {
        System.out.println("Tracing Binary To Decimal for \"" + binary + "\":");
        int total = 0;
        int len = binary.length();

        for (int i = 0; i < len; i++) {
            char bit = binary.charAt(i);
            int power = len - 1 - i;
            int value = (bit - '0') * (int) Math.pow(2, power);
            System.out.printf("  Bit '%c' at position 2^%d = %c * %d = %d\n", bit, power, bit, (int) Math.pow(2, power), value);
            total += value;
        }
        System.out.println("  Total Decimal Value = " + total);
    }
}

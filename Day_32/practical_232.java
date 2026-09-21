package Day_32;

import java.util.Arrays;

// ============================================================================
// Practical 232 / Day 32: 2D Arrays (Matrix Operations & Manipulations)
// Covers:
// 1. 2D Array (Matrix) Declaration, Initialization & Grid Display
// 2. Row-wise and Column-wise Sum Calculation
// 3. Principal and Secondary Diagonal Sums
// 4. Matrix Transpose (Converting Rows into Columns)
// 5. Matrix Addition (Adding two 3x3 Matrices)
// ============================================================================

public class practical_232 {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("=== Practical 232: 2D Arrays & Matrix Operations ===");
        System.out.println("=============================================================\n");

        // --------------------------------------------------------------------
        // 1. 2D Array Declaration and Grid Display
        // --------------------------------------------------------------------
        System.out.println("--- 1. Matrix A (3x3 Grid) ---");
        int[][] matrixA = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        printMatrix(matrixA);

        int rows = matrixA.length;
        int cols = matrixA[0].length;

        // --------------------------------------------------------------------
        // 2. Row-wise and Column-wise Sum
        // --------------------------------------------------------------------
        System.out.println("\n--- 2. Row & Column Sums ---");
        // Row Sums
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrixA[i][j];
            }
            System.out.println("Sum of Row " + (i + 1) + "    : " + rowSum);
        }

        // Column Sums
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrixA[i][j];
            }
            System.out.println("Sum of Column " + (j + 1) + " : " + colSum);
        }

        // --------------------------------------------------------------------
        // 3. Diagonal Sums (Principal & Secondary)
        // --------------------------------------------------------------------
        System.out.println("\n--- 3. Diagonal Sums ---");
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < rows; i++) {
            mainDiagonalSum += matrixA[i][i];                  // Principal diagonal (1 + 5 + 9)
            antiDiagonalSum += matrixA[i][cols - 1 - i];       // Secondary diagonal (3 + 5 + 7)
        }
        System.out.println("Main Diagonal Sum (1 + 5 + 9): " + mainDiagonalSum);
        System.out.println("Anti Diagonal Sum (3 + 5 + 7): " + antiDiagonalSum);

        // --------------------------------------------------------------------
        // 4. Transpose of Matrix (Rows become Columns)
        // --------------------------------------------------------------------
        System.out.println("\n--- 4. Transpose of Matrix A ---");
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrixA[i][j];
            }
        }
        printMatrix(transpose);

        // --------------------------------------------------------------------
        // 5. Matrix Addition (Matrix A + Matrix B)
        // --------------------------------------------------------------------
        System.out.println("\n--- 5. Matrix Addition (A + B) ---");
        int[][] matrixB = {
            { 9, 8, 7 },
            { 6, 5, 4 },
            { 3, 2, 1 }
        };

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Resultant Matrix (A + B):");
        printMatrix(sumMatrix);

        System.out.println("\n=============================================================");
        System.out.println("Practical 232 executed successfully!");
        System.out.println("=============================================================");
    }

    // Helper method to neatly print a 2D Matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}

package Day_30;

public class practical_294 {
    public static void main(String[] args) {
        // ==========================================
        // 1. Declaration & Initialization of 2D Array (Matrix)
        // ==========================================
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("=== 1. Original 2D Array (3x3 Matrix) ===");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // ==========================================
        // 2. Row-wise and Column-wise Sum
        // ==========================================
        System.out.println("\n=== 2. Row and Column Sums ===");
        // Row sums
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Sum of Row " + (i + 1) + ": " + rowSum);
        }

        // Column sums
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Sum of Column " + (j + 1) + ": " + colSum);
        }

        // ==========================================
        // 3. Diagonal Sums (Principal & Secondary)
        // ==========================================
        System.out.println("\n=== 3. Diagonal Sums ===");
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        for (int i = 0; i < rows; i++) {
            mainDiagonalSum += matrix[i][i];
            antiDiagonalSum += matrix[i][cols - 1 - i];
        }
        System.out.println("Main Diagonal Sum (1 + 5 + 9): " + mainDiagonalSum);
        System.out.println("Anti Diagonal Sum (3 + 5 + 7): " + antiDiagonalSum);

        // ==========================================
        // 4. Transpose of Matrix (Rows become Columns)
        // ==========================================
        System.out.println("\n=== 4. Transpose of Matrix ===");
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

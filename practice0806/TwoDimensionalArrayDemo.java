public class TwoDimensionalArrayDemo {
    public static void main(String[] args) {
        int[][] matrix1 = new int[3][4];

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7}
        };

        System.out.println("=== Matrix Info ===");
        System.out.printf("Rows in matrix2: %d\n", matrix2.length);
        System.out.printf("Columns in first row of matrix2: %d\n", matrix2[0].length);

        int value = 1;
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = value++;
            }
        }

        System.out.println("\n=== Matrix Content ===");
        System.out.println("matrix1:");
        printMatrix(matrix1);

        System.out.println("\nmatrix2:");
        printMatrix(matrix2);

        System.out.println("\nJagged array:");
        printJaggedArray(jaggedArray);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void printJaggedArray(int[][] jaggedArray) {
        for (int row = 0; row < jaggedArray.length; row++) {
            System.out.printf("Row %d: ", row);
            for (int col = 0; col < jaggedArray[row].length; col++) {
                System.out.printf("%d ", jaggedArray[row][col]);
            }
            System.out.printf("(Length: %d)\n", jaggedArray[row].length);
        }
    }
}

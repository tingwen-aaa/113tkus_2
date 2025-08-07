public class LinearSearchDemo {

    public static int linearSearch(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("Comparison %d: array[%d] = %d, target = %d\n", 
                              comparisons, i, array[i], target);

            if (array[i] == target) {
                System.out.printf("Target found! Total comparisons: %d\n", comparisons);
                return i;
            }
        }

        System.out.printf("Target not found. Total comparisons: %d\n", comparisons);
        return -1;
    }

    public static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }

        if (count == 0) {
            return new int[0];
        }

        int[] result = new int[count];
        int resultIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11, 90, 22, 15};
        int target = 22;

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Target: " + target);
        System.out.println();

        System.out.println("=== Basic Linear Search ===");
        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.printf("Target %d found at index %d\n", target, result);
        } else {
            System.out.printf("Target %d not found\n", target);
        }

        System.out.println("\n=== Search All Matching Indices ===");
        int[] allPositions = linearSearchAll(numbers, target);

        if (allPositions.length > 0) {
            System.out.printf("Target %d found at indices: ", target);
            for (int i = 0; i < allPositions.length; i++) {
                System.out.print(allPositions[i]);
                if (i < allPositions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("\nTotal occurrences: %d\n", allPositions.length);
        } else {
            System.out.printf("Target %d not found\n", target);
        }
    }
}

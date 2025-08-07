import java.util.Arrays;

public class BinarySearchDemo {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        System.out.println("Binary search process:");

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;

            System.out.printf("Comparison %d: Range [%d, %d], Mid index = %d, Mid value = %d, Target = %d\n",
                    comparisons, left, right, mid, array[mid], target);

            if (array[mid] == target) {
                System.out.printf("Target found! Total comparisons: %d\n", comparisons);
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
                System.out.println("Target is greater. Searching right half.");
            } else {
                right = mid - 1;
                System.out.println("Target is smaller. Searching left half.");
            }
        }

        System.out.printf("Target not found. Total comparisons: %d\n", comparisons);
        return -1;
    }

    public static void main(String[] args) {
        int[] unsortedNumbers = {64, 25, 12, 22, 11, 90, 88, 76, 50, 42};

        int[] sortedNumbers = unsortedNumbers.clone();
        Arrays.sort(sortedNumbers);

        int target = 50;

        System.out.println("Original array: " + Arrays.toString(unsortedNumbers));
        System.out.println("Sorted array: " + Arrays.toString(sortedNumbers));
        System.out.println("Target: " + target);
        System.out.println();

        System.out.println("=== Custom Binary Search ===");
        int result = binarySearch(sortedNumbers, target);

        if (result != -1) {
            System.out.printf("Target %d found at index %d\n", target, result);
        } else {
            System.out.printf("Target %d not found\n", target);
        }

        System.out.println("\n=== Java Built-in Binary Search ===");
        int builtInResult = Arrays.binarySearch(sortedNumbers, target);
        System.out.printf("Built-in method result: %d\n", builtInResult);
    }
}

import java.util.Arrays;

public class ArrayRecursionDemo {

    public static int arraySum(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        System.out.printf("arraySum(arr, %d) = %d + arraySum(arr, %d)\n",
                          index, arr[index], index + 1);
        return arr[index] + arraySum(arr, index + 1);
    }

    public static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        int maxOfRest = findMax(arr, index + 1);
        int currentMax = Math.max(arr[index], maxOfRest);
        System.out.printf("Compare arr[%d]=%d with max of rest %d → %d\n",
                          index, arr[index], maxOfRest, currentMax);
        return currentMax;
    }

    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }

    public static void printArray(int[] arr, int index) {
        if (index >= arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }

    public static void printArrayReverse(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        printArrayReverse(arr, index + 1);
        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 5};
        int[] sortedNumbers = {1, 3, 5, 7, 9};

        System.out.println("Test array: " + Arrays.toString(numbers));
        System.out.println();

        System.out.println("=== Array Sum ===");
        int sum = arraySum(numbers, 0);
        System.out.println("Sum: " + sum);

        System.out.println("\n=== Find Max ===");
        int max = findMax(numbers, 0);
        System.out.println("Max: " + max);

        System.out.println("\n=== Check Sorted ===");
        System.out.println("numbers is sorted: " + isSorted(numbers, 0));
        System.out.println("sortedNumbers is sorted: " + isSorted(sortedNumbers, 0));

        System.out.println("\n=== Print Array ===");
        System.out.print("Forward: ");
        printArray(numbers, 0);
        System.out.print("Reverse: ");
        printArrayReverse(numbers, 0);
        System.out.println();
    }
}

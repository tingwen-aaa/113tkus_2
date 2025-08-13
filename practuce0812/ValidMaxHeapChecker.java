import java.util.Arrays;

public class ValidMaxHeapChecker {

    public static boolean isValidMaxHeap(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Heap is empty -> true");
            return true;
        }

        int lastNonLeaf = (n - 2) / 2;
        for (int i = 0; i <= lastNonLeaf; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[i] < arr[left]) {
                System.out.println("Violation at index " + left + ": " + arr[left] +
                                   " > parent index " + i + ": " + arr[i]);
                return false;
            }
            if (right < n && arr[i] < arr[right]) {
                System.out.println("Violation at index " + right + ": " + arr[right] +
                                   " > parent index " + i + ": " + arr[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {100, 90, 80, 70, 60, 75, 65},
            {100, 90, 80, 95, 60, 75, 65},
            {50},
            {}
        };

        for (int[] arr : testCases) {
            System.out.println("Array: " + Arrays.toString(arr));
            boolean result = isValidMaxHeap(arr);
            System.out.println("Is valid Max Heap? " + result);
            System.out.println("=".repeat(40));
        }
    }
}

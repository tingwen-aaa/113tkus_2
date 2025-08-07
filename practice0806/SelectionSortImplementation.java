import java.util.Arrays;

public class SelectionSortImplementation {

    public static void selectionSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                totalComparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                totalSwaps++;
            }

            System.out.printf("After round %d: %s\n", i + 1, Arrays.toString(array));
        }

        System.out.printf("Total comparisons: %d\n", totalComparisons);
        System.out.printf("Total swaps: %d\n", totalSwaps);
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original array: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("Sorted array:   " + Arrays.toString(array));
    }
}

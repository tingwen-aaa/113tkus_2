import java.util.Arrays;

public class BubbleSortDemo {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalSwaps = 0;

        System.out.println("Bubble sort process:");

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int roundComparisons = 0;
            int roundSwaps = 0;

            System.out.printf("\nRound %d:\n", i + 1);

            for (int j = 0; j < n - i - 1; j++) {
                roundComparisons++;
                totalComparisons++;

                System.out.printf("Compare array[%d]=%d and array[%d]=%d ", 
                                j, array[j], j + 1, array[j + 1]);

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                    roundSwaps++;
                    totalSwaps++;
                    System.out.println("→ swapped");
                } else {
                    System.out.println("→ not swapped");
                }
            }

            System.out.printf("End of round %d: %d comparisons, %d swaps\n", 
                            i + 1, roundComparisons, roundSwaps);
            System.out.println("Current array: " + Arrays.toString(array));

            if (!swapped) {
                System.out.println("Early stop: array is already sorted");
                break;
            }
        }

        System.out.printf("\nSorting completed! Total comparisons: %d, total swaps: %d\n", 
                        totalComparisons, totalSwaps);
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }
}

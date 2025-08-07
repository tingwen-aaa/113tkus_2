import java.util.Arrays;

public class InsertionSortDemo {

    public static void insertionSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalShifts = 0;

        System.out.println("Insertion sort process:");
        System.out.println("Sorted part | Unsorted part");
        System.out.println("------------|--------------");

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.printf("\nStep %d: Insert element %d\n", i, key);

            System.out.print("Before insertion: ");
            for (int k = 0; k < i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i; k < n; k++) {
                if (k == i) {
                    System.out.print("[" + array[k] + "] ");
                } else {
                    System.out.print(array[k] + " ");
                }
            }
            System.out.println();

            while (j >= 0 && array[j] > key) {
                totalComparisons++;
                System.out.printf("  Compare %d > %d, shift %d right\n", 
                                  array[j], key, array[j]);
                array[j + 1] = array[j];
                totalShifts++;
                j--;
            }

            if (j >= 0) {
                totalComparisons++;
            }

            array[j + 1] = key;
            System.out.printf("  Insert %d at position %d\n", key, j + 1);

            System.out.print("After insertion: ");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i + 1; k < n; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }

        System.out.printf("\nSorting complete! Total comparisons: %d, total shifts: %d\n", 
                          totalComparisons, totalShifts);
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("Sorted result: " + Arrays.toString(numbers));
    }
}

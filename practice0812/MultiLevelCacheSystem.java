import java.util.Arrays;

public class HeapConverter {
    public static void heapifyDownMax(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyDownMax(arr, n, largest);
        }
    }

    public static void heapifyDownMin(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyDownMin(arr, n, smallest);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyDownMax(arr, arr.length, i);
        }
    }

    public static void buildMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyDownMin(arr, arr.length, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 1, 4, 5};

        System.out.println("Original array: " + Arrays.toString(arr));

        int[] maxHeapArr = Arrays.copyOf(arr, arr.length);
        buildMaxHeap(maxHeapArr);
        System.out.println("Max Heap: " + Arrays.toString(maxHeapArr));

        int[] minHeapArr = Arrays.copyOf(arr, arr.length);
        buildMinHeap(minHeapArr);
        System.out.println("Min Heap: " + Arrays.toString(minHeapArr));
    }
}

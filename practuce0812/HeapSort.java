import java.util.*;

public class HeapSort {
    
    private static void heapifyDown(int[] arr, int i, int heapSize) {
        int maxIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < heapSize && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        
        if (right < heapSize && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        
        if (maxIdx != i) {
            swap(arr, i, maxIdx);
            heapifyDown(arr, maxIdx, heapSize);
        }
    }
    
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(arr, i, n);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        System.out.println("\n=== Phase 1: Build Max Heap ===");
        buildMaxHeap(arr);
        System.out.println("After building Max Heap: " + Arrays.toString(arr));
        
        System.out.println("\n=== Phase 2: Sorting process ===");
        int n = arr.length;
        
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            System.out.println("Moved max " + arr[i] + " to position " + i + ": " + Arrays.toString(arr));
            heapifyDown(arr, 0, i);
            System.out.println("After heapify: " + Arrays.toString(arr));
        }
    }
    
    public static void visualHeapSort(int[] arr) {
        System.out.println("=== Visual Heap Sort Process ===");
        System.out.println("Original: " + Arrays.toString(arr));
        
        buildMaxHeap(arr);
        System.out.println("Heap built: " + Arrays.toString(arr));
        
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int j = 0; j < i; j++) {
                sb.append(arr[j]);
                if (j < i - 1) sb.append(", ");
            }
            sb.append("] | [");
            for (int j = i; j < n; j++) {
                sb.append(arr[j]);
                if (j < n - 1) sb.append(", ");
            }
            sb.append("]");
            heapifyDown(arr, 0, i);
            System.out.println("Step " + (n - i) + ": " + sb.toString());
        }
    }
    
    public static void compareWithOtherSorts() {
        System.out.println("\n=== Sorting Algorithm Comparison ===");
        
        int[] testData = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Heap Sort:");
        int[] heapSortArr = testData.clone();
        long startTime = System.nanoTime();
        heapSort(heapSortArr);
        long heapSortTime = System.nanoTime() - startTime;
        System.out.println("Result: " + Arrays.toString(heapSortArr));
        
        System.out.println("\nArrays.sort():");
        int[] javaArr = testData.clone();
        startTime = System.nanoTime();
        Arrays.sort(javaArr);
        long javaSortTime = System.nanoTime() - startTime;
        System.out.println("Result: " + Arrays.toString(javaArr));
        
        System.out.println("\nTime Comparison (nanoseconds):");
        System.out.println("Heap Sort: " + heapSortTime);
        System.out.println("Arrays.sort(): " + javaSortTime);
        
        System.out.println("\nCharacteristics:");
        System.out.println("Heap Sort - Time complexity: O(n log n) (Best/Average/Worst same)");
        System.out.println("Heap Sort - Space complexity: O(1) In-place");
        System.out.println("Heap Sort - Stability: Unstable");
        System.out.println("Arrays.sort() - Optimized for various data types");
    }
    
    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        heapSort(arr1.clone());
        
        System.out.println("\n" + "=".repeat(50));
        
        int[] arr2 = {4, 10, 3, 5, 1};
        visualHeapSort(arr2.clone());
        
        compareWithOtherSorts();
    }
}

import java.util.Arrays;

public class AdvancedArrayRecursion {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static int[] mergeSortedArrays(int[] a, int[] b, int i, int j, int[] result, int k) {
        if (i == a.length && j == b.length) {
            return result;
        }

        if (i == a.length) {
            result[k] = b[j];
            return mergeSortedArrays(a, b, i, j + 1, result, k + 1);
        }

        if (j == b.length) {
            result[k] = a[i];
            return mergeSortedArrays(a, b, i + 1, j, result, k + 1);
        }

        if (a[i] <= b[j]) {
            result[k] = a[i];
            return mergeSortedArrays(a, b, i + 1, j, result, k + 1);
        } else {
            result[k] = b[j];
            return mergeSortedArrays(a, b, i, j + 1, result, k + 1);
        }
    }

    public static int kthSmallest(int[] arr, int k) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        quickSort(copy, 0, copy.length - 1);
        return copy[k - 1];
    }

    public static boolean subsetSum(int[] arr, int target, int index) {
        if (target == 0) return true;
        if (index >= arr.length) return false;

        if (arr[index] <= target) {
            if (subsetSum(arr, target - arr[index], index + 1)) return true;
        }

        return subsetSum(arr, target, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== QuickSort (Recursive) ===");
        int[] arr = {5, 2, 9, 1, 6, 3};
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After:  " + Arrays.toString(arr));

        System.out.println("\n=== Merge Two Sorted Arrays (Recursive) ===");
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int[] merged = new int[a.length + b.length];
        mergeSortedArrays(a, b, 0, 0, merged, 0);
        System.out.println("Merged: " + Arrays.toString(merged));

        System.out.println("\n=== K-th Smallest Element ===");
        int[] data = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Array: " + Arrays.toString(data));
        System.out.println(k + "-th smallest: " + kthSmallest(data, k));

        System.out.println("\n=== Subset Sum Exists ===");
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Exists: " + subsetSum(nums, target, 0));
    }
}

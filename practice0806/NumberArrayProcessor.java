import java.util.*;

public class NumberArrayProcessor {

    public static int[] removeDuplicates(int[] array) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }
        while (i < a.length) merged[k++] = a[i++];
        while (j < b.length) merged[k++] = b[j++];
        return merged;
    }

    public static int findMostFrequent(int[] array) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : array) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequent = array[0];
        for (int key : freq.keySet()) {
            if (freq.get(key) > maxCount) {
                maxCount = freq.get(key);
                mostFrequent = key;
            }
        }
        return mostFrequent;
    }

    public static int[][] splitArray(int[] array) {
        int mid = array.length / 2;
        int[] part1 = Arrays.copyOfRange(array, 0, mid);
        int[] part2 = Arrays.copyOfRange(array, mid, array.length);
        return new int[][]{part1, part2};
    }

    public static void printArray(String label, int[] array) {
        System.out.println(label + ": " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array1 = {5, 3, 8, 3, 9, 5, 1, 8, 2, 7};
        int[] sortedA = {1, 3, 5, 7};
        int[] sortedB = {2, 4, 6, 8};

        System.out.println("Original array:");
        printArray("array1", array1);

        System.out.println("\nAfter removing duplicates:");
        printArray("unique", removeDuplicates(array1));

        System.out.println("\nMerging two sorted arrays:");
        printArray("merged", mergeSortedArrays(sortedA, sortedB));

        System.out.println("\nMost frequent element:");
        System.out.println("Most frequent: " + findMostFrequent(array1));

        System.out.println("\nSplitting array1 into two parts:");
        int[][] split = splitArray(array1);
        printArray("Part 1", split[0]);
        printArray("Part 2", split[1]);
    }
}

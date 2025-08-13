import java.util.*;

public class KthLargest {
    
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        System.out.println("Processing:");
        for (int num : nums) {
            minHeap.offer(num);
            System.out.print("Add " + num + ": " + minHeap);
            if (minHeap.size() > k) {
                int removed = minHeap.poll();
                System.out.print(" -> Remove " + removed + ": " + minHeap);
            }
            System.out.println();
        }
        return minHeap.peek();
    }
    
    public static int findKthLargestByMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        System.out.println("Max Heap: " + maxHeap);
        for (int i = 0; i < k - 1; i++) {
            int removed = maxHeap.poll();
            System.out.println("Removed top " + (i + 1) + ": " + removed + 
                             ", Remaining: " + maxHeap);
        }
        return maxHeap.peek();
    }
    
    public static int findKthLargestByQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void testKthLargest(int[] nums, int k) {
        System.out.println("=== Find " + k + "-th Largest Element ===");
        System.out.println("Array: " + Arrays.toString(nums));
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("Expected: " + sorted[sorted.length - k]);
        
        System.out.println("\nMethod 1 - Min Heap:");
        int result1 = findKthLargest(nums.clone(), k);
        System.out.println("Result: " + result1);
        
        System.out.println("\nMethod 2 - Max Heap:");
        int result2 = findKthLargestByMaxHeap(nums.clone(), k);
        System.out.println("Result: " + result2);
        
        System.out.println("\nMethod 3 - Quick Select:");
        int result3 = findKthLargestByQuickSelect(nums.clone(), k);
        System.out.println("Result: " + result3);
        
        System.out.println("\nTime Complexity Comparison:");
        System.out.println("Min Heap: O(n log k), Space O(k)");
        System.out.println("Max Heap: O(n log n), Space O(n)");
        System.out.println("Quick Select: Avg O(n), Worst O(n^2), Space O(1)");
        System.out.println("=" + "=".repeat(40) + "\n");
    }
    
    public static void main(String[] args) {
        testKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        testKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        testKthLargest(new int[]{1}, 1);
    }
}

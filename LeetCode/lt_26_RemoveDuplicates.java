// LeetCode 26. Remove Duplicates from Sorted Array
public class lt_26_RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.print("Result 1: length=" + k1 + ", array=[");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]"); // length=2, array=[1,2]

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = removeDuplicates(nums2);
        System.out.print("Result 2: length=" + k2 + ", array=[");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]"); // length=5, array=[0,1,2,3,4]
    }
}

/*
解題思路（繁體中文）：
1. 使用快慢指針：
   - fast 遍歷陣列；
   - slow 指示下一個應存放不重複元素的位置。
2. 當 nums[fast] != nums[fast-1] 時，將 nums[fast] 放到 nums[slow]，並 slow++。
3. 最後返回 slow，即為去重後的長度。
4. 題目允許修改 nums 的前 k 個元素，後面元素不重要。
5. 時間複雜度 O(n)，空間複雜度 O(1)。
*/

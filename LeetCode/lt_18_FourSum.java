// LeetCode 18. 4Sum
import java.util.*;

public class lt_18_FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳過重複值
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 跳過重複值
                
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Result 1: " + fourSum(nums1, target1));
        // Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Result 2: " + fourSum(nums2, target2));
        // Output: [[2, 2, 2, 2]]
    }
}

/*
解題思路（繁體中文）：
1. 題目要求找出所有不重複的四元組，使它們的總和等於 target。
2. 先將陣列排序，方便後續用雙指針法處理。
3. 外層兩層迴圈固定前兩個數字 nums[i], nums[j]。
4. 內層使用雙指針 left, right 找剩下兩個數字：
   - 若總和 == target，加入結果並跳過重複值。
   - 若總和 < target，left++。
   - 若總和 > target，right--。
5. 為避免整數溢位，計算總和時轉型為 long。
6. 時間複雜度 O(n^3)，外層兩層迴圈 + 內層雙指針。
7. 空間複雜度 O(1)，僅使用額外變數。
*/

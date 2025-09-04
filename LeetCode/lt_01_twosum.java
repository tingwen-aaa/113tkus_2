package LeetCode；

import java.util.HashMap;

import java.util.Map;

// 題目：Two Sum
// 給定一個整數陣列 nums 和一個目標值 target，請回傳兩個索引，使得 nums[i] + nums[j] == target。

class lt_01_twosum {
    public int[] twoSum(int[] nums, int target) {
        // key: 數值；value: 該數值最後一次出現的索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            // 若先前看過 need，代表 (need, nums[i]) 組成答案
            if (map.containsKey(need)) {
                return new int[] { map.get(need), i };
            }
            // 尚未配對成功，記錄目前數值的位置
            map.put(nums[i], i);
        }

        // 題目保證一定有解，理論上不會到這行
        return new int[0];
    }
}

/*
解題邏輯與思路（Two Sum, O(n)）：
1) 目標：找兩個索引 i, j 使得 nums[i] + nums[j] = target，且不能用同一元素兩次。
2) 想法：一邊走訪陣列，一邊用 HashMap 記錄已看過的數值與其索引。
   - 對於當前 nums[i]，所需的另一半為 need = target - nums[i]。
   - 若 map 中已存在 need，表示先前的那個索引與 i 就是一組解。
   - 否則把 nums[i] 與索引 i 存進 map，供之後配對。
3) 正確性：因為每個元素被處理時，都會檢查之前是否已存在可配對的 need；
   一旦發現即回傳索引組，且題目保證唯一解，一定能在一次線性掃描內找到。
4) 時間複雜度：O(n)，每個元素最多被插入/查找一次（HashMap 平均 O(1)）。
5) 空間複雜度：O(n)，最壞情況需在 map 中暫存最多 n-1 個元素。
6) Follow-up：此解法即為小於 O(n^2) 的做法（O(n)），優於雙迴圈暴力法 O(n^2)。
*/
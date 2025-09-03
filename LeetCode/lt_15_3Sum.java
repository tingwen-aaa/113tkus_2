package LeetCode;

public class lt_15_3Sum {
    
}
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // 先將數組排序

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳過重複的元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳過重複的元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Example 1
        int[] nums1 = {-1,0,1,2,-1,-4};
        System.out.println("Example 1: " + solution.threeSum(nums1));  // Output: [[-1,-1,2],[-1,0,1]]

        // Example 2
        int[] nums2 = {0,1,1};
        System.out.println("Example 2: " + solution.threeSum(nums2));  // Output: []

        // Example 3
        int[] nums3 = {0,0,0};
        System.out.println("Example 3: " + solution.threeSum(nums3));  // Output: [[0,0,0]]
    }
}

/*
解題思路：
1. **排序數組**：首先對數組進行排序，這樣可以方便地使用雙指針方法來查找三元組。
2. **遍歷數組**：遍歷每個數字，並且固定一個數字。然後利用兩個指針（`left`和`right`）查找其他兩個數字，使它們的和為0。
3. **避免重複**：在遍歷過程中，跳過重複的數字，保證結果中沒有重複的三元組。
4. **雙指針查找**：對每一個固定的數字，設置`left`和`right`指針，計算它們的和與當前數字的和。如果和為0，則將該三元組加入結果中，並移動指針以跳過重複元素。
5. **時間與空間複雜度**：
   - **時間複雜度**：O(n^2)，其中n是數組的長度。排序的時間複雜度是O(n log n)，而雙指針的查找時間是O(n)。
   - **空間複雜度**：O(1)，我們使用的額外空間只有常數大小。
*/

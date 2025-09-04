package LeetCode;

public class lt_04_MedianofTwoSortedArrays {

}
class lt_04_MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 保證 nums1 是較短的陣列
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            // i太小，需要增大
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            // i太大，需要減小
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            }
            // 找到合適分割
            else {
                int maxLeft;
                // 處理邊界情況
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                
                // 總長度為奇數，直接回傳左邊最大值
                if ((m + n) % 2 == 1)
                    return maxLeft;
                
                int minRight;
                // 處理邊界情況
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);
                
                // 總長度為偶數，回傳左右最小/最大值的平均數
                return (maxLeft + minRight) / 2.0;
            }
        }
        // 理論上不會到這裡
        return 0.0;
    }
}
    /**
     * 解題思路：
     * 1. 題目要求時間複雜度為 O(log(m+n))，因此不能直接合併陣列，而要用二分查找。
     * 2. 假設 nums1 長度小於等於 nums2（這樣二分查找會更高效）。
     * 3. 使用二分查找在較短陣列 nums1 上尋找一個合適的分割點 i，同時 nums2 的分割點為 j = (m + n + 1) / 2 - i。
     * 4. 檢查分割點是否滿足條件：nums1[i-1] <= nums2[j] 且 nums2[j-1] <= nums1[i]。
     *    - 如果不滿足，就調整分割點繼續查找。
     * 5. 找到合適分割後，中位數可能是左邊最大值（總長度為奇數），或是左右兩邊最大/最小值的平均數（總長度為偶數）。
     * 6. 處理邊界情況：分割點在陣列開頭或結尾時，要注意越界判斷。
     */
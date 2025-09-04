package LeetCode;

public class lt_05_LongestPalindromicSubstring {

}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // 奇數長度回文
            int len2 = expandAroundCenter(s, i, i + 1);   // 偶數長度回文
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 更新目前找到的最長回文子串範圍
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // 擴展中心法，左右指針往外擴展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 回傳回文長度
        return right - left - 1;
    }

    /**
     * 解題思路：
     * 1. 本題需找最長的回文子串，可以使用「中心擴展法」。
     * 2. 回文子串的中心可以是一個字元（奇數長度）或兩個連續字元（偶數長度）。
     * 3. 以每個可能的中心為基點，向左右擴展，尋找最大回文長度。
     * 4. 記錄目前找到的最長回文子串的起始和結束位置，最後回傳對應的子串即可。
     * 5. 時間複雜度 O(n^2)，空間複雜度 O(1)，適合本題的輸入範圍。
     */
}
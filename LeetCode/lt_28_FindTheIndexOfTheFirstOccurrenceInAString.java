// LeetCode 28. Find the Index of the First Occurrence in a String
//
// Given two strings needle and haystack,
// return the index of the first occurrence of needle in haystack,
// or -1 if needle is not part of haystack.
// If needle is an empty string, return 0.
//
// 給定兩個字串 needle 和 haystack，
// 找出 needle 在 haystack 中第一次出現的索引位置。
// 如果 needle 不存在於 haystack 中，回傳 -1。
// 若 needle 是空字串，根據定義回傳 0。

public class lt_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Result 1: " + strStr(haystack1, needle1)); // 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Result 2: " + strStr(haystack2, needle2)); // -1

        String haystack3 = "mississippi";
        String needle3 = "issi";
        System.out.println("Result 3: " + strStr(haystack3, needle3)); // 1
    }
}

/*
解題思路（繁體中文）：
1. 題目要求找到 needle 在 haystack 中第一次出現的索引。
2. 使用暴力法：
   - 從 haystack 的每個可能起點 i 開始，取長度為 needle 的子字串進行比對。
   - 若相等則回傳 i。
3. 若遍歷結束未找到，回傳 -1。
4. 若 needle 是空字串，根據定義回傳 0。
5. 時間複雜度 O((n-m+1)*m)，空間複雜度 O(1)。
*/

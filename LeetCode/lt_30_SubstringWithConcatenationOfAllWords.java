// LeetCode 30. Substring with Concatenation of All Words
//
// You are given a string s and an array of strings words.
// All the strings in words are of the same length.
// A concatenated substring is a substring that contains all the strings
// in words exactly once and without any intervening characters.
// Return the starting indices of all the concatenated substrings in s.
//
// 給定字串 s 和字串陣列 words（words 中每個字串長度相同）。
// 找出 s 中所有起始索引，使得該子字串剛好由 words 中所有字串拼接而成（不重疊、順序不限）。
// 回傳所有符合條件的起始索引。

import java.util.*;

public class lt_30_SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String sub = s.substring(j, j + wordLen);

                if (wordCount.containsKey(sub)) {
                    window.put(sub, window.getOrDefault(sub, 0) + 1);
                    count++;

                    while (window.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == words.length) {
                        res.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println("Result 1: " + findSubstring(s1, words1)); // [0, 9]

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println("Result 2: " + findSubstring(s2, words2)); // []

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println("Result 3: " + findSubstring(s3, words3)); // [6, 9, 12]
    }
}

/*
解題思路（繁體中文）：
1. 每個 word 長度相同，總長度 totalLen = wordLen * words.length。
2. 用 HashMap 紀錄 words 中的字詞及出現次數。
3. 對於 wordLen 個不同的起始點，利用滑動視窗檢查：
   - 當子字串在 wordCount 中，更新 window 計數；
   - 若某字超過需求，移動左指標縮小視窗；
   - 若 window 中字數 == words.length，加入答案。
   - 遇到無效字，清空 window 重新開始。
4. 時間複雜度 O(n * wordLen)，空間複雜度 O(words.length)。
*/

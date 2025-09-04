public class  lt_03_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // 用 HashSet 來存放窗口中的字符，確保不重複
        Set<Character> charSet = new HashSet<>();
        int left = 0; // 窗口的左邊界
        int maxLength = 0; // 最長長度

        // 右指針向右遍歷字串
        for (int right = 0; right < s.length(); right++) {
            // 如果有重複，移動左指針並移除字符直到沒有重複
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // 把目前字符加入集合
            charSet.add(s.charAt(right));
            // 更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
    /**
     * 解題思路：
     * 使用「滑動窗口」搭配 HashSet 來維護目前的子字串。
     * 
     * 1. 用兩個指針 left、right 定義一個窗口。
     * 2. right 每次向右移動一格，將新字符加入 HashSet。
     * 3. 如果加入的字符已經在 HashSet（代表重複），則需要把 left 向右移動並移除 HashSet 中的字符，直到沒有重複為止。
     * 4. 每次窗口擴展時，計算並更新最長長度。
     * 5. 整個過程只需遍歷一次字串，因此時間複雜度為 O(n)。
     */
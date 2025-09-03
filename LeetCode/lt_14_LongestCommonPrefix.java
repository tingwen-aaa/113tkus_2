package LeetCode;

public class lt_14_LongestCommonPrefix {
    
}
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 如果數組為空，返回空字符串
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 假設最長公共前綴是數組中的第一個字符串
        String prefix = strs[0];

        // 遍歷剩下的每個字符串
        for (int i = 1; i < strs.length; i++) {
            // 比較當前的字符串和公共前綴，更新公共前綴
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        // Example 1
        String[] strs1 = {"flower","flow","flight"};
        System.out.println("Example 1: " + solution.longestCommonPrefix(strs1));  // Output: "fl"

        // Example 2
        String[] strs2 = {"dog","racecar","car"};
        System.out.println("Example 2: " + solution.longestCommonPrefix(strs2));  // Output: ""
    }
}

/*
解題思路：
1. **處理邊界情況**：首先檢查輸入的數組是否為空，如果是則返回空字符串。
2. **假設公共前綴**：假設數組中的第一個字符串是公共前綴，然後從第二個字符串開始與這個前綴進行比較。
3. **更新公共前綴**：如果當前字符串不包含目前的公共前綴，則將公共前綴的長度縮短，直到找到匹配的前綴。如果前綴為空，則返回空字符串。
4. **時間與空間複雜度**：
   - **時間複雜度**：O(S)，其中S是所有字符串中字符數的總和。我們每次遍歷比較前綴，最壞情況下需要檢查每個字符。
   - **空間複雜度**：O(1)，我們只使用了常數空間來存儲公共前綴。
*/

package LeetCode;

public class lt_10_RegularExpressionMatching {
    
}
class lt_10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // 使用動態規劃（DP）來解決此問題
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;  // 空字符串和空模式匹配

        // 初始化第一行，處理p為空或p中的' * '匹配空字符串的情況
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];  // '*'表示可以匹配零個前一個字符
            }
        }

        // 填充dp表格，dp[i][j]表示s[0...i-1]是否能匹配p[0...j-1]
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];  // 字符相同或'.'匹配任何字符
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]  // '*'表示前一個字符出現零次
                        || (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')
                        && dp[i - 1][j];  // '*'表示前一個字符至少出現一次
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("Example 1: " + solution.isMatch(s1, p1));  // Output: false

        // Example 2
        String s2 = "aa";
        String p2 = "a*";
        System.out.println("Example 2: " + solution.isMatch(s2, p2));  // Output: true

        // Example 3
        String s3 = "ab";
        String p3 = ".*";
        System.out.println("Example 3: " + solution.isMatch(s3, p3));  // Output: true
    }
}

/*
解題思路：
1. 使用動態規劃（DP）來解決正則表達式匹配問題，構建一個dp表格，其中`dp[i][j]`表示s[0...i-1]是否能匹配p[0...j-1]。
2. **初始化dp表格**：
   - `dp[0][0] = true`：空字符串和空模式是匹配的。
   - 當p中包含`'*'`時，可以處理空字符串的情況，這意味著`'*'`可以匹配零次的前一個字符，更新`dp[0][j]`。
3. **填充dp表格**：
   - 如果當前字符相同，或者p中的字符是`'.'`，則`dp[i][j]`繼承自`dp[i-1][j-1]`，因為可以匹配當前字符。
   - 如果p中的字符是`'*'`，則有兩種情況：
     - `'*'`匹配零次前一個字符，則`dp[i][j]`繼承自`dp[i][j-2]`。
     - `'*'`匹配至少一次前一個字符，則`dp[i][j]`繼承自`dp[i-1][j]`，且需要檢查前一個字符是否匹配。
4. **時間複雜度**：O(m * n)，其中m是s的長度，n是p的長度。需要填充dp表格，並且每個元素的計算時間是常數。
5. **空間複雜度**：O(m * n)，因為需要一個大小為`(m+1) * (n+1)`的dp表格來存儲匹配結果。
*/

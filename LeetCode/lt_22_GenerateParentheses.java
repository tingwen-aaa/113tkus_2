// LeetCode 22. Generate Parentheses
import java.util.*;

public class lt_22_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder path, int open, int close, int n) {
        if (path.length() == n * 2) {
            ans.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            backtrack(ans, path, open + 1, close, n);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            backtrack(ans, path, open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Result 1: " + generateParenthesis(n1));
        // 可能輸出（順序無關）：["((()))","(()())","(())()","()(())","()()()"]

        int n2 = 1;
        System.out.println("Result 2: " + generateParenthesis(n2));
        // ["()"]
    }
}

/*
解題思路（繁體中文）：
1. 使用回溯法生成所有長度為 2n 的有效括號字串。
2. 兩個計數器：
   - open：已加入的左括號數，最多 n；
   - close：已加入的右括號數，必須保持 close < open 才能加入右括號。
3. 遞迴步驟：
   - 先嘗試放 '('（若 open < n）；
   - 再嘗試放 ')'（若 close < open）。
   - 當 path 長度達 2n 時，加入答案。
4. 時間複雜度約為第 n 個卡特蘭數（生成樹大小），空間複雜度 O(n)。
*/

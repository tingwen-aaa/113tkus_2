// LeetCode 20. Valid Parentheses
import java.util.*;

public class lt_20_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println("Result 1: " + isValid(s1)); // true

        String s2 = "()[]{}";
        System.out.println("Result 2: " + isValid(s2)); // true

        String s3 = "(]";
        System.out.println("Result 3: " + isValid(s3)); // false

        String s4 = "([)]";
        System.out.println("Result 4: " + isValid(s4)); // false

        String s5 = "{[]}";
        System.out.println("Result 5: " + isValid(s5)); // true
    }
}

/*
解題思路（繁體中文）：
1. 使用堆疊 (Stack) 來處理括號匹配問題。
2. 遍歷字串：
   - 如果遇到左括號 '('、'{'、'['，就把對應的右括號 push 進堆疊。
   - 如果遇到右括號，則檢查堆疊是否為空，或堆疊頂端是否為相同括號：
     - 若不符合，回傳 false。
     - 若符合，彈出堆疊頂端。
3. 遍歷結束後，若堆疊為空，代表括號完全匹配 → 回傳 true。
4. 時間複雜度 O(n)，其中 n 為字串長度。
5. 空間複雜度 O(n)，最壞情況下所有字元都壓入堆疊。
*/

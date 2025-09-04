package LeetCode;

public class lt_08_StringtoInteger {
    
}
class lt_08_StringtoInteger {
    public int myAtoi(String s) {
        // Step 1: Remove leading whitespaces
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check the sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert the number
        int result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow/underflow before updating result
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "42";
        System.out.println("Example 1: " + solution.myAtoi(s1));  // Output: 42

        // Example 2
        String s2 = " -042";
        System.out.println("Example 2: " + solution.myAtoi(s2));  // Output: -42

        // Example 3
        String s3 = "1337c0d3";
        System.out.println("Example 3: " + solution.myAtoi(s3));  // Output: 1337

        // Example 4
        String s4 = "0-1";
        System.out.println("Example 4: " + solution.myAtoi(s4));  // Output: 0

        // Example 5
        String s5 = "words and 987";
        System.out.println("Example 5: " + solution.myAtoi(s5));  // Output: 0
    }
}

/*
解題思路：
1. **去除前導空格**：首先我們要忽略所有的前導空格，這是atoi的第一步。
2. **判斷符號**：接著查看是否存在符號（`+` 或 `-`），如果有則記錄符號，並且移動指標。如果沒有符號，則默認為正數。
3. **處理數字轉換**：遍歷字符串中的每個字符，當字符是數字時，我們將其轉換為數字並拼接到結果中。每處理一個字符，指標向後移動。
4. **處理溢出情況**：在每次更新結果之前，我們需要檢查是否會超過32位有符號整數範圍。如果會，我們立即返回最大或最小的32位整數值。
5. **返回結果**：根據最初的符號來決定最終返回的結果是正數還是負數。

時間複雜度：
- O(n)，其中n是字符串的長度。我們只需遍歷一次字符串。

空間複雜度：
- O(1)，我們只使用了少量額外的空間來存儲變量。
*/

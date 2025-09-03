package LeetCode;

public class lt_09_PalindromeNumber {
    
}
class lt_09_PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Step 1: Negative numbers and multiples of 10 are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Step 2: Reverse half of the number
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;  // Append the last digit of x to reversed
            x /= 10;  // Remove the last digit from x
        }

        // Step 3: Compare the reversed half with the remaining half
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int x1 = 121;
        System.out.println("Example 1: " + solution.isPalindrome(x1));  // Output: true

        // Example 2
        int x2 = -121;
        System.out.println("Example 2: " + solution.isPalindrome(x2));  // Output: false

        // Example 3
        int x3 = 10;
        System.out.println("Example 3: " + solution.isPalindrome(x3));  // Output: false
    }
}

/*
解題思路：
1. **排除負數和10的倍數**：負數一定不是回文數，因為它們以負號開頭，而回文數必須是對稱的。另外，所有10的倍數（但不等於0）也不是回文數，因為它們的反轉會以0結尾。
2. **反轉數字的前半部分**：通過逐步提取x的最後一位數字並加到`reversed`中，反轉x的前半部分。當`x`的數字小於或等於反轉數字時停止。
3. **比較兩部分**：當`x`和反轉的數字相等時，或者反轉的數字去掉最後一位與`x`相等時（奇數長度回文的情況），則返回`true`，表示x是回文數。
4. **時間複雜度**：O(log(x))，因為我們每次操作都會將數字減小一位，直到反轉過來。
5. **空間複雜度**：O(1)，我們只使用了少量額外的空間來存儲反轉過來的數字。
*/

package LeetCode;

public class lt_07_ReverseInteger {
    
}
class lt_07_ReverseInteger {
    public int reverse(int x) {
        // 處理符號，先將負數轉換為正數來進行反轉
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        long reversed = 0;  // 使用long來防止溢出

        while (x != 0) {
            // 取出最後一位數字
            int digit = x % 10;
            // 將數字添加到反轉結果中
            reversed = reversed * 10 + digit;
            // 刪除最後一位數字
            x /= 10;
        }

        // 反轉後的數字超出32位整數範圍的情況
        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }

        // 返回反轉後的數字，並且加上符號
        return sign * (int) reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int x1 = 123;
        System.out.println("Example 1: " + solution.reverse(x1));  // Output: 321

        // Example 2
        int x2 = -123;
        System.out.println("Example 2: " + solution.reverse(x2));  // Output: -321

        // Example 3
        int x3 = 120;
        System.out.println("Example 3: " + solution.reverse(x3));  // Output: 21
    }
}

/*
解題思路：
1. 首先需要處理負數情況，將負數變成正數進行反轉，最後再將符號恢復。
2. 使用`long`型別來防止反轉過程中發生溢出，因為反轉後的數字可能會超過`Integer.MAX_VALUE`的範圍。
3. 將數字的每一位提取出來，並將其添加到反轉結果中。
4. 每次提取出一位數字後，將原數字除以10，繼續處理下一位。
5. 最後，檢查反轉後的數字是否超過了32位有符號整數的範圍。如果超過，返回0。
6. 時間複雜度是 O(log(x))，其中 x 是輸入數字的絕對值，因為每次除以10，直到 x 等於0為止。
7. 空間複雜度是 O(1)，使用了固定數量的額外空間。
*/

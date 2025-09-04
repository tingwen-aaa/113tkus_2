package LeetCode;

public class lt_06_ZigzagConversion {
    
}
class lt_06_ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;  // 如果numRows為1，直接返回原始字符串
        StringBuilder[] rows = new StringBuilder[numRows];  // 創建StringBuilder陣列，每個StringBuilder對應一行
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;  // 記錄當前處於哪一行
        boolean goingDown = false;  // 記錄是否需要向下移動
        for (char c : s.toCharArray()) {  // 遍歷字符串中的每個字符
            rows[currentRow].append(c);  // 將當前字符添加到對應的行
            // 如果到達頂部或底部行，則改變移動方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // 根據方向調整currentRow
            currentRow += goingDown ? 1 : -1;
        }

        // 拼接所有行的內容並返回最終的結果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Example 1: " + solution.convert(s1, numRows1));  // Output: "PAHNAPLSIIGYIR"

        // Example 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Example 2: " + solution.convert(s2, numRows2));  // Output: "PINALSIGYAHRPI"

        // Example 3
        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Example 3: " + solution.convert(s3, numRows3));  // Output: "A"
    }
}

/*
解題思路：
1. 邊界情況：如果numRows為1，則不需要進行Zigzag轉換，直接返回原始字符串。
2. 行的構建：創建StringBuilder[] rows來存儲每一行的字符。每個StringBuilder對應Zigzag中的一行。
3. 遍歷字符串：從字符串中依次取字符，根據當前行位置將字符添加到相應的行中。
4. 上下行變化：使用currentRow指標來追蹤當前的行數，並且通過goingDown變量來確定是向下還是向上移動。
5. 最終組合結果：將所有行拼接成最終結果並返回。

時間複雜度：
- O(n)，其中n是字符串s的長度。每個字符只會被遍歷一次。

空間複雜度：
- O(n)，由於使用了StringBuilder[] rows來存儲每一行的字符。
*/

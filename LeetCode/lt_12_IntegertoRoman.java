package LeetCode;

public class lt_12_IntegertoRoman {
    
}
class IntegerToRoman {
    public String intToRoman(int num) {
        // 定義數字和羅馬數字對應的陣列
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // 使用StringBuilder來拼接最終的羅馬數字
        StringBuilder roman = new StringBuilder();
        
        // 遍歷values陣列，依次將數字減去對應的數字並拼接羅馬數字
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);  // 將對應的羅馬數字添加到結果中
                num -= values[i];  // 減去對應的數字
            }
        }
        
        // 返回最終的羅馬數字
        return roman.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        int num1 = 3749;
        System.out.println("Example 1: " + solution.intToRoman(num1));  // Output: "MMMCDXLIX"
    }
}

/*
解題思路：
1. **數字與羅馬數字對應陣列**：我們先創建數字和羅馬數字的對應關係，並按照從大到小的順序排列。
2. **遍歷數字陣列**：從最大的數字開始，判斷是否可以從`num`中減去該數字。如果可以，將對應的羅馬數字添加到結果中，並減去該數字。
3. **拼接結果**：將所有的羅馬數字拼接成最終的結果並返回。
4. **時間複雜度**：O(1)，因為對應的數字和符號數量是固定的，最多只需遍歷13個數字。
5. **空間複雜度**：O(1)，使用了常數空間來存儲數字和羅馬數字的對應關係。
*/

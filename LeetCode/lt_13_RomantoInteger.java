package LeetCode;

public class lt_13_RomantoInteger {
    
}
class RomanToInteger {
    public int romanToInt(String s) {
        // 創建一個數字與羅馬數字對應的映射表
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        
        // 遍歷羅馬數字
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            
            // 如果當前數字比下一個數字小，則需要減去當前數字
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();

        // Example 1
        String s1 = "III";
        System.out.println("Example 1: " + solution.romanToInt(s1));  // Output: 3

        // Example 2
        String s2 = "LVIII";
        System.out.println("Example 2: " + solution.romanToInt(s2));  // Output: 58

        // Example 3
        String s3 = "MCMXCIV";
        System.out.println("Example 3: " + solution.romanToInt(s3));  // Output: 1994
    }
}

/*
解題思路：
1. **映射羅馬數字與數字的對應關係**：使用`Map<Character, Integer>`來存儲羅馬數字與其對應的數值。
2. **遍歷字符串**：從左到右遍歷字符串，對於每個字符，如果它的值小於其後面的字符值，則需要從總和中減去這個字符的值（例如IV表示4）。否則，將這個字符的值加到結果中。
3. **處理邊界情況**：只有在當前數字小於下一個數字時，才會進行減法操作，其它情況則加法操作。
4. **時間與空間複雜度**：
   - **時間複雜度**：O(n)，其中n是字符串的長度，我們遍歷了一次字符串。
   - **空間複雜度**：O(1)，因為我們使用的是固定大小的映射表。
*/

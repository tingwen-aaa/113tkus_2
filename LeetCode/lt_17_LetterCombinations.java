// LeetCode 17. Letter Combinations of a Phone Number
import java.util.*;

public class lt_17_LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        backtrack(result, phoneMap, digits, 0, new StringBuilder());
        return result;
    }
    
    private static void backtrack(List<String> result, Map<Character, String> phoneMap, 
                                  String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        String letters = phoneMap.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(result, phoneMap, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println("Result 1: " + letterCombinations(digits1));

        String digits2 = "";
        System.out.println("Result 2: " + letterCombinations(digits2));

        String digits3 = "2";
        System.out.println("Result 3: " + letterCombinations(digits3));
    }
}

/*
解題思路（繁體中文）：
1. 題目給定數字字串（2-9），需轉換為所有可能的字母組合。
2. 先建立數字到字母的映射表 (Map)，如 '2' → "abc"。
3. 採用回溯法 (Backtracking)：
   - 使用 StringBuilder 暫存當前路徑。
   - 每次遞迴加入一個字母，直到長度等於 digits。
   - 達到終止條件時，把完整組合加入結果集。
4. 時間複雜度 O(3^n * 4^m)，n 和 m 分別代表輸入中出現 3 個字母鍵與 4 個字母鍵的次數。
5. 空間複雜度 O(n)，遞迴深度最多等於 digits 長度。
*/

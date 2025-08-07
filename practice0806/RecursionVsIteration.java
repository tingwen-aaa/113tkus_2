public class RecursionVsIteration {

    // 1. Binomial Coefficient C(n, k)
    public static int binomialRecursive(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
    }

    public static int binomialIterative(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    // 2. Array product
    public static int productRecursive(int[] arr, int index) {
        if (index == arr.length) return 1;
        return arr[index] * productRecursive(arr, index + 1);
    }

    public static int productIterative(int[] arr) {
        int product = 1;
        for (int num : arr) {
            product *= num;
        }
        return product;
    }

    // 3. Count vowels in string
    public static int countVowelsRecursive(String str, int index) {
        if (index == str.length()) return 0;
        char c = Character.toLowerCase(str.charAt(index));
        int count = "aeiou".indexOf(c) >= 0 ? 1 : 0;
        return count + countVowelsRecursive(str, index + 1);
    }

    public static int countVowelsIterative(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    // 4. Parentheses matching
    public static boolean isValidParenthesesRecursive(String s, int index, int balance) {
        if (balance < 0) return false;
        if (index == s.length()) return balance == 0;
        if (s.charAt(index) == '(') return isValidParenthesesRecursive(s, index + 1, balance + 1);
        if (s.charAt(index) == ')') return isValidParenthesesRecursive(s, index + 1, balance - 1);
        return isValidParenthesesRecursive(s, index + 1, balance);
    }

    public static boolean isValidParenthesesIterative(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        // Binomial coefficient
        System.out.println("=== Binomial Coefficient C(5, 2) ===");
        System.out.println("Recursive: " + binomialRecursive(5, 2));
        System.out.println("Iterative: " + binomialIterative(5, 2));

        // Array product
        System.out.println("\n=== Array Product [1, 2, 3, 4] ===");
        int[] arr = {1, 2, 3, 4};
        System.out.println("Recursive: " + productRecursive(arr, 0));
        System.out.println("Iterative: " + productIterative(arr));

        // Count vowels
        System.out.println("\n=== Vowel Count in 'Education' ===");
        System.out.println("Recursive: " + countVowelsRecursive("Education", 0));
        System.out.println("Iterative: " + countVowelsIterative("Education"));

        // Parentheses matching
        System.out.println("\n=== Parentheses Check ===");
        String test1 = "(())()";
        String test2 = "(()))";
        System.out.printf("'%s' Recursive: %s\n", test1, isValidParenthesesRecursive(test1, 0, 0));
        System.out.printf("'%s' Iterative: %s\n", test1, isValidParenthesesIterative(test1));
        System.out.printf("'%s' Recursive: %s\n", test2, isValidParenthesesRecursive(test2, 0, 0));
        System.out.printf("'%s' Iterative: %s\n", test2, isValidParenthesesIterative(test2));
    }
}

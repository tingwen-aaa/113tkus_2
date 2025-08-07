public class StringRecursionDemo {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        System.out.printf("Compare str[%d]='%c' and str[%d]='%c'\n",
                          start, str.charAt(start), end, str.charAt(end));

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }

    public static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }

        char lastChar = str.charAt(str.length() - 1);
        String restReversed = reverseString(str.substring(0, str.length() - 1));

        System.out.printf("Reverse '%s' = '%c' + reverse('%s') = '%c' + '%s'\n",
                          str, lastChar, str.substring(0, str.length() - 1),
                          lastChar, restReversed);

        return lastChar + restReversed;
    }

    public static int stringLength(String str, int index) {
        if (index >= str.length()) {
            return 0;
        }
        return 1 + stringLength(str, index + 1);
    }

    public static int countChar(String str, char target, int index) {
        if (index >= str.length()) {
            return 0;
        }

        int currentCount = (str.charAt(index) == target) ? 1 : 0;
        return currentCount + countChar(str, target, index + 1);
    }

    public static void main(String[] args) {
        String word1 = "racecar";
        String word2 = "hello";
        String word3 = "programming";

        System.out.println("=== Palindrome Check ===");
        System.out.printf("Is '%s' a palindrome?\n", word1);
        boolean result1 = isPalindrome(word1, 0, word1.length() - 1);
        System.out.println("Result: " + result1);

        System.out.printf("\nIs '%s' a palindrome?\n", word2);
        boolean result2 = isPalindrome(word2, 0, word2.length() - 1);
        System.out.println("Result: " + result2);

        System.out.println("\n=== String Reversal ===");
        System.out.printf("Reverse '%s':\n", word2);
        String reversed = reverseString(word2);
        System.out.println("Final result: " + reversed);

        System.out.println("\n=== String Utilities ===");
        System.out.printf("Length of '%s': %d\n", word3, stringLength(word3, 0));
        System.out.printf("Count of 'r' in '%s': %d\n", word3, countChar(word3, 'r', 0));
        System.out.printf("Count of 'm' in '%s': %d\n", word3, countChar(word3, 'm', 0));
    }
}

import java.util.*;

public class AdvancedStringRecursion {

    public static void generatePermutations(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, result + str.charAt(i));
        }
    }

    public static boolean match(String text, String pattern, int tIdx, int pIdx) {
        if (pIdx == pattern.length()) {
            return tIdx == text.length();
        }

        if (tIdx == text.length()) {
            return false;
        }

        if (pattern.charAt(pIdx) == '?' || pattern.charAt(pIdx) == text.charAt(tIdx)) {
            return match(text, pattern, tIdx + 1, pIdx + 1);
        }

        return false;
    }

    public static String removeDuplicates(String str, Set<Character> seen, int index) {
        if (index >= str.length()) {
            return "";
        }

        char c = str.charAt(index);
        if (seen.contains(c)) {
            return removeDuplicates(str, seen, index + 1);
        } else {
            seen.add(c);
            return c + removeDuplicates(str, seen, index + 1);
        }
    }

    public static void generateSubstrings(String str, String current, int index) {
        if (index == str.length()) {
            if (!current.isEmpty()) {
                System.out.println(current);
            }
            return;
        }

        // Include current character
        generateSubstrings(str, current + str.charAt(index), index + 1);

        // Exclude current character
        generateSubstrings(str, current, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== String Permutations ===");
        generatePermutations("abc", "");

        System.out.println("\n=== Simple String Matching (supports '?') ===");
        String text = "hello";
        String pattern = "he??o";
        System.out.printf("Match '%s' with '%s': %s\n", text, pattern, match(text, pattern, 0, 0));

        System.out.println("\n=== Remove Duplicate Characters ===");
        String input = "programming";
        String result = removeDuplicates(input, new HashSet<>(), 0);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + result);

        System.out.println("\n=== All Substrings ===");
        generateSubstrings("abc", "", 0);
    }
}

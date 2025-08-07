public class RecursiveMathCalculator {

    public static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combination(n - 1, k - 1) + combination(n - 1, k);
    }

    public static int catalan(int n) {
        if (n == 0) return 1;

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += catalan(i) * catalan(n - 1 - i);
        }
        return result;
    }

    public static int hanoiMoves(int n) {
        if (n == 1) return 1;
        return 2 * hanoiMoves(n - 1) + 1;
    }

    public static boolean isPalindromeNumber(int n) {
        return n == reverseNumber(n, 0);
    }

    private static int reverseNumber(int n, int reversed) {
        if (n == 0) return reversed;
        return reverseNumber(n / 10, reversed * 10 + n % 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Combination C(n, k) ===");
        System.out.println("C(5, 2) = " + combination(5, 2));
        System.out.println("C(6, 3) = " + combination(6, 3));

        System.out.println("\n=== Catalan Numbers ===");
        for (int i = 0; i <= 5; i++) {
            System.out.printf("Catalan(%d) = %d\n", i, catalan(i));
        }

        System.out.println("\n=== Hanoi Moves ===");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("hanoiMoves(%d) = %d\n", i, hanoiMoves(i));
        }

        System.out.println("\n=== Palindrome Number Check ===");
        int[] testNumbers = {121, 12321, 123, 4554, 1001, 2023};
        for (int n : testNumbers) {
            System.out.printf("%d is palindrome: %s\n", n, isPalindromeNumber(n));
        }
    }
}

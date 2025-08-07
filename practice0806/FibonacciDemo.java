public class FibonacciDemo {

    public static int fibonacciSlow(int n) {
        System.out.printf("Computing F(%d)\n", n);
        if (n <= 1) {
            return n;
        }
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 6;

        System.out.println("=== Recursive Version ===");
        long startTime = System.nanoTime();
        int result1 = fibonacciSlow(n);
        long endTime = System.nanoTime();
        System.out.printf("F(%d) = %d, Time: %.3f ms\n", 
                          n, result1, (endTime - startTime) / 1_000_000.0);

        System.out.println("\n=== Memoized Version ===");
        int[] memo = new int[n + 1];
        startTime = System.nanoTime();
        int result2 = fibonacciFast(n, memo);
        endTime = System.nanoTime();
        System.out.printf("F(%d) = %d, Time: %.3f ms\n", 
                          n, result2, (endTime - startTime) / 1_000_000.0);

        System.out.println("\n=== Iterative Version ===");
        startTime = System.nanoTime();
        int result3 = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.printf("F(%d) = %d, Time: %.3f ms\n", 
                          n, result3, (endTime - startTime) / 1_000_000.0);

        System.out.println("\n=== First 10 Fibonacci Numbers ===");
        for (int i = 0; i < 10; i++) {
            System.out.printf("F(%d) = %d\n", i, fibonacciIterative(i));
        }
    }
}

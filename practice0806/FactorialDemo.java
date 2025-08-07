public class FactorialDemo {

    public static long factorial(int n) {
        if (n <= 1) {
            System.out.println(n + "! = 1");
            return 1;
        }

        System.out.println(n + "! = " + n + " × " + (n - 1) + "!");
        long result = n * factorial(n - 1);
        System.out.println(n + "! = " + result);
        return result;
    }

    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Recursive Factorial ===");
        System.out.println("Computing 5!:");
        long result1 = factorial(5);
        System.out.println("Result: " + result1);

        System.out.println("\n=== Iterative Factorial ===");
        long result2 = factorialIterative(5);
        System.out.println("5! = " + result2);

        System.out.println("\n=== Additional Tests ===");
        for (int i = 0; i <= 6; i++) {
            System.out.printf("%d! = %d\n", i, factorial(i));
        }
    }
}

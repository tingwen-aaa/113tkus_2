public class MathRecursionDemo {

    public static int gcd(int a, int b) {
        System.out.printf("gcd(%d, %d)\n", a, b);
        if (b == 0) {
            System.out.printf("gcd(%d, 0) = %d\n", a, a);
            return a;
        }
        return gcd(b, a % b);
    }

    public static int digitSum(int n) {
        System.out.printf("digitSum(%d)\n", n);
        if (n < 10) {
            return n;
        }
        int lastDigit = n % 10;
        int restSum = digitSum(n / 10);
        System.out.printf("digitSum(%d) = %d + digitSum(%d) = %d + %d = %d\n",
                          n, lastDigit, n / 10, lastDigit, restSum, lastDigit + restSum);
        return lastDigit + restSum;
    }

    public static long power(int base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        return base * power(base, exp - 1);
    }

    public static long powerFast(int base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;

        long half = powerFast(base, exp / 2);
        long result = half * half;

        if (exp % 2 == 1) {
            result *= base;
        }

        return result;
    }

    public static boolean isPrime(int n, int divisor) {
        if (n <= 1) return false;
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== GCD (Greatest Common Divisor) ===");
        int result1 = gcd(48, 18);
        System.out.println("gcd(48, 18) = " + result1);

        System.out.println("\n=== Digit Sum ===");
        int result2 = digitSum(12345);
        System.out.println("digitSum(12345) = " + result2);

        System.out.println("\n=== Power Calculation ===");
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("2^10 (fast) = " + powerFast(2, 10));

        System.out.println("\n=== Prime Number Check ===");
        int[] testNumbers = {2, 17, 25, 29, 30};
        for (int num : testNumbers) {
            boolean isPrimeResult = isPrime(num, 2);
            System.out.printf("%d is prime: %s\n", num, isPrimeResult);
        }
    }
}

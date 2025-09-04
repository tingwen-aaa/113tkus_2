// LeetCode 29. Divide Two Integers
//
// Given two integers dividend and divisor, divide two integers without using
// multiplication, division, and mod operator.
// Return the quotient after dividing dividend by divisor.
// The integer division should truncate toward zero.
//
// 給定兩個整數 dividend 和 divisor，在不使用乘法、除法和取餘數運算子的情況下，
// 計算它們的商（向零截斷）。
// 若結果超出 32 位整數範圍，返回 Integer.MAX_VALUE。

public class lt_29_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        int result = 0;
        while (a >= b) {
            long temp = b;
            int multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + divide(10, 3));   // 3
        System.out.println("Result 2: " + divide(7, -3));   // -2
        System.out.println("Result 3: " + divide(-2147483648, -1)); // 2147483647 (MAX_VALUE)
        System.out.println("Result 4: " + divide(-15, 2));  // -7
    }
}

/*
解題思路（繁體中文）：
1. 不可用 *, /, %，因此需用減法與位移模擬除法。
2. 步驟：
   - 將 dividend, divisor 轉成正數 (long)，記錄符號 sign。
   - 迴圈中：將 divisor 不斷左移 (乘以 2)，直到超過 dividend。
   - 減去最大的有效 divisor 倍數，並累加商的對應倍數。
   - 重複直到 dividend < divisor。
3. 最後回傳 result * sign。
4. 特殊情況：Integer.MIN_VALUE / -1 溢位 → 回傳 Integer.MAX_VALUE。
5. 時間複雜度 O(log n)，空間複雜度 O(1)。
*/

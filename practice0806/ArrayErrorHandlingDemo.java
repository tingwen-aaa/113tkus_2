import java.util.Arrays;

public class ArrayErrorHandlingDemo {

    public static int safeGet(int[] array, int index, int defaultValue) {
        if (array == null) {
            System.out.println("Warning: array is null, returning default value");
            return defaultValue;
        }

        if (index < 0 || index >= array.length) {
            System.out.printf("Warning: index %d out of bounds [0, %d], returning default value\n",
                    index, array.length - 1);
            return defaultValue;
        }

        return array[index];
    }

    public static boolean safeSet(int[] array, int index, int value) {
        if (array == null) {
            System.out.println("Error: cannot set value on a null array");
            return false;
        }

        if (index < 0 || index >= array.length) {
            System.out.printf("Error: cannot set value at index %d, valid range is [0, %d]\n",
                    index, array.length - 1);
            return false;
        }

        array[index] = value;
        System.out.printf("Success: array[%d] = %d\n", index, value);
        return true;
    }

    public static void demonstrateCommonErrors() {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array content: " + Arrays.toString(numbers));
        System.out.printf("Array length: %d\n", numbers.length);
        System.out.printf("Valid index range: 0 to %d\n", numbers.length - 1);
        System.out.println();

        System.out.println("=== Common Error Handling ===");

        try {
            int value = numbers[numbers.length];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught error: array index out of bounds");
        }

        try {
            int value = numbers[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught error: negative index");
        }
    }

    public static void main(String[] args) {
        demonstrateCommonErrors();

        System.out.println("\n=== Safe Access Demo ===");
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Valid access: " + safeGet(numbers, 2, -1));
        System.out.println("Out-of-bounds access: " + safeGet(numbers, 10, -1));
        System.out.println("Negative index: " + safeGet(numbers, -1, -1));
        System.out.println("Null array: " + safeGet(null, 0, -1));

        System.out.println("\nSafe Set Demo:");
        safeSet(numbers, 2, 999);
        safeSet(numbers, 10, 888);
        safeSet(null, 0, 777);

        System.out.println("Final array: " + Arrays.toString(numbers));
    }
}

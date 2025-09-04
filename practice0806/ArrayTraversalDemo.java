public class ArrayTraversalDemo {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Method 1: Traditional for loop");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Index %d: Value %d\n", i, numbers[i]);
        }

        System.out.println("\nMethod 2: Enhanced for loop");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.println("Current value: " + num + ", Sum: " + sum);
        }

        System.out.println("\nMethod 3: Reverse traversal");
        System.out.print("Reversed: ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();

        System.out.println("\nMethod 4: Step-by-2 traversal");
        System.out.print("Even indices: ");
        for (int i = 0; i < numbers.length; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}

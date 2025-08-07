public class LinkedListRecursionDemo {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        printList(head.next);
    }

    public static void printListReverse(ListNode head) {
        if (head == null) return;
        printListReverse(head.next);
        System.out.print(head.data + " ");
    }

    public static int getLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    public static boolean search(ListNode head, int target) {
        if (head == null) return false;
        if (head.data == target) return true;
        return search(head.next, target);
    }

    public static int sumList(ListNode head) {
        if (head == null) return 0;
        return head.data + sumList(head.next);
    }

    public static int findMax(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("Cannot find max in an empty list.");
        }
        if (head.next == null) {
            return head.data;
        }
        int maxOfRest = findMax(head.next);
        return Math.max(head.data, maxOfRest);
    }

    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createList(values);

        System.out.println("=== Linked List Recursion Demo ===");

        System.out.print("Forward: ");
        printList(head);
        System.out.println();

        System.out.print("Reverse: ");
        printListReverse(head);
        System.out.println();

        System.out.println("Length: " + getLength(head));
        System.out.println("Sum: " + sumList(head));
        System.out.println("Max: " + findMax(head));

        System.out.println("Search 3: " + search(head, 3));
        System.out.println("Search 6: " + search(head, 6));

        System.out.println("\n=== Empty List Test ===");
        ListNode emptyList = null;
        System.out.print("Print: ");
        printList(emptyList);
        System.out.println("(no output)");
        System.out.println("Length: " + getLength(emptyList));
        System.out.println("Search 1: " + search(emptyList, 1));
    }
}

// LeetCode 24. Swap Nodes in Pairs

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt_24_SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;

            a.next = b.next;
            b.next = a;
            prev.next = b;

            prev = a;
        }
        return dummy.next;
    }

    // 工具：將鏈結串列轉為字串方便輸出
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example 1: [1,2,3,4] -> [2,1,4,3]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Result 1: " + listToString(swapPairs(head1))); // [2,1,4,3]

        // Example 2: [] -> []
        ListNode head2 = null;
        System.out.println("Result 2: " + listToString(swapPairs(head2))); // []

        // Example 3: [1] -> [1]
        ListNode head3 = new ListNode(1);
        System.out.println("Result 3: " + listToString(swapPairs(head3))); // [1]

        // Example 4: [1,2,3] -> [2,1,3]
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("Result 4: " + listToString(swapPairs(head4))); // [2,1,3]
    }
}

/*
解題思路（繁體中文）：
1. 題目要求兩兩交換相鄰節點，不可改節點的值，只能調整指標。
2. 使用假頭節點 dummy，prev 指向當前要交換的一對前面。
3. 若有節點 a=prev.next、b=a.next：
   - 將 a.next 指向 b.next；
   - 將 b.next 指向 a；
   - 將 prev.next 指向 b；
   - 最後將 prev 移到 a。
4. 重複處理直到不足兩個節點為止。
5. 回傳 dummy.next 即為新鏈結串列。
時間複雜度：O(n)，空間複雜度：O(1)。
*/

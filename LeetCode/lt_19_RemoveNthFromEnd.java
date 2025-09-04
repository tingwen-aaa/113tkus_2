// LeetCode 19. Remove Nth Node From End of List

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt_19_RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;
        
        // first 先走 n+1 步
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // first 和 second 一起走，直到 first 到底
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second.next 就是要刪除的節點
        second.next = second.next.next;
        
        return dummy.next;
    }

    // 測試用：將鏈結串列轉為字串
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
        // Example 1: [1,2,3,4,5], n=2 → [1,2,3,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head1 = removeNthFromEnd(head1, 2);
        System.out.println("Result 1: " + listToString(head1));

        // Example 2: [1], n=1 → []
        ListNode head2 = new ListNode(1);
        head2 = removeNthFromEnd(head2, 1);
        System.out.println("Result 2: " + listToString(head2));

        // Example 3: [1,2], n=1 → [1]
        ListNode head3 = new ListNode(1, new ListNode(2));
        head3 = removeNthFromEnd(head3, 1);
        System.out.println("Result 3: " + listToString(head3));
    }
}

/*
解題思路（繁體中文）：
1. 題目要求刪除倒數第 n 個節點。若直接遍歷長度，需要兩次遍歷。
2. 為了只遍歷一次，使用「雙指針」法：
   - 建立 dummy 節點指向 head，避免刪除頭節點時出錯。
   - first 指針先走 n+1 步。
   - 然後 first 和 second 一起移動，直到 first 到底。
   - 此時 second.next 即為倒數第 n 個節點，將它刪除。
3. 回傳 dummy.next 即為新的 head。
4. 時間複雜度 O(L)，其中 L 為鏈結串列長度。
5. 空間複雜度 O(1)。
*/

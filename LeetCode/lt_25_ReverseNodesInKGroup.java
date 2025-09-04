// LeetCode 25. Reverse Nodes in k-Group

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt_25_ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGroup, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;
            // 反轉 [prevGroup.next, kth]
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = tmp;
        }

        return dummy.next;
    }

    private static ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // 輔助：鏈結串列轉字串
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
        // Example 1: [1,2,3,4,5], k=2 -> [2,1,4,3,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Result 1: " + listToString(reverseKGroup(head1, 2))); // [2,1,4,3,5]

        // Example 2: [1,2,3,4,5], k=3 -> [3,2,1,4,5]
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Result 2: " + listToString(reverseKGroup(head2, 3))); // [3,2,1,4,5]
    }
}

/*
解題思路（繁體中文）：
1. 將鏈結串列分組，每組 k 個節點。
2. 先找到該組的第 k 個節點（若不足 k 個，直接返回）。
3. 使用指標操作將這一組反轉，並接回主鏈結串列。
4. 重複操作直到整條鏈結串列處理完畢。
5. 時間複雜度 O(n)，每個節點只處理一次。
6. 空間複雜度 O(1)，僅需常數額外變數。
*/

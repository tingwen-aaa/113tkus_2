// LeetCode 21. Merge Two Sorted Lists

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt_21_MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        
        return dummy.next;
    }

    // 測試輸出工具
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
        // Example 1: [1,2,4], [1,3,4] -> [1,1,2,3,4,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Result 1: " + listToString(mergeTwoLists(l1, l2)));

        // Example 2: [], [] -> []
        ListNode l3 = null;
        ListNode l4 = null;
        System.out.println("Result 2: " + listToString(mergeTwoLists(l3, l4)));

        // Example 3: [], [0] -> [0]
        ListNode l5 = null;
        ListNode l6 = new ListNode(0);
        System.out.println("Result 3: " + listToString(mergeTwoLists(l5, l6)));
    }
}

/*
解題思路（繁體中文）：
1. 題目要求將兩個已排序的鏈結串列合併成一個排序後的鏈結串列。
2. 使用「假頭節點」dummy，避免處理第一個節點時的特殊情況。
3. 建立指針 curr 從 dummy 開始，依序比較 list1 和 list2 的當前節點：
   - 若 list1.val < list2.val，則把 list1 節點接到 curr 後面，並移動 list1。
   - 否則接上 list2 節點，並移動 list2。
   - curr 往後移動一格。
4. 若其中一個串列還有剩餘節點，直接接到 curr 後面。
5. 回傳 dummy.next 即為合併後的結果。
6. 時間複雜度 O(n+m)，n 和 m 分別是兩個串列的長度。
7. 空間複雜度 O(1)，僅使用指標操作。
*/

// LeetCode 23. Merge k Sorted Lists
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lt_23_MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // 將每個鏈結串列的頭節點加入最小堆
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) pq.offer(cur.next);
        }

        return dummy.next;
    }

    // 輔助方法：將鏈結串列轉成字串方便測試
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
        // Example 1: [[1,4,5],[1,3,4],[2,6]] -> [1,1,2,3,4,4,5,6]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists1 = {l1, l2, l3};
        System.out.println("Result 1: " + listToString(mergeKLists(lists1)));

        // Example 2: [] -> []
        ListNode[] lists2 = {};
        System.out.println("Result 2: " + listToString(mergeKLists(lists2)));

        // Example 3: [[]] -> []
        ListNode[] lists3 = {null};
        System.out.println("Result 3: " + listToString(mergeKLists(lists3)));
    }
}

/*
解題思路（繁體中文）：
1. 將 k 個已排序鏈結串列合併成一個。
2. 使用最小堆（PriorityQueue）保存當前每個串列的最小節點。
   - 初始化時，把每個非空串列的頭節點放入堆。
   - 每次從堆中取出最小節點，接到結果鏈結串列後面。
   - 若該節點有 next，將 next 再放入堆中。
3. 重複此過程直到堆為空，即完成合併。
4. 時間複雜度：O(N log k)，其中 N 是所有節點數，k 是串列數。
5. 空間複雜度：O(k)，堆最多同時存放 k 個節點。
*/

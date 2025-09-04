package LeetCode;

public class lt_02_AddTwoNumbers {
    
}
// 題目：Add Two Numbers
// 給定兩個非空的鏈結串列，分別表示兩個非負整數（數字以反向儲存，每個節點一位數），請回傳它們的和（同樣以鏈結串列形式，反向儲存）。

class Solution {
    // LeetCode 已內建 ListNode 定義，這裡直接使用
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}

/*
解題思路：
1. 兩數以反向鏈結串列表示，頭節點就是個位數，方便從低位開始相加。
2. 逐位計算 sum = x + y + carry。
   - 當前位 = sum % 10
   - 進位 = sum / 10
3. 用 dummy 節點簡化串接過程。
4. 若串列長度不同，短的補 0。
5. 最後如果還有進位，額外補一個節點。
6. 時間複雜度 O(max(m,n))，空間 O(1)。
*/
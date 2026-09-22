/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow.next;
        ListNode h2 = pre.next;
        pre.next = null;
        slow.next = null;
        while (h2 != null) {
            ListNode temp = h2.next;
            h2.next = pre;
            pre = h2;
            h2 = temp;
        }
        while (pre != null) {
            ListNode temp1 = head.next;
            ListNode cur = pre;
            pre = pre.next;
            head.next = cur;
            cur.next = temp1;
            head = temp1;
        }
    }
}

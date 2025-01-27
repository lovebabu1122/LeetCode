/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry=0;
        int value;
        while (l1 != null || l2 != null || carry != 0) {
            value=carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;  
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            carry = value / 10;
            current.next = new ListNode(value% 10);
            current = current.next;
        }
        return head.next;
    }
}
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
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; 
            curr.next = prev;              
            prev = curr;                   
            curr = nextNode;               
        }
        return prev; 
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){//for even and odd size both
            slow=slow.next;
            fast=fast.next.next;
        }
        if (head == null || head.next == null) {
            return true; 
        }
        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfHead;
        while(secondHalf!=null){
            if (firstHalf.val != secondHalf.val) {
                return false; 
            }
            secondHalf=secondHalf.next;
            firstHalf=firstHalf.next;
        }
        return true;
    }
}
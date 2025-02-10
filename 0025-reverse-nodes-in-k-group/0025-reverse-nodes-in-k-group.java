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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
            return head;
        }
        ListNode pre=null;
        ListNode curr=head;
        ListNode upcoming=null;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count < k) {
            return head;
        }
        int num=0;
        while(curr!=null && num<k){
            upcoming=curr.next;
            curr.next=pre;
            pre=curr;
            curr=upcoming;
            num++;
        }
        if (upcoming != null) {
            head.next = reverseKGroup(upcoming, k);
        }
        return pre;
    }
}
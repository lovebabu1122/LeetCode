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
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode curr1=l1;
        ListNode next1=curr1.next;
        ListNode curr2=l2;
        ListNode next2=null;
        while (curr1 != null && curr2 != null){
            if (next1 == null || (curr2.val >= curr1.val && curr2.val <= next1.val)) {
                next2 = curr2.next; 
                curr1.next = curr2;  
                curr2.next = next1; 
                curr1=curr2;
                curr2=next2;
            }
            else
            {
                curr1=next1;
                if(next1!=null){
                    next1=next1.next;
                }
            }
        }
        return l1;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1;
        ListNode head2=list2;
        if(head1 == null){
            return list2;
        }
        if(head2 == null){
            return list1;
        }
        if (list1.val <= list2.val) {
            return merge(list1, list2);
        } else {
            return merge(list2, list1);
        }
    }
}
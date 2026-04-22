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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1; 
        ListNode head2 = list2; 
        ListNode head = new ListNode(-1);
        ListNode aux = head; 

        while (head1 != null && head2 != null ){
            if(head1.val >= head2.val){
                aux.next = head2; 
                head2 = head2.next;
            }
            else{
                aux.next = head1; 
                head1 = head1.next;
            }
            aux = aux.next;
        }

        if(head1 != null) aux.next = head1;
        if(head2 != null) aux.next = head2;
        
        return head.next; 
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head); 
        ListNode right = dummy;
        ListNode left = dummy;

        for (int i = 0; i < n; i++){ // loop to separate the n distance between left and right pointer
            right = right.next;
        }

        while (right.next != null){ // with this loop the right pointer is at the end and the left is prev than the nth node
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next; // remove the next node that is the nth node
        return dummy.next;

    }
}

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
        ListNode step = head; 
        ListNode steps = head;
        ListNode prev = null;

        while (steps != null && steps.next != null){ // loop to find the mid of the list, one pointer in the first half and other in the second half
            step = step.next; 
            steps = steps.next.next;
        }

        ListNode current = step.next; 
        step.next = null; // break in two lists

        while( current != null){ // loop to reverse the second half
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode left = head; 
        ListNode right = prev;

    while (right != null){ // reordering the list with the elements of each one
        ListNode tempLeft = left.next; 
        ListNode tempRight = right.next; 
        left.next = right;
        right.next = tempLeft;
        left = tempLeft;
        right = tempRight;
    }

    
    }
}

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
    public boolean hasCycle(ListNode head) {
        ListNode steps = head; // pointer to walk 2 nodes
        ListNode step = head; // pointer to walk 1 node

        while (steps != null && steps.next != null){
            step = step.next; 
            steps = steps.next.next;

            if (step == steps){ // if steps and step be in the same node, it means that has a cycle in the list
                return true;
            }
        }
        return false; 
    }
}

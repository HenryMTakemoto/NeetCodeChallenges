// In this challenge, I have to find the duplicated number in a linked list, 
// In O(n) time and O(1) extra space. 

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0; // Using 2 pointers Floyd's algorithm 
        int fast = 0; 

        while(true){ // Finding the place that the pointers meet 
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow ){
                break;
            }
        }

        int secondSlow = 0; // Another slow pointer
        
        while(true){ // The place that the 2 slow pointers meet each other is the duplicated number
            secondSlow = nums[secondSlow];
            slow = nums[slow];
            if (slow == secondSlow) return slow;
        }
        
    }
}

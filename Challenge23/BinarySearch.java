class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1; // idx for right pointer
        int left = 0;  // idx for left pointer

        while ( left <= right){
            int mid = left + (right - left)/2; // updating the mid 
            if (nums[mid] == target){ // if the mid is the target, returns mid
                return mid;
            }
            else if (nums[mid] > target){ // if the mid is greater than the target, the right pointer comes to the left of the mid
                right = mid - 1;
            }
            else {
                left = mid + 1; // if the mid is less than target, the left pointer comes to the right of the mid
            }
        }
        return -1; // if didn't find the target, returns -1  
    }
}

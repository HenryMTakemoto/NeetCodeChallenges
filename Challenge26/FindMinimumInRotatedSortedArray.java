class Solution {
    public int findMin(int[] nums) {
        int left = 0; 
        int right  = nums.length - 1; 
        int min = nums[left];

        while (left <= right){
            int mid = left + (right - left)/2;

            if(min > nums[mid]){
                min = nums[mid];
            }

            if (nums[mid] >= nums[left]){ // if the left side is ordered    
                if (nums[left] < nums[right]) {  // if the whole side is ordered, the number is in this part
                    right = mid - 1;
                } else { // if it isn't, the number is in the right side
                    left = mid + 1;
                }
            }
            else{ // if the left side isn't ordered, the min value is in the left side
                right = mid - 1;
            }
            
        }
        return min;
    }
}
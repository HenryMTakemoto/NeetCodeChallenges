/* Description of the challenge: You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:

[3,4,5,6,1,2] if it was rotated 4 times.
[1,2,3,4,5,6] if it was rotated 6 times.
Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.

You may assume all elements in the sorted rotated array nums are unique,

A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time? */

class Solution {
    public int search(int[] nums, int target) { // I didn't get the better runtime in this challenge, but my logic was easier by divinding the problem into 2
        int left = 0; 
        int right = nums.length - 1; 
        int min = nums[left];
        int positionMin = 0;
        
        while ( left <= right ){ // I created this loop to find the position of the minimum number, this position is 
            int mid = left + (right - left)/2; // how many times this array was rotated

            if (min > nums[mid]){
                min = nums[mid];
                positionMin = mid; 
            }
            if (nums[mid] >= nums[right]){
                left = mid + 1; 
            }
            else {
                right = mid - 1; 
            }
        }

        right = nums.length - 1;
        left = 0; 

            if (target >= nums[positionMin] && target <= nums[right]){ // after, I check if the target is in the right side of the minimun
                left = positionMin;
            }
            else{  // or it is in the left side 
                right = positionMin;
            }

        while (left <= right ){ // Loop with binary search to find the target
            int mid = left + (right - left)/2;

            if(nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] < target){
                left = mid + 1; 
            }
            else {
                return mid; 
            }

        }

        return -1; // If I didn't find the target, I return -1 
        }
    }


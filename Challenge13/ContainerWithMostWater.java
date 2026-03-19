// In this challenge, I have an non-ordering array and I have to calculate the max Area
// in the array between 2 numbers

class Solution {
    public int maxArea(int[] heights) {
        int left = 0; // pointer for left
        int right = heights.length - 1; // pointer for right
        int currentArea = 0; // variable for current area
        int maxArea = 0;  // variable for return the max area
        while (left < right){
            if(heights[left] > heights[right]){ 
                int base = right - left; // base is the distance between right pointer and left pointer
                currentArea = heights[right]*base; // area is the height of the smaller times the base
                right--; // right value is less than left, than I decrement the right pointer
            }
            else if (heights[left] < heights[right]){
                int base = right - left; 
                currentArea = heights[left]*base;
                left++; // right value is greater than left, than I increment the left pointer
            }
            else{
                int base = right - left; 
                currentArea = heights[left]*base;
                left++; // if they are equal values, I can just choose one to increment or decrement
            }
            if (currentArea >= maxArea ){
                maxArea = currentArea; // If the current area is bigger than max, I change the max area to the current
            } 
            else{
                continue;
            }
        }
        return maxArea; 
    }
}

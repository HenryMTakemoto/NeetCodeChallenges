// Description of the challenge: You are given an array of non-negative integers height which represent an elevation map. 
// Each value height[i] represents the height of a bar, which has a width of 1.
// Return the maximum area of water that can be trapped between the bars.

// To solve this challenge, I had to think in this way: how much water this cell can contain?

class Solution {
    public int trap(int[] height) {
        int n = height.length; // Using 2 auxiliary arrays
        int[] maxLeft = new int[n]; 
        int[] maxRight = new int[n];
        int waterArea = 0; 

        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) { // The first array will contains the tallest walls from left to right
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[n - 1] = height[n - 1]; 
        for (int i = n - 2; i >= 0; i--) { // The second array will contains the tallest walls from right to left
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 0 ; i < n ; i++){ // Calculate the trapped water at each index
            int maximumWater = Math.min(maxLeft[i], maxRight[i]); // The water level is limited by the shortest of the two tallest walls
            int waterInIndex = maximumWater - height[i];  // The actual trapped water is the water level minus the ground height
            waterArea += waterInIndex;
        }
        return waterArea;

    }
}
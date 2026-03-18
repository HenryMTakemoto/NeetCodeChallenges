// This challenge is similar to the TwoSumChallenge, but in this case 
// the array is already in non-decreasing order and I have to return
// indexes assuming a 1-indexed array

class Solution {
    public int[] twoSum(int[] numbers, int target) { 
       int left = 0; // index for left 
       int right = numbers.length - 1; // index for right

       while (left < right){ // Since the array is already sorted, I can only iterate through it using a pointer at the end and one at the beginning.
        int sum = numbers[left] + numbers[right];
        if (sum == target ) {
            return new int[]{left+1, right + 1}; // if the sum is equal to the target, then that is the answer
        }
        else if (sum > target ){ // if the sum is greater than the target, we need a smaller number
            right--;
        }
        else { 
            left++; // if the sum is less than the target, we need a larger number
        }
       }
       return new int[]{};
    }
}

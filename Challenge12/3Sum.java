// This challenge asks for return an array with trios that the sum is 0

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Ordering the vector
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i ++){
            int left = i+1; // Using 2 pointers for veritfy the other 2 numbers in addition to current
            int right = nums.length - 1; 
            if ( i > 0 && nums[i] == nums[i-1]){ // checking if we have already used the number, to not return the same trio
                continue; 
            }
            while (left < right){ 
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == 0){
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));  // if the sum of the 3 numbers is 0, add in result
                left++; // continue for check other possible results
                right--;
                while(left < right && nums[left] == nums[left - 1]){ // if we have already used this number, go for the next
                    left++;
                }       
                }
                else if (sum > 0 ){
                    right--; // if sum is greather than 0, we need a smaller value
                }
                else {
                    left++; // if sum is less than 0, we need a greater value
                }
            }
        }
        return result;
    }
}

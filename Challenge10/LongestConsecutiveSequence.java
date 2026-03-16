// In this challenge, I receive an array of integers and I have to discover
// the longest consecutive sequence of that array

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>(); // Use HashSet to hold the numbers
        int longestSequence = 0; 
        for (int num : nums){ // Fill the HashSet with array values, ignoring duplicates
            numbers.add(num);
        }

        for (int num : numbers){ 
            int before = num - 1; // Getting the number before current value
            if(numbers.contains(before)){ // If there is a number before current value, it isn't the beginning of the sequence
                continue;
            }
            int currentNum = num; // If it is the beginning of the sequence, I get the value
            int currentSequence = 1; // Start the variable for sequence
            while (numbers.contains(currentNum+1)){ // While there is a consecutive number after the current one
                currentNum += 1; // Increment the value
                currentSequence += 1; // Increment the sequence
            }
            int aux = longestSequence; // Auxiliary variable for the longest sequence
            if(currentSequence >= aux){ // If the current sequence is greater than older longest sequence
                longestSequence = currentSequence; // I change the longest sequence to the current sequence
            }
        }
        return longestSequence;
    }
}

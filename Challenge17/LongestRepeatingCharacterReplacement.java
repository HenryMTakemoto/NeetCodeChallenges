// In this challenge I have to return the longest repeating character with replacement
// I receive a quantity of characters I can replace, I have to return the longest repeating character
// with the possibility of replacement

class Solution {
    public int characterReplacement(String s, int k) {
        char[] string = s.toCharArray();
        int[] counter = new int[26]; // array to act as a frequency map for the 26 uppercase English letters
        int longestSub = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0 ; right < string.length ; right++){
            char letter = string[right];
            counter[letter - 'A']++; // increment the letter in the counter
            maxFreq = Math.max(maxFreq, counter[letter - 'A']); // get the max frequence of a character

            int differents = right - left + 1 - maxFreq; // Calculate the number of characters that need 
            // to be replaced (Total window size - Most frequent character)

                while(differents > k){ // If the characters to replace exceed 'k', the window is invalid. We must shrink it from the left.
                    counter[string[left] - 'A']--; // remove the leftmost character from the count
                    left++; // shrink the window until it becomes valid again
                    differents = right - left + 1 - maxFreq;
                }
            longestSub = Math.max(longestSub, right-left +1); // Here the window is valid. Update the maximum length found so far

        }
        return longestSub;
        }

}

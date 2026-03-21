// In this challenge I receive a string, find the length of the
// longest substring without duplicate characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> letters = new HashSet<>(); // Hash to keep used characters
        char[] string = s.toCharArray(); // Convert a string to char array
        int longestSub = 0; 
        int left = 0; // pointer for start
        int right = 0; // pointer to end

        while (right < string.length){
            char letter = string[right]; // get the char
            if (letters.contains(letter)){ // verify if this char exists in my hash
                while (letters.contains(letter)){ // if it exists, I have to walk the left pointer
                    char let = string[left]; // until remove the repeated letter
                    letters.remove(let);
                    left++;
                }
            }
            else{
                longestSub = Math.max(longestSub, right - left + 1 ); // verify if the currentSub is longer than the current longest
                letters.add(letter); // add letter in hash
                right++; // move the pointer
            }
        }
        return longestSub;
    }
}

// In this challenge I have to verify if the string2 contains a 
// permutation of a string1

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] string1 = s1.toCharArray();
        char[] string2 = s2.toCharArray();
        int[] s1Counter = new int[26]; // counter for letters of string1 
        int[] windowCounter = new int[26]; // counter for the window that are I am analyzing in string2
        int windowSize = string1.length; // size of the window is the length of the string1 
        int left = 0;
        int right = windowSize-1; 

        if (string1.length > string2.length){ // if string1 is longer than string2, return false
            return false;
        }

        for ( int i = 0 ; i < string1.length ; i++ ){ // adding to the counter the letters on string1 
            char letter1 = string1[i];
            s1Counter[letter1 - 'a']++;
            char letter2 = string2[i]; // getting the counter of the letters of string2 too
            windowCounter[letter2 - 'a']++;
        }

        if (Arrays.equals(windowCounter, s1Counter)){ // Verify if the first window returns true 
            return true; 
        }
        
        while ( right < string2.length - 1){ // If the first window wasn't true, I create a sliding window algorithm 
            right++;
            char let1 = string2[right]; // add the new letter
            windowCounter[let1 - 'a']++;
            char let2 = string2[left]; // remove the old letter
            left++;
            windowCounter[let2 - 'a']--;
            if (Arrays.equals(windowCounter, s1Counter)){ // verify if the string1 is inside the window 
            return true; 
        }
    }
        return false;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1; // pointer for minimun eating rate
        int right = 0;
        
        for (int pile : piles ){ // loop for to find the max rate of eat;
            if(pile > right){
                right = pile;
            }
        }

        int bestTime = right; // for now the best time is the max pile

        while (left <= right){
            int eatRate = left + (right - left)/2; // eat rate calculated like a binary search 
            int time = 0; 

            for(int i = 0 ; i < piles.length ; i++){
                time += Math.ceil((double) piles[i] / eatRate); // find the wasted time in each pile with the eatRate
            }
            if (time > h){
                left = eatRate + 1; // if time greater than the target, we update the left pointer
            }
            else { // if we find a time less than the target, we update the right 
                bestTime = eatRate; // continue to check other best time, because we can find a lower eatRate
                right = eatRate - 1;
            }
            
        }
        return bestTime;
    }
}

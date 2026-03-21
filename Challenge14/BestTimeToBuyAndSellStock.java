// This challenge we have an array simulating prices in different days of an stock
// I have to find the biggest profit of these numbers in a array, better time to buy
// and better time to sell.

class Solution {
    public int maxProfit(int[] prices) {
       int currentProfit = 0; // Initializing variables
       int maxProfit = 0;
       int indexMin = 0;
       for (int i = 0; i < prices.length ; i++){
            if(prices[indexMin] <= prices[i]){ // If the price of the current better price to buy is less than current prices[i]
                currentProfit = prices[i] - prices[indexMin]; // verify the current profit
                if (maxProfit >= currentProfit){ // if the maxProfit is greater than current, I continue with the max
                    continue;
                }
                else{
                    maxProfit = currentProfit; // else, I change the profit
                }
            }
            else{
                indexMin = i; // In this case, I find a better price to buy and change the index of minimal price
            }
       }
       return maxProfit;
    }
}

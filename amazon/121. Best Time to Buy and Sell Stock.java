/*
121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

/*
dp(i) is the max profit  by day i;
dp(i) =  max of dp(i-1) amd prices[i] - min(p[k])(0<=k<=i)
init dp(0) = 0 min(0) = price[0]
answer  dp(n)

since  dp(i) only relies on  dp(i-1) and the min value
so use two variable for temp result
*/

class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length <=1) {
           return 0;
       } 
       int maxProfit = 0;
       int minPrice = prices[0];
       for(int price : prices) {
           minPrice = Math.min(price,minPrice);
           maxProfit = Math.max(maxProfit, price - minPrice);
       }
        return maxProfit;
    }
}
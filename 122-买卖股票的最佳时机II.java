//执行用时 :2 ms, 在所有 Java 提交中击败了98.04%的用户
//内存消耗 :37.9 MB, 在所有 Java 提交中击败了42.04%的用户
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}
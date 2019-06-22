//执行用时 :3 ms, 在所有 Java 提交中击败了81.12%的用户
//内存消耗 :39 MB, 在所有 Java 提交中击败了33.41%的用户
class Solution {
    public int maxProfit(int[] prices) {
        int min=0x3f3f3f3f;
        int max=0;
        int profit = 0;
        int maxProfit = 0;
        for(int i:prices){
            if(i<min) {
                min=i;
                max=i;
                profit=0;
            }
            else if(i>max){
                max=i;
                profit = max - min;
                if(profit>maxProfit) maxProfit=profit;
            }
        }
        return maxProfit;
    }
}
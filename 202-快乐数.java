//执行用时 :2 ms, 在所有 Java 提交中击败了99.57%的用户
//内存消耗 :33.4 MB, 在所有 Java 提交中击败了30.92%的用户
class Solution {
    //2->4->16->37->52->29->85->89->145->42->20->4
    //3->9->81->65->61->(37)->...->4
    //5->25->(29)->...->4
    //6->36->45->41->17->50->(25)->...->4
    //7->49->97->130->10->1
    //8->64->(52)->...->4
    public boolean isHappy(int n) {
        while((n=digitSquareSum(n))!=1){
            if(n==4) return false;
        }
        return true;
    }
    private int digitSquareSum(int n){
        int res = 0;
        while(n>0){
            res+=(n%10)*(n%10);
            n/=10;
        }
        return res;
    }
}
//执行用时 :4 ms, 在所有 Java 提交中击败了99.26%的用户
//内存消耗 :33.3 MB, 在所有 Java 提交中击败了18.04%的用户
class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        while(num%2==0) num/=2;
        while(num%3==0) num/=3;
        while(num%5==0) num/=5;
        return num==1;
    }
}
//执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :33.2 MB, 在所有 Java 提交中击败了14.28%的用户
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>10) return 0;
        if(n==0) return 1;
        int res = 10;
        int tmp = 9;
        int count = 1;
        while(count!=n){
            tmp*=(10-count);
            res+=tmp;
            count++;
        }
        return res;
    }
}
//执行用时 :1 ms, 在所有 Java 提交中击败了79.61%的用户
//内存消耗 :34.3 MB, 在所有 Java 提交中击败了47.27%的用户
class Solution {
    public int integerReplacement(int n) {
        //System.out.println(n);
        if(n==1) return 0;
        if(n==3) return 2;
        if(n==Integer.MAX_VALUE) return 32;
        if(n%2==0) return integerReplacement(n/2)+1;
        else if((n>>1)%2==0) return integerReplacement(n-1)+1;
        else return integerReplacement(n+1)+1;
    }
}
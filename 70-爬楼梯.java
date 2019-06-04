//执行用时 : 1 ms, 在Climbing Stairs的Java提交中击败了60.62% 的用户

//内存消耗 : 32.9 MB, 在Climbing Stairs的Java提交中击败了73.47% 的用户

class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int p1 = 1;
        int p2 = 1;
        int res = 2;
        for(int i=3;i<=n;i++){
            p1=p2;
            p2=res;
            res = p1+p2;
        }
        return res;
    }
}
//执行用时 : 6 ms, 在Sqrt(x)的Java提交中击败了89.09% 的用户
//内存消耗 : 32.9 MB, 在Sqrt(x)的Java提交中击败了87.32% 的用户
class Solution {
    public int mySqrt(int x) {
        int tmp = 1;
        int res = 0;
        long count = 0;
        while((long)tmp*tmp<=(long)x){
            tmp<<=1;
        }
        while (tmp>0){
            tmp>>=1;
            count = (long)(res+tmp)*(res+tmp);
            if(count < x) res+=tmp;
            else if(count==x) return res+tmp;
        }
        return res;
    }
}
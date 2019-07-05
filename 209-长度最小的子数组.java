//执行用时 :1 ms, 在所有 Java 提交中击败了99.86%的用户
//内存消耗 :37.7 MB, 在所有 Java 提交中击败了94.78%的用户
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int p1=0;
        int p2=0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(p2<nums.length){
            sum+=nums[p2];
            p2++;
            while(sum>=s){
                if(p2-p1<min) min=p2-p1;
                sum-= nums[p1];
                p1++;
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        else return min;
    }
}
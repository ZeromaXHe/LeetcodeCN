class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null||nums.length == 0) return new int[]{-1,-1};
        int len = nums.length;
        int step1 = 1;
        int step2 = 1;
        while ((len>>=1)!=0) step1<<=1;
        step2 = step1;
        int p1 = step1-1;
        int p2 = step2-1;
        int res1 = -1;
        int res2 = -1;
        while(step1>0){
            step1>>=1;
            if(nums[p1]==target) res1=p1;
            if(nums[p1]>=target) p1-=step1;
            else if(p1+step1<nums.length)p1+=step1;
        }
        while(step2>0){
            step2>>=1;
            if(nums[p2]==target) res2=p2;
            if(nums[p2]>target) p2-=step2;
            else if(p2+step2<nums.length)p2+=step2;
        }
        return new int[]{res1,res2};
        
    }
}
//执行用时 : 4 ms, 在Jump Game的Java提交中击败了59.35% 的用户
//内存消耗 : 41.3 MB, 在Jump Game的Java提交中击败了73.83% 的用户
class Solution {
    public boolean canJump(int[] nums) {
        int step = 0;
        while (step != nums.length-1&& nums[step]!=0){
            if(nums[step]>=nums.length-step-1) {
                step=nums.length-1;
                break;
            }
            int max = -1;
            int maxj = -1;
            for(int j=step+1;j<nums[step]+step+1&&j<nums.length;j++){
                if(j+nums[j]>max){
                    max = j+nums[j];
                    maxj = j;
                }
            }
            step = maxj;
        }
        if(step == nums.length-1) return true;
        else return false;
    }
}
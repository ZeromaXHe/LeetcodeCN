//执行用时 : 2 ms, 在Maximum Subarray的Java提交中击败了98.79% 的用户

//内存消耗 : 37.6 MB, 在Maximum Subarray的Java提交中击败了89.66% 的用户

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            if(count>max) max = count;
            if(count<0) count=0;
        }
        return max;
    }
}
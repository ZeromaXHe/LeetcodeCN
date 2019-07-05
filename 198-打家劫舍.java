//执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :34 MB, 在所有 Java 提交中击败了89.76%的用户
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(i==1){
                nums[i]=Math.max(nums[0],nums[1]);
            }
            else {
                nums[i]=Math.max(nums[i]+nums[i-2],nums[i-1]);
            }
        }
        return nums[nums.length-1];
    }
}
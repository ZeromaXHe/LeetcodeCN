//执行用时 :1 ms, 在所有 Java 提交中击败了98.36%的用户
//内存消耗 :35.2 MB, 在所有 Java 提交中击败了80.23%的用户
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] nums2 = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[i];
        }
        nums[0]=0;
        nums2[nums2.length-1]=0;
        return Math.max(robLinear(nums),robLinear(nums2));
    }
    //参考198题
    private int robLinear(int[] nums) {
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
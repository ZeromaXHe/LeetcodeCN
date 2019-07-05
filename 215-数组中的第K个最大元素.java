//执行用时 :4 ms, 在所有 Java 提交中击败了91.47%的用户
//内存消耗 :40.8 MB, 在所有 Java 提交中击败了31.50%的用户
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hashSet.contains(i)) return i;
        }
        return nums.length+1;
    }
}
//执行用时 : 25 ms, 在Contains Duplicate的Java提交中击败了36.90% 的用户
//内存消耗 : 52.9 MB, 在Contains Duplicate的Java提交中击败了18.23% 的用户
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i:nums){
            if(hs.contains(i)) return true;
            else hs.add(i);
        }
        return false;
    }
}
//执行用时 : 7 ms, 在Contains Duplicate的Java提交中击败了94.54% 的用户
//内存消耗 : 42.3 MB, 在Contains Duplicate的Java提交中击败了92.91% 的用户
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        if(len<=1) return false;
	    for(int i=0;i<len-1;i++)
		    if(nums[i]==nums[i+1]) return true;
		return false;
    }
}
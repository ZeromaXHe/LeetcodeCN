//执行用时 : 681 ms, 在Contains Duplicate II的Java提交中击败了11.67% 的用户
//内存消耗 : 41.9 MB, 在Contains Duplicate II的Java提交中击败了95.36% 的用户

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0) return false;
        int[] window = new int[k];
        boolean[] save = new boolean[k];
        int p = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<k;j++){
                if(save[j]==true){
                    if(window[j]==nums[i]) return true;
                }
                else break;
            }
            window[p]=nums[i];
            save[p]=true;
            p=(p+1)%k;
        }
        return false;
    }
}
//执行用时 : 25 ms, 在Contains Duplicate II的Java提交中击败了56.20% 的用户
//内存消耗 : 51.6 MB, 在Contains Duplicate II的Java提交中击败了16.91% 的用户
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0) return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])!=null && i-hm.get(nums[i])<=k) return true;
            else hm.put(nums[i],i);
        }
        return false;
    }
}
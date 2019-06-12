//执行用时 :14 ms, 在所有Java提交中击败了68.32%的用户
//内存消耗 :39 MB, 在所有Java提交中击败了52.43%的用户
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        int max=0;
        int count=0;
        for(int i:hs){
            if(!hs.contains(i-1)){
                int num = i;
                count++;
                while(hs.contains(num+1)){
                    count++;
                    num++;
                }
            }
            if(count>max) max=count;
            count=0;
        }
        return max;
    }
}
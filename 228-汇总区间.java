//执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :34.7 MB, 在所有 Java 提交中击败了82.69%的用户
class Solution {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> res=new LinkedList<>();
        if(nums==null||nums.length==0) return res;
        if(nums.length==1){
            res.add(""+nums[0]);
            return res;
        }
        int temp = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[temp]+i-temp){
                if(i==temp+1) res.add(""+nums[temp]);
                else res.add(nums[temp]+"->"+nums[i-1]);
                temp=i;
            }
        }
        if(nums.length==temp+1) res.add(""+nums[temp]);
        else res.add(nums[temp]+"->"+nums[nums.length-1]);
        return res;
    }
}
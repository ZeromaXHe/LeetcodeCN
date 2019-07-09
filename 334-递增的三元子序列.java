//执行用时 :1 ms, 在所有 Java 提交中击败了99.72%的用户
//内存消耗 :38.2 MB, 在所有 Java 提交中击败了81.36%的用户
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        boolean tmp = false;
        int minTmp = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<min){
                if(min2!=Integer.MAX_VALUE){
                    if(!tmp){
                        tmp = true;
                        minTmp = nums[i];
                    }
                    else{
                        if(minTmp>=nums[i]) minTmp = nums[i];
                        else {
                            min = minTmp;
                            min2 = nums[i];
                            tmp=false;
                        }
                    }
                }
                else{
                    min = nums[i];
                }
            }else if(nums[i]>min){
                if(nums[i]>min2) return true;
                else if(nums[i]==min2) {
                    if(tmp){
                        min=minTmp;
                        tmp = false;
                    }
                }
                else{
                    if(tmp){
                        min = minTmp;
                        min2 = nums[i];
                        tmp = false;
                    }
                    else {
                        min2 = nums[i];
                    }
                }
            }
        }
        return false;
    }
}
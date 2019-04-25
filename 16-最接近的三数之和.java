import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = 0x3f3f3f3f;
        int closeToTarget = 0x3f3f3f3f;
        for(int a=0;a<nums.length-2;a++){
            if(a==0||nums[a]>nums[a-1]){
                int b=a+1;
                int c=nums.length-1;
                while(c>b){
                    int sum=nums[a]+nums[b]+nums[c]-target;
                    if(sum==0){
                        return target;
                    }
                    else if(sum>0){
                        c--;
                        if(sum<minSum){
                            minSum=sum;
                            closeToTarget = sum+target;
                        }
                    }
                    else{
                        
                        b++;
                        if(-sum<minSum){
                            minSum=-sum;
                            closeToTarget = sum+target;
                        }
                    }
                }
            }
        }
        return closeToTarget;
    }
}
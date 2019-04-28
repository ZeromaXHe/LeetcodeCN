class Solution {
    public void nextPermutation(int[] nums) {
    	if(nums.length==0||nums.length==1) return;
    	if(nums.length==2) {
    		int temp = nums[1];
    		nums[1]=nums[0];
    		nums[0]=temp;
    		return;
    	}
        
        int pos=nums.length-2;
        while(pos>0) {
        	if(nums[pos]>nums[nums.length-1]) pos--;
        	else break;
        }
        if(pos==-1){
        	Arrays.sort(nums);
        }
        else{
        	int temp=nums[nums.length-1];
        	for(int i=nums.length-1;i>pos;i--){
        		nums[i]=nums[i-1];
        	}
        	nums[pos]=temp;
        	Arrays.sort(nums,pos,nums.length);
        }
    }
}
// 1,2,3,4
// 1,2,4,3
// 1,3,2,4
// 1,3,4,2
// 1,4,2,3
// 1,4,3,2
// 2,1,3,4
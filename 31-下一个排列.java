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
        while(pos>=0) {
        	if(nums[pos]>=nums[pos+1]) pos--;
        	else break;
        }
        if(pos==-1){
        	Arrays.sort(nums);
        }
        else{
        	int temp;
            int i;
        	for(i=pos+1;i<nums.length-1;i++){
        		if(nums[i+1]<=nums[pos]){
                    temp=nums[i];
                    nums[i]=nums[pos];
                    nums[pos]=temp;
                    i=nums.length;
                    break;
                }
                
        	}
            if(i==nums.length-1){
                temp=nums[i];
                nums[i]=nums[pos];
                nums[pos]=temp;
            }
        	Arrays.sort(nums,pos+1,nums.length);
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
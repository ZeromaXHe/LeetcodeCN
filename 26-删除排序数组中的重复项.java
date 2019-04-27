class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2){
        	return nums.length;
        }
        int pos1=0;
        int pos2=0;
        while(pos1+1<nums.length){
        	if(nums[pos1]!=nums[pos1+1]){
        		nums[pos2]=nums[pos1];
        		pos2++;
        	}
        	pos1++;
        	
        }
        
        nums[pos2]=nums[pos1];
        pos2++;
        
        return pos2;
    }
}
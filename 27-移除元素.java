class Solution {
    public int removeElement(int[] nums, int val) {
        int temp;
        int p1=0;
        int p2=nums.length-1;
        while(p1<=p2){
        	if(nums[p1]==val){
        		temp=nums[p2];
        		nums[p2]=nums[p1];
        		nums[p1]=temp;
        		p2--;
        	}
        	else p1++;
        }
        
        return p1;
    }
}
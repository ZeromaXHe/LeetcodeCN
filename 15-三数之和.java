import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        if(nums.length<3) return ls;
        Arrays.sort(nums);
        for(int a=0;a<nums.length-2;a++){
        	if(a==0||nums[a]>nums[a-1]){
        		int b=a+1;
        		int c=nums.length-1;
        		while(c>b){
        			int sum=nums[a]+nums[b]+nums[c];
        			if(sum==0){
        				ls.add(Arrays.asList(nums[a], nums[b], nums[c]));
        				b++;
        				c--;
    	    			while (b<c && nums[b]==nums[b-1])b++;
        				while (b<c && nums[c]==nums[c+1])c--;//防止重复
        			}
        			else if(sum>0){
        				c--;
    	    		}
        			else{
        				b++;
        			}
        		}
       		}
        }
        
        return ls;	
    }
}
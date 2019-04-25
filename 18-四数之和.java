import java.util.*;
class Solution {
	List<List<Integer>> ls;
	int[] nums;
	int target;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        ls = new ArrayList<>();
        if(nums.length<4) return ls;
        Arrays.sort(nums);
        for(int a=0;a<nums.length-3;a++){
        	if(a==0||nums[a]>nums[a-1]){
        		for(int d=nums.length-1;d-a>2;d--){
        			if(d==nums.length-1||nums[d]<nums[d+1]){
       					bcLoop(a,d);
       				}
       			}
       		}
       	}
        
        return ls;	
    }
    private void bcLoop(int a, int d){
    	int b=a+1;
       	int c=d-1;
        while(c>b){
        	int sum=nums[a]+nums[b]+nums[c]+nums[d]-target;
        	if(sum==0){
        		ls.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
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

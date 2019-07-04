//执行用时 :2 ms, 在所有 Java 提交中击败了80.89%的用户
//内存消耗 :38.1 MB, 在所有 Java 提交中击败了33.33%的用户
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        int min = nums.length-1;
        int start = 0;
        int p = (min+start)/2;
        while(p>start){
            if(nums[p]>nums[min]){
                start=p;
                p=(min+start)/2;
            }
            else if(nums[p]<nums[min]){
                min=p;
                p=(min+start)/2;
            }
            else{
                int temp = 0;
                if((temp=leftOrRight(nums,start,p,min))<p){
                    min=p;
                    start=temp;
                    p=(min+start)/2;
                }
                else{
                    start = p;
                    p=(min+start)/2;
                }
            }
        }
        if(nums[p]<nums[min]) min = p;
        return nums[min];
    }
    
    private int leftOrRight(int[] nums, int start,int p, int end){
        for(int i=start;i<p;i++){
            if(nums[i]!=nums[p]) return i;
        }
        return p+1;
    }
}
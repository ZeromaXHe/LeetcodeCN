//执行用时 :1 ms, 在所有 Java 提交中击败了98.93%的用户
//内存消耗 :36.2 MB, 在所有 Java 提交中击败了40.66%的用户
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
            else{
                min=p;
                p=(min+start)/2;
            }
        }
        if(nums[p]<nums[min]) min = p;
        return nums[min];
    }
}
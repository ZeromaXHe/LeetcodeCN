//执行用时 :1 ms, 在所有 Java 提交中击败了99.40%的用户
//内存消耗 :39.8 MB, 在所有 Java 提交中击败了20.95%的用户
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        if(k==0) return;
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k,nums.length);
    }
    private void reverse(int[] nums, int from, int to){
        int p1=from;
        int p2=to-1;
        int temp = 0;
        while(p1<p2){
            swap(nums,p1,p2);
            p1++;
            p2--;
        }
    }
    private void swap(int[] nums, int p1,int p2){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }
}
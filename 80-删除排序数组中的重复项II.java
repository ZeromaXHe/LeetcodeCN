//执行用时 :2 ms, 在所有 Java 提交中击败了97.59%的用户
//内存消耗 :37.9 MB, 在所有 Java 提交中击败了90.08%的用户
class Solution {
    public int removeDuplicates(int[] nums) {
        int temp = 0xff3f3f3f;
        int count = 0;
        int p = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==temp){
                count++;
                if(count<=2) {
                    if(i!=p) nums[p]=nums[i];
                    p++;
                }
            }
            else{
                temp=nums[i];
                count=1;
                if(i!=p) nums[p]=nums[i];
                p++;
            }
        }
        return p;
    }
}
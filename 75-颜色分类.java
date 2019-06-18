//执行用时 :1 ms, 在所有 Java 提交中击败了96.80%的用户
//内存消耗 :34.6 MB, 在所有 Java 提交中击败了69.90%的用户
class Solution {
    public void sortColors(int[] nums) {
        int p1=0;
        int p2=nums.length-1;
        boolean flag = true;
        for(int i=0;i<=p2;i++){
            while(flag&&i<=p2){
                if(nums[i]==0){
                    nums[i]=nums[p1];
                    nums[p1]=0;
                    p1++;
                    flag=false;
                }
                else if(nums[i]==2){
                    nums[i]=nums[p2];
                    nums[p2]=2;
                    p2--;
                }
                else flag=false;
            }
            flag=true;
        }
    }
}
//91/92测试用例超时。复杂度O（n^2）解法
class Solution {
    public int jump(int[] nums) {
        int[] des = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=nums.length-i-1) {
                des[i]=nums.length-1;
                continue;
            }
            int max = -1;
            int maxj = -1;
            for(int j=i+1;j<nums[i]+i+1&&j<nums.length;j++){
                if(j+nums[j]>max){
                    max = j+nums[j];
                    maxj = j;
                }
            }
            des[i] = maxj;
        }
        int count = 0;
        int step = 0;
        while (step != nums.length-1){
            step = des[step];
            count++;
        }
        return count;
    }
}
//执行用时 : 5 ms, 在Jump Game II的Java提交中击败了50.87% 的用户
//内存消耗 : 41.3 MB, 在Jump Game II的Java提交中击败了72.27% 的用户
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int step = 0;
        while (step != nums.length-1){
            if(nums[step]>=nums.length-step-1) {
                step=nums.length-1;
                count++;
                break;
            }
            int max = -1;
            int maxj = -1;
            for(int j=step+1;j<nums[step]+step+1&&j<nums.length;j++){
                if(j+nums[j]>max){
                    max = j+nums[j];
                    maxj = j;
                }
            }
            step = maxj;
            count++;
        }
        return count;
    }
}
//执行用时 :2 ms, 在所有Java提交中击败了88.29%的用户
//内存消耗 :47.1 MB, 在所有Java提交中击败了61.35%的用户
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return nums.length*(nums.length+1)/2-sum;
    }
}

//执行用时 :2 ms, 在所有Java提交中击败了88.29%的用户
//内存消耗 :37.3 MB, 在所有Java提交中击败了99.75%的用户

class Solution {
    public int missingNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i]^(i+1);
        }
        return res;
    }
}



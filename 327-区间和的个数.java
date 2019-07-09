//执行用时 :166 ms, 在所有 Java 提交中击败了46.51%的用户
//内存消耗 :38.5 MB, 在所有 Java 提交中击败了96.88%的用户
class Solution {
    private long[] numArr;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        formNumArr(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                long sum = sumRange(i,j);
                if(sum>=lower&&sum<=upper){
                    count++;
                }
            }
        }
        return count;
    }
    private void formNumArr(int[] nums) {
        numArr=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) numArr[0]=nums[0];
            else numArr[i]=numArr[i-1]+nums[i];
        }
    }
    
    private long sumRange(int i, int j) {
        if(i==0) return numArr[j];
        else return numArr[j]-numArr[i-1];
    }
}
//执行用时 :126 ms, 在所有 Java 提交中击败了34.36%的用户
//内存消耗 :45.4 MB, 在所有 Java 提交中击败了64.34%的用户
class NumArray {
    private int[] numArr;

    public NumArray(int[] nums) {
        numArr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) numArr[0]=nums[0];
            else numArr[i]=numArr[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return numArr[j];
        else return numArr[j]-numArr[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
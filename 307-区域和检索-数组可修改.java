//执行用时 :200 ms, 在所有 Java 提交中击败了51.78%的用户
//内存消耗 :48.3 MB, 在所有 Java 提交中击败了90.98%的用户
class NumArray {
    private int[] numArr;
    
    public NumArray(int[] nums) {
        numArr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) numArr[0]=nums[0];
            else numArr[i]=numArr[i-1]+nums[i];
        }
    }
    
    public void update(int i, int val) {
        int offset = 0;
        if(i==0) offset = val - numArr[0];
        else offset = val - numArr[i] + numArr[i-1];
        for(int x = i; x<numArr.length;x++){
            numArr[x]+=offset;
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
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
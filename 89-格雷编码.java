//执行用时 :1 ms, 在所有 Java 提交中击败了99.51%的用户
//内存消耗 :33.6 MB, 在所有 Java 提交中击败了53.75%的用户
class Solution {
    public List<Integer> grayCode(int n) {
        int[] nums = new int[1<<n];
        List<Integer> res = new LinkedList<>();
        int p=1;
        for(int i=0;i<n;i++){
            for(int j=(1<<i)-1;j>=0;j--){
                nums[p]=(1<<i)+nums[j];
                p++;
            }
        }
        for(int i:nums) res.add(i);
        return res;
    }
}
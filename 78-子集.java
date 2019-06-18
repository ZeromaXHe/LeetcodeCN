//执行用时 :2 ms, 在所有 Java 提交中击败了92.64%的用户
//内存消耗 :36.3 MB, 在所有 Java 提交中击败了56.03%的用户
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> list = new LinkedList<>();
            int count = 0;
            int rem = i;
            while(rem!=0){
                if(rem%2==1) list.add(nums[count]);
                rem/=2;
                count++;
            }
            res.add(list);
        }
        return res;
    }
}
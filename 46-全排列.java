//执行用时 :4 ms, 在所有Java提交中击败了70.55%的用户
//内存消耗 :36.9 MB, 在所有Java提交中击败了93.84%的用户
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 1) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            res.add(resList);
            return res;
        } else if (nums.length == 2) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            resList.add(nums[1]);
            res.add(resList);
            List<Integer> resList2 = new LinkedList<>();//这里如果不new一个新的，而在原来resList上操作的话，会导致添加进res里的结果也被改变。原因是链表传递的是引用
            resList2.add(nums[1]);
            resList2.add(nums[0]);
            res.add(resList2);
            return res;
        } else {
            List<List<Integer>> formerRes = permute(Arrays.copyOfRange(nums, 1, nums.length));
            for (List<Integer> formerList : formerRes) {
                for (int i = 0; i <= nums.length - 1; i++) {
                    List<Integer> newList = new LinkedList<>(formerList);
                    newList.add(i, nums[0]);
                    res.add(newList);
                }
            }
            return res;
        }
    }
}
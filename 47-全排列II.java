//执行用时 :28 ms, 在所有Java提交中击败了36.80%的用户
//内存消耗 :46.5 MB, 在所有Java提交中击败了38.99%的用户
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 1) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            res.add(resList);
            return new LinkedList<>(res);
        } else if (nums.length == 2) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            resList.add(nums[1]);
            res.add(resList);
            if (nums[0] != nums[1]) {
                List<Integer> resList2 = new LinkedList<>();
                resList2.add(nums[1]);
                resList2.add(nums[0]);
                res.add(resList2);
            }
            return new LinkedList<>(res);
        } else {
            List<List<Integer>> formerRes = permuteUnique(Arrays.copyOfRange(nums, 1, nums.length));
            for (List<Integer> formerList : formerRes) {
                for (int i = 0; i <= nums.length - 1; i++) {
                    List<Integer> newList = new LinkedList<>(formerList);
                    newList.add(i, nums[0]);
                    res.add(newList);
                }
            }
            return new LinkedList<>(res);
        }
    }
}
//执行用时 :33 ms, 在所有Java提交中击败了36.33%的用户
//内存消耗 :44.8 MB, 在所有Java提交中击败了54.13%的用户
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 1) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            res.add(resList);
            return new LinkedList<>(res);
        } else if (nums.length == 2) {
            List<Integer> resList = new LinkedList<>();
            resList.add(nums[0]);
            resList.add(nums[1]);
            res.add(resList);
            if (nums[0] != nums[1]) {
                List<Integer> resList2 = new LinkedList<>();
                resList2.add(nums[1]);
                resList2.add(nums[0]);
                res.add(resList2);
            }
            return new LinkedList<>(res);
        } else {
            Arrays.sort(nums);
            int count = 0;
            while (count + 1 < nums.length && nums[count + 1] == nums[0]) count++;
            if (count + 1 >= nums.length) {
                List<Integer> newList = new LinkedList<>();
                for (int i : nums) {
                    newList.add(i);
                }
                res.add(newList);
            } else {
                List<List<Integer>> formerRes = permuteUnique(Arrays.copyOfRange(nums, count + 1, nums.length));
                for(int j=0;j<=count;j++) {
                    res = new HashSet<>();
                    for (List<Integer> formerList : formerRes) {
                        for (int i = 0; i <= nums.length - 1- count + j; i++) {
                            if (i == 0 || formerList.get(i - 1) != nums[0]) {
                                List<Integer> newList = new LinkedList<>(formerList);
                                newList.add(i, nums[0]);
                                res.add(newList);
                            }
                        }
                    }
                    formerRes=new LinkedList<>(res);
                }
            }
            return new LinkedList<>(res);
        }
    }
}
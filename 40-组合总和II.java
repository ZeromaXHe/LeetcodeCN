//执行用时 : 19 ms, 在Combination Sum II的Java提交中击败了50.69% 的用户
//内存消耗 : 39.9 MB, 在Combination Sum II的Java提交中击败了75.52% 的用户
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(int[] candidates, int target, HashSet<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < candidates[start]) break;
            else{
                tmp_list.add(candidates[start]);
                backtrack(candidates, target - candidates[start], res, start+1, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
            }
        }
    }
}
//执行用时 : 4 ms, 在Combination Sum II的Java提交中击败了98.93% 的用户
//内存消耗 : 35.5 MB, 在Combination Sum II的Java提交中击败了99.74% 的用户
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if(start>i && candidates[start-1]==candidates[start] ) continue;
            if (target < candidates[start]) break;
            else{
                tmp_list.add(candidates[start]);
                backtrack(candidates, target - candidates[start], res, start+1, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
            }
        }
    }
}
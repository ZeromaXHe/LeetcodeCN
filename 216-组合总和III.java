//执行用时 :3 ms, 在所有 Java 提交中击败了23.34%的用户
//内存消耗 :34.6 MB, 在所有 Java 提交中击败了28.52%的用户
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        return combinationSum2Modded(candidates,n,k);
    }
    
    //参考40. 组合总和 II
    private List<List<Integer>> combinationSum2Modded(int[] candidates, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, k, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int k, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            if(tmp_list.size()==k) res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if(start>i && candidates[start-1]==candidates[start] ) continue;
            if (target < candidates[start]) break;
            else{
                tmp_list.add(candidates[start]);
                backtrack(candidates, target - candidates[start], k, res, start+1, tmp_list);
                tmp_list.remove(tmp_list.size() - 1);
            }
        }
    }
}
//执行用时 :68 ms, 在所有 Java 提交中击败了39.81%的用户
//内存消耗 :41.9 MB, 在所有 Java 提交中击败了85.64%的用户
class Solution {
    List<List<Integer>> res;
    int k = 0;
    int n = 0;
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        if(k<=0) return res;
        this.k = k;
        this.n = n;
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(0,list);
        return res;
    }
    private void backtrack(int i,LinkedList<Integer> list){
        if(list.size()==k) res.add(new LinkedList<>(list));
        else{
            for(int j=i;j<n;j++){
                list.add(j+1);
                backtrack(j+1,list);
                list.removeLast();
            }
        }
    }
}
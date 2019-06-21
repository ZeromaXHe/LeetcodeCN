//执行用时 :1 ms, 在所有 Java 提交中击败了99.36%的用户
//内存消耗 :33 MB, 在所有 Java 提交中击败了60.38%的用户
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex+1];
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.fill(res,1);
        for(int i=rowIndex;i>0;i--){
            for(int j = 1;j<i;j++){
                res[j]+=res[j-1];
            }
        }
        for(int i:res){
            list.add(i);
        }
        return list;
    }
}
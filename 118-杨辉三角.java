//执行用时 :2 ms, 在所有 Java 提交中击败了28.69%的用户
//内存消耗 :33.6 MB, 在所有 Java 提交中击败了41.66%的用户
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0;i<numRows;i++){
            LinkedList<Integer> list = new LinkedList<>();
            //System.out.println("i-1:"+(i-1)+",i/2-1:"+(i/2-1)+",i/2:"+(i/2));
            if(i>1 && i%2==0) list.add(res.get(i-1).get(i/2-1)+res.get(i-1).get(i/2));
            for(int j=(i-1)/2;j>0;j--){
                int sum = res.get(i-1).get(j-1)+res.get(i-1).get(j);
                list.addFirst(sum);
                list.add(sum);
            }
            list.addFirst(1);
            if(i!=0)list.add(1);
            //System.out.println(list);
            res.add(list);
        }
        return res;
    }
}
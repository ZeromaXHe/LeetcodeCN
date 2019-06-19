//执行用时 :19 ms, 在所有 Java 提交中击败了16.90%的用户
//内存消耗 :38.6 MB, 在所有 Java 提交中击败了47.42%的用户
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        //Arrays.sort(nums); 在这里排序，下面就不用每次都排了。可以提升一丁点效率
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> list = new LinkedList<>();
            int count = 0;
            int rem = i;
            while(rem!=0){
                if(rem%2==1) list.add(nums[count]);
                rem/=2;
                count++;
            }
            Collections.sort(list);//这里可以删掉改成上面注释的地方排序。
            //改完之后：
            //执行用时 :11 ms, 在所有 Java 提交中击败了25.81%的用户
            //内存消耗 :37.9 MB, 在所有 Java 提交中击败了61.43%的用户
            res.add(list);
        }
        return new LinkedList<>(res);
    }
}
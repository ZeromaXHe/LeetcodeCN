//执行用时 : 100 ms, 在Brick Wall的Java提交中击败了16.22% 的用户
//内存消耗 : 50.4 MB, 在Brick Wall的Java提交中击败了76.00% 的用户
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall==null||wall.size()==0)return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int wallRow = wall.size();
        int col = 0;
        Iterator<List<Integer>> iterator = wall.iterator();
        while (iterator.hasNext()){
            List<Integer> list = iterator.next();
            Iterator<Integer> iterator1 = list.iterator();
            while(iterator1.hasNext()){
                col+=iterator1.next();
                if(iterator1.hasNext()) hashMap.merge(col,1,Integer::sum);
            }
            col=0;
        }
        int maxCount = 0;

        for(int i:hashMap.values()){
            if(i>maxCount) maxCount=i;
        }
        return wallRow-maxCount;
    }

}
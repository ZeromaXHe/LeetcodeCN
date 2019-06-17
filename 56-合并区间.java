//执行用时 :6 ms, 在所有Java提交中击败了97.79%的用户
//内存消耗 :40.8 MB, 在所有Java提交中击败了83.92%的用户
class Solution {
    public int[][] merge(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[][] res = new int[intervals.length][2];
        int count=0;
        int ps=0;
        int pe=1;
        while(pe<end.length){
            while(start[pe]<=end[pe-1]){
                pe++;
                if(pe>=end.length) break;
            }
            res[count][0]=start[ps];
            res[count][1]=end[pe-1];
            count++;
            ps=pe;
            pe++;
        }
        if(pe == end.length){
            res[count][0]=start[ps];
            res[count][1]=end[pe-1];
            count++;
        }
        int[][] result = new int[count][2];
        for(int i =0;i<count;i++){
            result[i][0] = res[i][0];
            result[i][1] = res[i][1];
        }
        return result;
    }
}
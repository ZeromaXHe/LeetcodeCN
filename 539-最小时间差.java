//执行用时 :46 ms, 在所有Java提交中击败了50.35%的用户
//内存消耗 :44.8 MB, 在所有Java提交中击败了40.00%的用户
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        int num=0;
        for(String s: timePoints){
            String[] strs=s.split(":");
            time[num]=60*Integer.parseInt(strs[0])+Integer.parseInt(strs[1]);
            num++;
        }
        Arrays.sort(time);
        int min=24*60-time[time.length-1]+time[0];
        for(int i = 0;i<time.length-1;i++){
            if(time[i+1]-time[i]<min) min=time[i+1]-time[i];
        }
        return min;
    }
}
//执行用时 :11 ms, 在所有Java提交中击败了94.33%的用户
//内存消耗 :36.1 MB, 在所有Java提交中击败了100.00%的用户
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        int num=0;
        for(String s: timePoints){
            time[num]=60*((s.charAt(0)-'0')*10+s.charAt(1)-'0')+(s.charAt(3)-'0')*10+s.charAt(4)-'0';
            num++;
        }
        Arrays.sort(time);
        int min=24*60-time[time.length-1]+time[0];
        for(int i = 0;i<time.length-1;i++){
            if(time[i+1]-time[i]<min) min=time[i+1]-time[i];
        }
        return min;
    }
}
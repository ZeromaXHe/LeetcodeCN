//执行用时 :220 ms, 在所有 Java 提交中击败了10.29%的用户
//内存消耗 :37.6 MB, 在所有 Java 提交中击败了52.93%的用户
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            if(canComplete(i,gas,cost)) return i;
        }
        return -1;
    }
    private boolean canComplete(int i, int[] gas, int[] cost){
        int gasInTank = gas[i]-cost[i];
        if(gasInTank<0) return false;
        int now = (i+1)%gas.length;
        while(now!=i){
            gasInTank+=gas[now]-cost[now];
            if(gasInTank<0) return false;
            now = (now+1)%gas.length;
        }
        return true;
    }
}
//执行用时 :1 ms, 在所有 Java 提交中击败了98.63%的用户
//内存消耗 :38.1 MB, 在所有 Java 提交中击败了43.36%的用户
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int k=canComplete(i,gas,cost);
            if(k==-1) return i;
            else if(k<i) return -1;
            else i=k;
        }
        return -1;
    }
    private int canComplete(int i, int[] gas, int[] cost){
        int gasInTank = gas[i]-cost[i];
        if(gasInTank<0) return i;//失败则返回最终到达的地点
        int now = (i+1)%gas.length;
        while(now!=i){
            gasInTank+=gas[now]-cost[now];
            if(gasInTank<0) return now;//失败则返回最终到达的地点
            now = (now+1)%gas.length;
        }
        return -1;//-1表示可以到达
    }
}
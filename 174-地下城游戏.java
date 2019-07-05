//执行用时 :2 ms, 在所有 Java 提交中击败了98.35%的用户
//内存消耗 :39.4 MB, 在所有 Java 提交中击败了41.73%的用户
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        for(int i=dungeon.length-1;i>=0;i--){
            for(int j=dungeon[0].length-1;j>=0;j--){
                if(i==dungeon.length-1){
                    if(j!=dungeon[0].length-1) dungeon[i][j]+=dungeon[i][j+1];
                }
                else{
                    if(j==dungeon[0].length-1) dungeon[i][j]+=dungeon[i+1][j];
                    else dungeon[i][j] += Math.max(dungeon[i+1][j],dungeon[i][j+1]);
                }
                if(dungeon[i][j]>0) dungeon[i][j]=0;
            }
        }
        return 1-dungeon[0][0];
    }
}
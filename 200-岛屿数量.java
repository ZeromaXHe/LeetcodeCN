//执行用时 :4 ms, 在所有 Java 提交中击败了66.83%的用户
//内存消耗 :42.9 MB, 在所有 Java 提交中击败了44.91%的用户
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1') {
                    //System.out.println("["+i+","+j+"]");
                    change1to0(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void change1to0(int i,int j,char[][] board){
        board[i][j]='0';
        if(i-1>=0 && board[i-1][j]=='1') change1to0(i-1,j,board);
        if(i+1<board.length && board[i+1][j]=='1') change1to0(i+1,j,board);
        if(j-1>=0 && board[i][j-1]=='1') change1to0(i,j-1,board);
        if(j+1<board[0].length && board[i][j+1]=='1') change1to0(i,j+1,board);
    }
}
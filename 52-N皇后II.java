//执行用时 :6 ms, 在所有Java提交中击败了43.76%的用户
//内存消耗 :33.3 MB, 在所有Java提交中击败了54.69%的用户
class Solution {
    boolean[][] chessboard;
    int count = 0;
    public int totalNQueens(int n) {
        chessboard = new boolean[n][n];
        placeQueen(0);
        return count;
    }
    private boolean isLegal(int x, int y){
        int n=chessboard.length;
        for(int i=1;i<=x&&y>=i;i++){
            if(chessboard[x-i][y-i]) return false;
        }
        for(int i=1;i<=x&&n-y>i;i++){
            if(chessboard[x-i][y+i]) return false;
        }
        for(int i=0;i<x;i++){
            if(chessboard[i][y]) return false;
        }
        return true;
    }
    private void placeQueen(int x){
        int n = chessboard.length;
        for(int i=0;i<n;i++){
            if(isLegal(x,i)) {
                if(x<n-1){
                    chessboard[x][i]=true;
                    placeQueen(x+1);
                    chessboard[x][i]=false;  
                } 
                else {
                    count++;
                }
            }
        }
    }
}
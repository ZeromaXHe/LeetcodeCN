//执行用时 :2 ms, 在所有 Java 提交中击败了16.40%的用户
//内存消耗 :35.3 MB, 在所有 Java 提交中击败了54.82%的用户
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] nextBoard = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                nextBoard[i][j] = next(board[i][j],countLife(board,i,j));
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j]=nextBoard[i][j];
            }
        }
    }
    
    private int countLife(int[][] board, int i, int j){
        int[][] k = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int count = 0;
        for(int[] m : k){
            if(wrapBoard(board,i+m[0],j+m[1])==1) count++;
        }
        return count;
    }
    
    private int next(int now ,int life){
        if(now==1){
            if(life<2||life>3) return 0;
            else return 1;
        }
        else{
            if(life==3) return 1;
            else return 0;
        }
    }
    
    private int wrapBoard(int[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length) return 0;
        else return board[i][j];
    }
}
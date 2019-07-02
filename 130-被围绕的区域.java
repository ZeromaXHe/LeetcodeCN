//执行用时 :4 ms, 在所有 Java 提交中击败了76.68%的用户
//内存消耗 :48.5 MB, 在所有 Java 提交中击败了47.86%的用户
class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O') changeOtoK(i,0,board);
            if(board[i][board[0].length-1]=='O') changeOtoK(i,board[0].length-1,board);
        }
        for(int j=1;j<board[0].length-1;j++){
            if(board[0][j]=='O') changeOtoK(0,j,board);
            if(board[board.length-1][j]=='O') changeOtoK(board.length-1,j,board);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='K') board[i][j]='O';
            }
        }
    }
    private void changeOtoK(int i,int j,char[][] board){
        board[i][j]='K';
        if(i-1>=0 && board[i-1][j]=='O') changeOtoK(i-1,j,board);
        if(i+1<board.length && board[i+1][j]=='O') changeOtoK(i+1,j,board);
        if(j-1>=0 && board[i][j-1]=='O') changeOtoK(i,j-1,board);
        if(j+1<board[0].length && board[i][j+1]=='O') changeOtoK(i,j+1,board);
    }
}
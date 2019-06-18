//执行用时 :11 ms, 在所有 Java 提交中击败了82.31%的用户
//内存消耗 :44.2 MB, 在所有 Java 提交中击败了79.79%的用户
class Solution {
    int xMax = 0;
    int yMax = 0;
    String word;
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        if(board==null||board.length==0||board[0].length==0)return false;
        xMax = board.length;
        yMax = board[0].length;
        this.word = word;
        for(int x = 0; x<xMax;x++){
            for(int y=0;y<yMax;y++){
                if(backtrack(0,x,y,board)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(int i,int x,int y,char[][] board){
        if(board[x][y]!=word.charAt(i)) return false;
        board[x][y]='#';
        i++;
        if(i==word.length()) return true;
        if(x-1>=0 && backtrack(i,x-1,y,board)) return true;
        if(x+1<xMax && backtrack(i,x+1,y,board)) return true;
        if(y-1>=0 && backtrack(i,x,y-1,board)) return true;
        if(y+1<yMax && backtrack(i,x,y+1,board)) return true;
        board[x][y]=word.charAt(i-1);
        return false;
    }
}
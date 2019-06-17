//执行用时 :17 ms, 在所有Java提交中击败了28.56%的用户
//内存消耗 :36.4 MB, 在所有Java提交中击败了100.00%的用户
class Solution {
    boolean[][] chessboard;
    int[] yForX;
    List<String> resList;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        chessboard = new boolean[n][n];
        yForX = new int[n];
        res = new LinkedList<>();
        placeQueen(0);
        return res;
    }
    private boolean isLegal(int x, int y){
        int n=yForX.length;
        for(int i=1;i<=x&&y>=i;i++){
            if(chessboard[x-i][y-i]) return false;
        }
        for(int i=1;i<n-x&&n-y>i;i++){
            if(chessboard[x+i][y+i]) return false;
        }
        for(int i=1;i<=x&&n-y>i;i++){
            if(chessboard[x-i][y+i]) return false;
        }
        for(int i=1;i<n-x&&y>=i;i++){
            if(chessboard[x+i][y-i]) return false;
        }
        for(int i=0;i<n;i++){
            if(i==y) continue;
            if(chessboard[x][i]) return false;
        }
        for(int i=0;i<n;i++){
            if(i==x) continue;
            if(chessboard[i][y]) return false;
        }
        return true;
    }
    private void placeQueen(int x){
        int n = yForX.length;
        for(int i=0;i<n;i++){
            if(isLegal(x,i)) {
                yForX[x]=i;
                if(x<n-1){
                    chessboard[x][i]=true;
                    placeQueen(x+1);
                    chessboard[x][i]=false;  
                } 
                else {
                    recordChessboard();
                }
            }
        }
    }
    private void recordChessboard(){
        int n =yForX.length;
        StringBuilder sb = new StringBuilder();
        resList = new LinkedList<>();
        for(int i=0;i<n;i++){
            sb.delete( 0, sb.length() );
            for(int j=0;j<n;j++){
                if(j==yForX[i]) sb.append("Q");
                else sb.append(".");
            }
            resList.add(sb.toString());
        }
        res.add(resList);
    }
    
}
//执行用时 :6 ms, 在所有Java提交中击败了87.44%的用户
//内存消耗 :37.5 MB, 在所有Java提交中击败了99.27%的用户

//根据placeQueen是一行一行进行的特点，isLegal只需要检查斜上方和正上方是否有皇后就可以了。
//修改isLegal方法获得性能提升:
    private boolean isLegal(int x, int y){
        int n=yForX.length;
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
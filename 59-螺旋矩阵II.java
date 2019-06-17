//执行用时 :1 ms, 在所有Java提交中击败了54.58%的用户
//内存消耗 :34 MB, 在所有Java提交中击败了68.18%的用户

class Solution {
    int[][] visit;
    int count=1;
    int x=0;
    int y=0;
    int dir = 0;
    public int[][] generateMatrix(int n) {
        visit = new int[n][n];
        traverse(visit);
        return visit;
    }
    private boolean canNextPos(){
        switch(dir){
            case 0:
                if(y+1<visit[0].length&&visit[x][y+1]==0) return true;
                else return false;
            case 1:
                if(x+1<visit.length&&visit[x+1][y]==0) return true;
                else return false;
            case 2:
                if(y-1>=0 && visit[x][y-1]==0) return true;
                else return false;
            case 3:
                if(x-1>=0 && visit[x-1][y]==0) return true;
                else return false;
            default:return false;
        }
    }
    
    private void traverse(int[][] matrix){
        int temp=dir;
        matrix[x][y]=count;
        while(!canNextPos()){
            dir=(dir+1)%4;
            if(dir==temp) return;
        }
        count++;
        switch(dir){
            case 0:y++;break;
            case 1:x++;break;
            case 2:y--;break;
            case 3:x--;break;
            default:break;
        }
        traverse(matrix);
    }
}
//执行用时 :1 ms, 在所有Java提交中击败了92.37%的用户
//内存消耗 :34.9 MB, 在所有Java提交中击败了45.31%的用户
class Solution {
    boolean[][] visit;
    int x=0;
    int y=0;
    int dir = 0;
    List<Integer> res;
    public List<Integer> spiralOrder(int[][] matrix) {
        res = new LinkedList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        visit = new boolean[matrix.length][matrix[0].length];
        traverse(matrix);
        return res;
    }
    
    private boolean canNextPos(){
        switch(dir){
            case 0:
                if(y+1<visit[0].length&&!visit[x][y+1]) return true;
                else return false;
            case 1:
                if(x+1<visit.length&&!visit[x+1][y]) return true;
                else return false;
            case 2:
                if(y-1>=0 && !visit[x][y-1]) return true;
                else return false;
            case 3:
                if(x-1>=0 && !visit[x-1][y]) return true;
                else return false;
            default:return false;
        }
    }
    
    private void traverse(int[][] matrix){
        int temp=dir;
        res.add(matrix[x][y]);
        while(!canNextPos()){
            dir=(dir+1)%4;
            if(dir==temp) return;
        }
        visit[x][y]=true;
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
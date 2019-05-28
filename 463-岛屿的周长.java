class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int preH = 0;
        int preV = 0;
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!=preH){
                    preH = grid[i][j];
                    count++;
                }
            }
            if(grid[i][grid[0].length-1]==1) count++;
            preH=0;
        }
        
        for(int i=0;i<grid[0].length;i++){
            for(int j = 0;j<grid.length;j++){
                if(grid[j][i]!=preV){
                    preV = grid[j][i];
                    count++;
                }
            }
            if(grid[grid.length-1][i]==1) count++;
            preV=0;
        }
        return count;
    }
}
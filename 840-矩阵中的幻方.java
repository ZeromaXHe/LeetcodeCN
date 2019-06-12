//执行用时 :1 ms, 在所有Java提交中击败了100.00%的用户

//内存消耗 :33.3 MB, 在所有Java提交中击败了100.00%的用户

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int[] arr = new int[10];
        for(int i=1;i<grid.length-1;i++){
            loop:
            for(int j=1;j<grid[i].length-1;j++){
                if(grid[i][j]==5 
                   && grid[i-1][j-1]+grid[i+1][j-1]+grid[i][j-1] == 15 
                   && grid[i+1][j+1]+grid[i][j+1]+grid[i-1][j+1] == 15 
                   && grid[i-1][j]+grid[i][j]+grid[i+1][j] == 15
                   && grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1] == 15
                   && grid[i][j-1]+grid[i][j]+grid[i][j+1] == 15 
                   && grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1] == 15 
                   && grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1] == 15 
                   && grid[i+1][j-1]+grid[i][j]+grid[i-1][j+1] == 15 
                   && grid[i-1][j-1] < 10 && grid[i-1][j-1] > 0 
                   && grid[i][j-1] < 10 && grid[i][j-1] > 0 
                   && grid[i+1][j-1] < 10 && grid[i+1][j-1] > 0 
                   && grid[i-1][j] < 10 && grid[i-1][j] > 0 
                   && grid[i-1][j+1] < 10 && grid[i-1][j+1] > 0 
                   && grid[i][j+1] < 10 && grid[i][j+1] > 0 
                   && grid[i+1][j] < 10 && grid[i+1][j] > 0 
                   && grid[i+1][j+1] < 10 && grid[i+1][j+1] > 0){
                    Arrays.fill(arr,0);
                    arr[5]++;
                    arr[grid[i-1][j-1]]++;
                    arr[grid[i-1][j]]++;
                    arr[grid[i-1][j+1]]++;
                    arr[grid[i][j-1]]++;
                    arr[grid[i][j+1]]++;
                    arr[grid[i+1][j-1]]++;
                    arr[grid[i+1][j]]++;
                    arr[grid[i+1][j+1]]++;
                    for(int k=1;k<10;k++){
                        if(arr[k]!=1) continue loop;
                    }
                    count++;
                }
                   
            }
        }
        
        return count;
    }
}
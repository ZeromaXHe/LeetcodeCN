//执行用时 :2 ms, 在所有 Java 提交中击败了49.85%的用户
//内存消耗 :38.4 MB, 在所有 Java 提交中击败了91.03%的用户
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int x = 0;
        int y = matrix[0].length-1;
        while(x<matrix.length&&y>=0){
            if(target==matrix[x][y]) return true;
            else if(target<matrix[x][y]) y--;
            else x++;
        }
        return false;
    }
}
//执行用时 :1 ms, 在所有 Java 提交中击败了99.41%的用户
//内存消耗 :38.8 MB, 在所有 Java 提交中击败了86.70%的用户
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int x=0;
        for(; x<matrix.length-1;x++){
            if(matrix[x][0] == target) return true;
            if(matrix[x][0]<target && matrix[x+1][0]>target) break;
            if(matrix[x][0] > target) return false;
        }
        if(Arrays.binarySearch(matrix[x],target)>=0) return true;
        else return false;
    }
}


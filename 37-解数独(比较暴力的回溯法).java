//执行用时 : 21 ms, 在Sudoku Solver的Java提交中击败了28.38% 的用户
//
//内存消耗 : 34.6 MB, 在Sudoku Solver的Java提交中击败了84.81% 的用户

class Solution{
	boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    int[] possible = {0,1,2,3,4,5,6,7,8};
    int count = 0;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                row[i][num] = col[j][num] = box[i / 3 * 3 + j / 3][num] = true;
                count++;
            }
        }
        solveSudokuAttempt(board);
    }

    private boolean solveSudokuAttempt(char[][] board) {
        if(count==81) return true;
        int x=0;
        int y=0;
        loop:
        for (x = 0; x < 9; x++) {
            for (y = 0; y < 9; y++) {
                if (board[x][y] == '.') break loop;
            }
        }
        if(x==9||y==9) return false;
        for (int integ : possible) {
            int num = integ;
            boolean rowbackup = row[x][num];
            boolean colbackup = col[y][num];
            boolean boxbackup = box[x / 3 * 3 + y / 3][num];
            if(rowbackup|colbackup|boxbackup) continue;
            board[x][y] = (char) (num + '1');
            count++;
            row[x][num] = col[y][num] = box[x / 3 * 3 + y / 3][num] = true;
            if (solveSudokuAttempt(board)) return true;
            else {
                count--;
                board[x][y] = '.';
                row[x][num] = rowbackup;
                col[y][num] = colbackup;
                box[x / 3 * 3 + y / 3][num] = boxbackup;
            }
        }
        return false;
    }
}
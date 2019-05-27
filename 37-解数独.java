class Solution{
	boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    HashSet<Integer>[][] possible = new HashSet[9][9];
    int count = 0;

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                possible[i][j] = new HashSet<Integer>();
                Collections.addAll(possible[i][j], 0, 1, 2, 3, 4, 5, 6, 7, 8);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';

                row[i][num] = col[j][num] = box[i / 3 * 3 + j / 3][num] = true;

                for (int k = 0; k < 9; k++) {
                    possible[i][k].remove(num);
                    possible[k][j].remove(num);
                }
                for (int k1 = i - i % 3; k1 < i - i % 3 + 3; k1++) {
                    for (int k2 = j - j % 3; k2 < j - j % 3 + 3; k2++) {
                        possible[k1][k2].remove(num);
                    }
                }
                count++;
                possible[i][j].clear();
            }
        }
        solveSudokuDefinite(board);
    }

    private boolean solveSudokuDefinite(char[][] board) {
        while (count < 81) {
            int check = count;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (possible[i][j].size() == 1 && board[i][j] == '.') {
                        int num = -1;
                        for (int integ : possible[i][j]) num = integ;

                        row[i][num] = col[j][num] = box[i / 3 * 3 + j / 3][num] = true;

                        board[i][j] = (char) (num + '1');
                        for (int k = 0; k < 9; k++) {
                            possible[i][k].remove(num);
                            possible[k][j].remove(num);
                        }
                        for (int k1 = i - i % 3; k1 < i - i % 3 + 3; k1++) {
                            for (int k2 = j - j % 3; k2 < j - j % 3 + 3; k2++) {
                                possible[k1][k2].remove(num);
                            }
                        }
                        count++;
                        possible[i][j].clear();
                    }
                }
            }

//            System.out.println("============== count:"+count+"==================");
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
            if (check == count) {
                /*boolean attempt = */solveSudokuAttempt(board);
//                if(attempt) System.out.println("回溯法成功");
//                else {
//                    System.out.println("回溯法失败");
//                }
                break;
            }

        }
        return true;
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
        for (int integ : possible[x][y]) {
            int num = integ;
            boolean rowbackup = row[x][num];
            boolean colbackup = col[y][num];
            boolean boxbackup = box[x / 3 * 3 + y / 3][num];
            if(rowbackup|colbackup|boxbackup) continue;
            board[x][y] = (char) (num + '1');
            count++;
            row[x][num] = col[y][num] = box[x / 3 * 3 + y / 3][num] = true;
//            System.out.println("------------------[||] ATTEMPT count:"+count+"[||]---------------------");
//            for (int i1 = 0; i1 < 9; i1++) {
//                for (int j1 = 0; j1 < 9; j1++) {
//                    System.out.print(board[i1][j1] + " ");
//                }
//                System.out.println();
//            }
            if (solveSudokuAttempt(board)) return true;
            else {
                count--;
                board[x][y] = '.';
                row[x][num] = rowbackup;
                col[y][num] = colbackup;
                box[x / 3 * 3 + y / 3][num] = boxbackup;
            }
        }
        //System.out.println("失败的尝试！！！！");
        return false;
    }
}
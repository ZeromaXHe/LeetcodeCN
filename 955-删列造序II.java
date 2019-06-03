//执行用时 : 34 ms, 在Delete Columns to Make Sorted II的Java提交中击败了11.36% 的用户
//内存消耗 : 36.8 MB, 在Delete Columns to Make Sorted II的Java提交中击败了100.00% 的用户
class Solution {
    public int minDeletionSize(String[] A) {
        boolean[] B = new boolean[A[0].length()];
        return minDSSub(A, B, 0, 0, A.length);
    }

    private int minDSSub(String[] A, boolean[] B, int col, int rowFrom, int rowTo) {
        System.out.println("现在计算的是minDSSub（A，B，"+col+"，"+rowFrom+"，"+rowTo+"）");
        if (col >= A[0].length()) return 0;
        if(B[col]==true) return minDSSub(A,B,col+1,rowFrom,rowTo);
        int count = 0;
        int from = -1;
        for (int i = rowFrom + 1; i < rowTo; i++) {
            if (A[i].charAt(col) - A[i - 1].charAt(col) < 0) {
                count++;
                B[col] = true;
                count += minDSSub(A, B, col + 1, rowFrom, rowTo);
                break;
            } else if (A[i].charAt(col) == A[i - 1].charAt(col)) {
                if (from == -1) from = i - 1;
                if(i==rowTo-1) {
                    count+=minDSSub(A,B,col+1,from, rowTo);
                    from = -1;
                }
            } else if (from != -1) {
                count += minDSSub(A, B, col + 1, from, i);
                from = -1;
            }
        }
        return count;
    }

}
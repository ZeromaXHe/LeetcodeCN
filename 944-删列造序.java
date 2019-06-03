//执行用时 : 34 ms, 在Delete Columns to Make Sorted的Java提交中击败了41.45% 的用户
//内存消耗 : 47.1 MB, 在Delete Columns to Make Sorted的Java提交中击败了67.39% 的用户
class Solution {
    public int minDeletionSize(String[] A) {
        int count  = 0;
        for(int j = 0;j<A[0].length();j++){
            for(int i=1;i<A.length;i++){
                if(A[i].charAt(j)-A[i-1].charAt(j)<0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
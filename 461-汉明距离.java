class Solution {
    public int hammingDistance(int x, int y) {
        int res = x^y;
        int result = 0;
        while(res>0){
            if((res & 1)==1) result++;
            res>>=1;
        }
        return result;
    }
}
//执行用时 :6 ms, 在所有 Java 提交中击败了81.35%的用户
//内存消耗 :34.5 MB, 在所有 Java 提交中击败了11.82%的用户
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        if(n>>31==0){
            while(n!=0){
                if(n%2==1 && n!=1) return false;
                n>>=1;
            }
            return true;
        }else{
            while(n!=0){
                if(n%2!=1) return false;
                n>>=1;
            }
            return true;
        }
    }
}
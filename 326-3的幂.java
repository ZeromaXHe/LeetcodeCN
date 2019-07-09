//执行用时 :85 ms, 在所有 Java 提交中击败了70.93%的用户
//内存消耗 :40.3 MB, 在所有 Java 提交中击败了13.86%的用户
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        while(n>1){
            if(n%3!=0) return false;
            n/=3;
        }
        return true;
    }
}
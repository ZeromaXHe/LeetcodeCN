//执行用时 :1 ms, 在所有 Java 提交中击败了89.60%的用户
//内存消耗 :35.6 MB, 在所有 Java 提交中击败了57.77%的用户
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int temp = 0;
        for(int i =2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]) temp++;
            else{
                count+= (1+temp)*temp/2;
                temp=0;
            }
        }
        count+= (1+temp)*temp/2;
        return count;
    }
}
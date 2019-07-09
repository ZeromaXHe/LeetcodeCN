//执行用时 :5 ms, 在所有 Java 提交中击败了97.65%的用户
//内存消耗 :33.6 MB, 在所有 Java 提交中击败了13.12%的用户
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        int[] mask = {0x55555555,0x33333333,0x0f0f0f0f,0x00ff00ff,0x0000ffff};
        if((mask[0]&num)!=num) return false;
        for(int i=1;i<mask.length;i++){
            mask[i]=mask[i]&num;
            if(mask[i]!=num&&mask[i]!=0) return false;
        }
        return true;
    }
}
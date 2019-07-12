//执行用时 :1 ms, 在所有 Java 提交中击败了99.76%的用户
//内存消耗 :38.4 MB, 在所有 Java 提交中击败了63.82%的用户
class Solution {
    public int thirdMax(int[] nums) {
        boolean[] use = new boolean[3];
        int max=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        for(int i:nums){
            if(i==max){
                if(!use[0]) use[0]=true;
            }
            else if(i==max2){
                if(!use[1]) use[1]=true;
            }
            else if(i==max3){
                if(!use[2]) use[2]=true;
            }
            else if(i>max){
                max3=max2;
                use[2]=use[1];
                max2=max;
                use[1]=use[0];
                max=i;
                use[0]=true;
            }
            else if(i>max2){
                max3=max2;
                use[1]=use[0];
                max2=i;
                use[1]=true;
            }
            else if(i>max3){
                max3=i;
                use[2]=true;
            }
        }
        if(use[2]) return max3;
        else return max;
    }
}
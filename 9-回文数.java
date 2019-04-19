class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        int i=0;
        while(i<x){
            i*=10;
            i+=x%10;
            if(i==0) return false;//结尾为0就不是回文数
            x/=10;
        }
        if(i==x){
            return true;
        }
        else{
            if(i/10==x){
                return true;
            }
            else return false;
        } 
    }
}
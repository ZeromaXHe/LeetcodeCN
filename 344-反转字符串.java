//执行用时 :4 ms, 在所有 Java 提交中击败了86.39%的用户
//内存消耗 :54.1 MB, 在所有 Java 提交中击败了64.92%的用户
class Solution {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            swap(s,i,s.length-1-i);
        }
    }
    private void swap(char[] s, int i,int j){
        char tmp = s[i];
        s[i]=s[j];
        s[j]=tmp;
    }
}
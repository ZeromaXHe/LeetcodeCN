//执行用时 :475 ms, 在所有 Java 提交中击败了7.96%的用户
//内存消耗 :37.2 MB, 在所有 Java 提交中击败了78.43%的用户
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=s.length()-1;
        int ins = 0;
        while(!isPalidrome(sb.toString())){
            sb.insert(ins,s.charAt(i));
            i--;
            ins++;
        }
        return sb.toString();
    }
    private boolean isPalidrome(String s){
        int len=s.length();
        for(int i =0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-1-i)) return false;
        }
        return true;
    }
}
//执行用时 :398 ms, 在所有 Java 提交中击败了17.70%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了80.39%的用户
class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        int i=2;
        int maxPalidrome = 1;
        while(i<=s.length()){//这里应该是性能瓶颈，需要用KMP优化
            if(isPalidrome(i,s)){
                maxPalidrome = i;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder(s.substring(maxPalidrome));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
    private boolean isPalidrome(int offset, String s){
        for(int i = 0 ;i<offset/2;i++){
            if(s.charAt(i)!=s.charAt(offset-1-i)) return false;
        }
        return true;
    }
}
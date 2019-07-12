//执行用时 :1 ms, 在所有 Java 提交中击败了99.11%的用户
//内存消耗 :35.8 MB, 在所有 Java 提交中击败了72.91%的用户
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int len = s.length();
        char[] chs = s.toCharArray();
        while(i<len){
            if(Character.isDigit(chs[i])){
                int digit = chs[i]-'0';
                while(i+1<len&&Character.isDigit(chs[i+1])){
                    i++;
                    digit*=10;
                    digit+=chs[i]-'0';
                }
                i+=2;
                int from = i;
                int count = 1;
                while(count>0){
                    i++;
                    if(chs[i]=='[') count++;
                    else if(chs[i]==']')count--;
                }
                for(int j=0;j<digit;j++){
                    sb.append(decodeString(s.substring(from,i)));
                }
            }
            else sb.append(chs[i]);
            i++;
        }
        return sb.toString();
    }
}
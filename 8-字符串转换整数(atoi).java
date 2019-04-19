class Solution {
    public int myAtoi(String str) {
        int pointer=0;
        int len=str.length();
        int sign=0;
        String result="";
        while(pointer<len && str.charAt(pointer)==' ') pointer++;
        if(pointer>=len) return 0;
        if(str.charAt(pointer)=='-'){
            sign=-1;
            pointer++;
        }
        else if(str.charAt(pointer) == '+'){
            sign=1;
            pointer++;
        } 
        else if(Character.isDigit(str.charAt(pointer))) sign=1;
        else return 0;
        while(pointer<len && str.charAt(pointer)=='0') pointer++;
        while(pointer<len && Character.isDigit(str.charAt(pointer))){
            result += str.charAt(pointer);
            pointer++;
        }
        int resultLen=result.length();
        if(resultLen>=11)
            if(sign==-1)return -2147483648;
            else return 2147483647;
        else if(resultLen==10){
            if(sign==-1&& (result.compareTo("2147483648")>=0)) return -2147483648;
            if(sign==1&& (result.compareTo("2147483647")>=0)) return 2147483647;
            int res = sign;
            res*=Integer.parseInt(result);
            return res;
        }
        else if(resultLen==0){
            return 0;
        }
        else{
            int res = Integer.parseInt(result);
            res*=sign;
            return res;
        }
    }
}
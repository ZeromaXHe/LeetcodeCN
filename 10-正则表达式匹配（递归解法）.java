class Solution {
    public boolean isMatch(String s, String p) {
        if("".equals(s)||"".equals(p)){
            return dealWithEnd(s,p);
        }
        if(p.charAt(0)=='.'){
            if(p.length()>1&& p.charAt(1)=='*'){
                return pointStarMatch(s,p);
            }
            else{
                return isMatch(s.substring(1),p.substring(1));
            }
        }
        else {
            if(p.length()>1&& p.charAt(1)=='*'){
                return characterStarMatch(s,p);
            }
            else{
                return singleMatch(s,p);
            }
        }
    }
    boolean singleMatch(String s,String p){
        if(s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1),p.substring(1));
        else return false;
    }
    boolean characterStarMatch(String s,String p){
        char p0=p.charAt(0);
        for(int i=0;i<s.length();i++){
            if(isMatch(s.substring(i+1),p.substring(2))||isMatch(s.substring(i+1),p)){
                return true;
            }
            else return false;
        }
        return false;
    }
    boolean pointStarMatch(String s,String p){
        for(int i=0;i<s.length();i++){
            if(isMatch(s.substring(i+1),p.substring(2))||isMatch(s.substring(i+1),p)) return true;
        }
        return false;
    }
    boolean dealWithEnd(String aS, String aP){
        if((!"".equals(aS) && "".equals(aP))) return false;
        else{
            if("".equals(aS)&&!"".equals(aP)){
                if(aP.length()%2==0){
                    int pos=1;
                    while(pos<aP.length()){
                        if(aP.charAt(1)!='*') return false;
                        pos+=2;
                    }
                    return true;
                }
                else return false;
            }
            else return true;//aS和aP全部是空的
        }
    }
}
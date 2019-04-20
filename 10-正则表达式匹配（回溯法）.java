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
        //System.out.println("检查单个字母"+s.charAt(0));
        if(s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1),p.substring(1));
        else return false;
    }
    boolean characterStarMatch(String s,String p){
        //System.out.println("检查字母加星号"+p.charAt(0)+"*");
        char p0=p.charAt(0);
        if("".equals(s)) return dealWithEnd(s,p);
        if(s.charAt(0)==p0){
            if(characterStarMatch(s.substring(1),p)||isMatch(s,p.substring(2))){
                return true;
            }
        }
        else{
            if(isMatch(s,p.substring(2))){
                return true;
            }
        }
        return false;

    }
    boolean pointStarMatch(String s,String p){
        if("".equals(s)) return dealWithEnd(s,p);
        if(isMatch(s,p.substring(2))||pointStarMatch(s.substring(1),p)) return true;

        return false;
    }
    boolean dealWithEnd(String aS, String aP){
        if((!"".equals(aS) && "".equals(aP))) return false;
        else{
            if("".equals(aS)&&!"".equals(aP)){
                if(aP.length()%2==0){
                    int pos=1;
                    while(pos<aP.length()){
                        if(aP.charAt(pos)!='*') return false;
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
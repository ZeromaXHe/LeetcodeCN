class Solution {
    public boolean isMatch(String s, String p) {
        if("".equals(s)||"".equals(p)){
        	return dealWithEnd(s,p);
        }
        while(!"".equals(s) && !"".equals(p)){
        	if(Character.isAlphabetic(p.charAt(0))){
        		//这里是字母加‘*’的情况
        		if(p.length()>1 && p.charAt(1)=='*'){
        			s=starMode(s,p.charAt(0));
        			p=p.substring(2,p.length());
        		}
        		//这里else是普通单个字母匹配的情况
        		else{
        			if(s.charAt(0)==p.charAt(0)){
        				s=s.substring(1,s.length());
        				p=p.substring(1,p.length());
        			}
        			else return false;
        		}
        	}
        	else if(p.charAt(0)=='.'){
        		//".*"的情况，感觉很麻烦
        		if(p.length()>1 && p.charAt(1)=='*'){

        		}
        		//单个'.'的情况
        		else{
        			s=s.substring(1,s.length());
        			p=p.substring(1,p.length());
        		}
        	}
        	else return false;//这里说明正则表达式有问题，按题目来说，是走不到这个分支的。
        }
    }

    boolean dealWithEnd(String aS, String aP){
    	if((!"".equals(aS) && "".equals(aP)) return false;
    	else{
        	if("".equals(aS)&&!"".equals(aP)){
        		if(aP.length()%2==0){
        			while(!"".equals(aP)){
        				if(aP.charAt(1)!='*') return false;
        				else aP.substring(2,aP.length());
        			}
        			return true;
        		}
        		else return false;
        	}
        	else return true;//aS和aP全部是空的
    	}
    }

    String starMode(String aS, char aC){
    	int i=0;
    	while(aS.charAt(i)==aC){
    		i++;
    	}
    	return aS.substring(i,aS.length);
    }

    boolean dotStarMode(String aS){

    }
}

/*s="aaa"
  p="ab*a*c*a"
  无法解决
*/
class Solution2 {
    public boolean isMatch(String s, String p) {
        if("".equals(s)||"".equals(p)){
        	return dealWithEnd(s,p);
        }
        while(!"".equals(s) && !"".equals(p)){
        	int lenP=p.length();
        	int lenS=s.length();
        	if(p.charAt(lenP-1)=='*'){
        		if(p.charAt(lenP-2)=='.'){
        			if(lenP==2) return true;
        			else{
        				int pos = lenS-1;
        				while(pos>=0&&s.charAt(pos)!=p.charAt(lenP-3)){
        					pos--;
        				}
        				if(pos==-1) return false;
        				else{
        					s=s.substring(0,pos);
        					p=p.substring(0,lenP-3);
        				}
        			}
        		}
        		else{
        			int count=0;
        			while(lenS-1-count>=0&&s.charAt(lenS-1-count)==p.charAt(lenP-2)){
        				count++;
        			}
        			s=s.substring(0,lenS-count);
        			p=p.substring(0,lenP-2);
        		}
        	}
        	else{
        		if(p.charAt(lenP-1)=='.'||s.charAt(lenS-1)==p.charAt(lenP-1)){
        			s=s.substring(0,lenS-1);
        			p=p.substring(0,lenP-1);
        		}
        		else return false;
        	}
        }
        return dealWithEnd(s,p);
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
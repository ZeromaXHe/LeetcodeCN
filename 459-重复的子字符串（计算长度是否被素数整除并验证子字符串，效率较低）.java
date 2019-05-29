class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len < 2) return false;
        LinkedList<Integer> ll = primerList(len);
        for(int primer: ll){
            if(len%primer==0){
                for(int i = 0;i<primer-1;i++){
                    if(!s.substring(i*len/primer,(i+1)*len/primer).equals(s.substring((i+1)*len/primer,(i+2)*len/primer))) break;
                    if(i==primer-2) return true;
                }
            }
        }
        return false;
    }
    
    private LinkedList<Integer> primerList(int n){
        LinkedList<Integer> res = new LinkedList<>();
        if(n<2) return res;
        res.add(2);
        if(n==2) return res;
        for(int i = 3; i<=n;i+=2){
            boolean flag = true;
            for(int primer:res){
                if(i%primer==0) {flag= false;break;}
            }
            if(flag == true) res.add(i);
        }
        return res;
    }
}
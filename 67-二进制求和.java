//执行用时 :5 ms, 在所有Java提交中击败了79.82%的用户
//内存消耗 :34.8 MB, 在所有Java提交中击败了76.81%的用户
class Solution {
    char[] chl;
    char[] chs;
    int pl;
    int ps;
    boolean carry=false;
    public String addBinary(String a, String b) {
        if(a.length()>=b.length()){
            chl = a.toCharArray();
            chs = b.toCharArray();
        }
        else{
            chl = b.toCharArray();
            chs = a.toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        ps = chs.length-1;
        pl = chl.length-1;
        for(;ps>=0;ps--,pl--){
            compute(sb);
        }
        if(pl<0){
            if(carry) {
                sb.append('1');
                carry=false;
            }
        }
        else{
            for(;pl>=0;pl--){
                if(carry){
                    if(chl[pl]=='1') sb.append('0');
                    else {
                        sb.append('1');
                        carry=false;
                    }
                }
                else sb.append(chl[pl]);
            }
        }
        if(carry) sb.append('1');
        return sb.reverse().toString();
    }
    private void compute(StringBuilder sb){
        if(carry){
            if(chs[ps]=='1'){
                if(chl[pl]=='1') sb.append('1');
                else sb.append('0');
            }
            else{
                if(chl[pl]=='1') sb.append('0');
                else {
                    sb.append('1');
                    carry=false;
                }
            }
        }
        else{
            if(chs[ps]=='1'){
                if(chl[pl]=='1') {
                    sb.append('0');
                    carry = true;
                }
                else sb.append('1');
            }
            else{
                if(chl[pl]=='1') sb.append('1');
                else sb.append('0');
            }
        }
    }
}
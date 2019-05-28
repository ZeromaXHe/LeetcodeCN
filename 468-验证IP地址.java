class Solution {
    public String validIPAddress(String IP) {
        if(IP.startsWith(":")||IP.startsWith(".")
           ||IP.endsWith(":")||IP.endsWith(".")) return "Neither";//防止开头和结尾是“：”和“.”，会扰乱后面split的判断：52 / 79 "2001:0db8:85a3:0:0:8A2E:0370:7334:"
        String[] splitted = IP.split("\\.");
        if(splitted.length==4){
            int num=-1;
            for(int i=0;i<4;i++){
                try{
                    num=Integer.parseInt(splitted[i]);
                }catch(NumberFormatException e){
                    return "Neither";
                }
                if(num<0||num>255) return "Neither";
                if(splitted[i].length()>1
                   &&(splitted[i].startsWith("0")||splitted[i].startsWith("-")))
                    return "Neither";//防止IPv4中的0开头的情况：65 / 79 "01.01.01.01"；还有防止-0的情况：76 / 79 "15.16.-0.1"
            }
            return "IPv4";
        }else{
            splitted = IP.split(":");
            if(splitted.length==8){
                int num=-1;
                for(int i=0;i<8;i++){
                    int len = splitted[i].length();
                    if(splitted[i]==null
                       ||len>4
                       ||len==0) return "Neither";
                    for(int j=0;j<len;j++){
                        char c = splitted[i].charAt(j);
                        if(!((c>='0'&&c<='9')||(c>='a'&&c<='f')||(c>='A'&&c<='F'))) return "Neither";
                    }
                }
                return "IPv6";
            }else return "Neither";
        }
    }
}
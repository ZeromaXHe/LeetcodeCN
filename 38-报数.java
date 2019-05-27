class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String before = countAndSay(n-1);
        char former = before.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<before.length();i++){
            if(before.charAt(i)!=former){
                sb.append(count);
                sb.append(former);
                former=before.charAt(i);
                count =1;
            }else{
                count++;
            }
        }
        sb.append(count);
        sb.append(former);
        return sb.toString();

    }
}
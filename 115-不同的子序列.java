//执行用时 :28 ms, 在所有 Java 提交中击败了5.18%的用户
//内存消耗 :34.4 MB, 在所有 Java 提交中击败了90.51%的用户
class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS<lenT) return 0;
        if(lenS==lenT) return s.equals(t)?1:0;
        int[] pre = new int[lenS];
        int[] now = new int[lenS];
        int[] tmpArr = null;
        int temp = 0;
        int sum = 0;
        for(int i = 0;i<lenT;i++){
            tmpArr = pre;
            pre = now;
            now = tmpArr;
            Arrays.fill(now,0);
            temp = s.indexOf(t.charAt(i));
            while(temp!=-1 && temp<=lenS-lenT+i) {
                if(temp>=i)now[temp]=1;
                temp = s.indexOf(t.charAt(i),temp+1);
            }
            if(i!=0){
                for(int j = i;j<lenS;j++){
                    if(now[j]==1){
                        for(int k=0;k<j;k++){
                            if(pre[k]!=0) sum+=pre[k];
                        }
                        now[j]=sum;
                        sum=0;
                    }
                }
            }
            //System.out.println(Arrays.toString(now));
        }
        for(int i = 0;i<lenS;i++){
            sum+=now[i];
        }
        return sum;
    }
}

//执行用时 :20 ms, 在所有 Java 提交中击败了40.33%的用户
//内存消耗 :34.3 MB, 在所有 Java 提交中击败了90.51%的用户
class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS<lenT) return 0;
        if(lenS==lenT) return s.equals(t)?1:0;
        int[] now = new int[lenS-lenT+1];
        int sum = 0;
        for(int i = 0;i<lenT;i++){
            if(i!=0){
                for(int j = i;j<=lenS-lenT+i;j++){
                    sum+=now[j-i];
                    if(s.charAt(j)==t.charAt(i)) now[j-i]= sum;
                    else now[j-i]=0;
                }
                sum=0;
            }
            else{
                for(int j = 0;j<lenS-lenT+1;j++){
                    if(s.charAt(j)==t.charAt(i)) now[j]=1;
                }
            }
            //System.out.println(Arrays.toString(now));
        }
        for(int i = 0;i<lenS-lenT+1;i++){
            if(s.charAt(lenT+i-1)==t.charAt(lenT-1))sum+=now[i];
        }
        return sum;
    }
}
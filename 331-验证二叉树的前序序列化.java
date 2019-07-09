//执行用时 :3 ms, 在所有 Java 提交中击败了98.29%的用户
//内存消耗 :35.6 MB, 在所有 Java 提交中击败了97.06%的用户
class Solution {
    public boolean isValidSerialization(String preorder) {
        char[] chs = preorder.toCharArray();
        int i=0;
        int count=1;
        while(i<chs.length){
            if(chs[i]=='#'){
                count--;
                if(count<0) return false;
                if(count==0){
                    if(i==chs.length-1) return true;
                    else return false;
                }
            }
            else if(chs[i]!=','){
                while(i+1<chs.length&&chs[i+1]!='#'&&chs[i+1]!=',') i++;
                count++;
            }
            i++;
        }
        return false;
    }
}
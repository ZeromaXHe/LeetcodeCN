//执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :34.8 MB, 在所有 Java 提交中击败了83.37%的用户
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            if(n%26==0) {
                sb.insert(0,'Z');
                n=n/26-1;
            }
            else {
                sb.insert(0,(char)('A'+n%26-1));
                n/=26;
            }
        }
        return sb.toString();
    }
}
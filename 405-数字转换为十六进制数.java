//执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :34.4 MB, 在所有 Java 提交中击败了94.44%的用户
class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        
        while(num!=0){
            if((num&15)<10) sb.append(num&15);
            else sb.append((char)('a'+(num&15)-10));
            num>>>=4;
        }
        return sb.reverse().toString();
    }
}
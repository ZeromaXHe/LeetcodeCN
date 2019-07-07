//执行用时 :1 ms, 在所有 Java 提交中击败了95.58%的用户
//内存消耗 :55.3 MB, 在所有 Java 提交中击败了9.68%的用户
class Solution {
    public int hIndex(int[] citations) {
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]<citations.length-i){
                return citations.length-i-1;
            } 
        }
        return citations.length;
    }
}
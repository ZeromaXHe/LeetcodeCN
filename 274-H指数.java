//执行用时 :27 ms, 在所有 Java 提交中击败了7.14%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了36.84%的用户
class Solution {
    public int hIndex(int[] citations) {
        int[] h = new int[citations.length];
        boolean allZero = true;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>0){
                allZero = false; 
                for(int j=0;j<citations[i]&&j<h.length;j++){
                    h[j]++;
                }
            } 
        }
        if(allZero) return 0;
        for(int i=0;i<h.length;i++){
            if(i>=h[i]) return i;
        }
        return h.length;
    }
}
//执行用时 :4 ms, 在所有 Java 提交中击败了61.69%的用户
//内存消耗 :35.8 MB, 在所有 Java 提交中击败了86.18%的用户
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]<citations.length-i){
                return citations.length-i-1;
            } 
        }
        return citations.length;
    }
}
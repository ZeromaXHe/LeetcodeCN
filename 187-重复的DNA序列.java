//执行用时 :59 ms, 在所有 Java 提交中击败了42.89%的用户
//内存消耗 :55.4 MB, 在所有 Java 提交中击败了16.28%的用户
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 10) return res;
        //储存已经遍历过的子字符串
        Set<String> set1 = new HashSet<>();
        //储存符合条件的子字符串
        Set<String> set2 = new HashSet<>();
        for(int i = 0;i + 10 <= s.length();i++){
            String seq = s.substring(i,i+10);
            if(set1.contains(seq)){
                set2.add(seq);
            }
            set1.add(seq);
        }
        res.addAll(set2);
        return res;
    }
}
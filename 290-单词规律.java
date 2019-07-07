//执行用时 :2 ms, 在所有 Java 提交中击败了98.46%的用户
//内存消耗 :33.9 MB, 在所有 Java 提交中击败了42.04%的用户
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length()!=strs.length) return false;
        HashMap<Character,String> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!strs[i].equals(hm.get(pattern.charAt(i)))) return false;
            }
            else{
                if(hm.containsValue(strs[i])) return false;
                hm.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }
}
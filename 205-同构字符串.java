//执行用时 :22 ms, 在所有 Java 提交中击败了50.62%的用户
//内存消耗 :38.9 MB, 在所有 Java 提交中击败了30.95%的用户
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                if(t.charAt(i)!=hm.get(s.charAt(i))) return false;
            }
            else{
                if(hm.containsValue(t.charAt(i))) return false;
                hm.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
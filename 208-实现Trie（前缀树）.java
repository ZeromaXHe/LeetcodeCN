//执行用时 :191 ms, 在所有 Java 提交中击败了42.30%的用户
//内存消耗 :54.7 MB, 在所有 Java 提交中击败了88.25%的用户
class Trie {
    private HashMap<Character,Trie> map = new HashMap<>();
    private boolean end = false;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    public Trie(String word){
        this.insert(word);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word!=null&&word.length()!=0){
            if(map.containsKey(word.charAt(0))) {
                map.get(word.charAt(0)).insert(word.substring(1));
            }
            else map.put(word.charAt(0),new Trie(word.substring(1)));
        }
        else end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word!=null && word.length()!=0){
            if(map.containsKey(word.charAt(0))) {
                return map.get(word.charAt(0)).search(word.substring(1));
            }
            else return false;
        }
        else return end==true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix!=null && prefix.length()!=0){
            if(map.containsKey(prefix.charAt(0))) {
                return map.get(prefix.charAt(0)).startsWith(prefix.substring(1));
            }
            else return false;
        }
        else return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
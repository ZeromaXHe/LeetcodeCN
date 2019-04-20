import java.util.*;
class LRUCache {
	private int size;
    private int oldestKey = 0;
    private LinkedHashMap<Integer, Integer> lhm;
    public LRUCache(int capacity) {
    	this.size = capacity;
    	lhm = new LinkedHashMap<Integer,Integer>(capacity, 1 , true){
    		@Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    boolean isRemove = false;
                    if (this.size() > size) {
                        isRemove = true;
                        oldestKey = eldest.getKey();
                    }
                    return isRemove;
                }
    	};

    }
    
    public int get(int key) {
        if (lhm.get(key) != null) {
            return lhm.get(key);
        } else return -1;
    }
    
    public void put(int key, int value) {
        if (lhm.size() > size) {
            lhm.remove(oldestKey);
        }
        lhm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
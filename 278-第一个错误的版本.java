//执行用时 :17 ms, 在所有 Java 提交中击败了74.22%的用户
//内存消耗 :34.1 MB, 在所有 Java 提交中击败了67.28%的用户
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int from = 1;
        int to = n;
        while(from<to){
            //System.out.println("["+from+","+to+"]");
            if(isBadVersion((int)(((long)from+to)/2))){
                to=(int)(((long)from+to)/2);
            }
            else from = (int)(((long)from+to)/2)+1;
        }
        return from;
    }
}
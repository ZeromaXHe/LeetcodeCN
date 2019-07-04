//执行用时 :1 ms, 在所有 Java 提交中击败了99.77%的用户
//内存消耗 :35 MB, 在所有 Java 提交中击败了31.15%的用户
class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int comp1 = 0;
        int comp2 = 0;
        int p1 = 0;
        int p2 = 0;
        while(p1<v1.length||p2<v2.length){
            while(p1<v1.length && v1[p1]!='.'){
                comp1*=10;
                comp1+=v1[p1]-'0';
                p1++;
            }
            while(p2<v2.length && v2[p2]!='.'){
                comp2*=10;
                comp2+=v2[p2]-'0';
                p2++;
            }
            if(comp1>comp2) return 1;
            if(comp1<comp2) return -1;
            comp1=0;
            comp2=0;
            p1++;
            p2++;
        }
        return 0;
    }
}
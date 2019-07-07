//执行用时 :6 ms, 在所有 Java 提交中击败了81.84%的用户
//内存消耗 :33.9 MB, 在所有 Java 提交中击败了12.10%的用户
//10->1
//11->2
//...
//18->9
//19->1
//...
//27->9
class Solution {
    public int addDigits(int num) {
        if(num%9==0&&num!=0) return 9;
        else return num%9;
    }
}
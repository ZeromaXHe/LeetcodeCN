//执行用时 :11 ms, 在所有Java提交中击败了77.27%的用户
//内存消耗 :42.6 MB, 在所有Java提交中击败了76.35%的用户
class Solution {
    public boolean judgeCircle(String moves) {
        int ud =0;
        int lr = 0;
        char[] c = moves.toCharArray();
        for(char ch:c){
            if(ch=='L') lr--;
            else if(ch=='R') lr++;
            else if(ch=='U') ud++;
            else if(ch=='D') ud--;
        }
        if(ud==0&&lr==0)return true;
        else return false;
    }
}
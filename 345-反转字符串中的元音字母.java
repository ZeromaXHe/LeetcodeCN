//执行用时 :7 ms, 在所有 Java 提交中击败了93.49%的用户
//内存消耗 :42.1 MB, 在所有 Java 提交中击败了37.35%的用户
class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length-1;
        while(left<right){
            while(left<chs.length
                  &&chs[left]!='a'&&chs[left]!='A'
                  &&chs[left]!='e'&&chs[left]!='E'
                  &&chs[left]!='i'&&chs[left]!='I'
                  &&chs[left]!='o'&&chs[left]!='O'
                  &&chs[left]!='u'&&chs[left]!='U'){
                left++;
            }
            while(right>=0
                  &&chs[right]!='a'&&chs[right]!='A'
                  &&chs[right]!='e'&&chs[right]!='E'
                  &&chs[right]!='i'&&chs[right]!='I'
                  &&chs[right]!='o'&&chs[right]!='O'
                  &&chs[right]!='u'&&chs[right]!='U'){
                right--;
            }
            if(left>=right) break;
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
        return new String(chs);
    }
}
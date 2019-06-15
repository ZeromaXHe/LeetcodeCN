//执行用时 :86 ms, 在所有Java提交中击败了13.36%的用户
//内存消耗 :45.9 MB, 在所有Java提交中击败了57.32%的用户
class Solution {
    char[] sChars;
    char[] pChars;
    short[][] dp;//这个数组是用来记录isMatchChar的结果，来方便回溯剪枝的。一开始用short是因为以为可以存1代表成功，0代表未计算，-1代表失败。后来想想发现其实用boolean就行了，false代表未计算，true代表计算过失败的——成功的就直接return了，不需要存储。

    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            if (s != null && s.length() > 0) return false;
            else return true;
        }
        pChars = p.toCharArray();
        if (s == null || s.length() == 0) {
            for (int i = 0; i < pChars.length; i++) {
                if (pChars[i] != '*') return false;
            }
            return true;
        }
        sChars = s.toCharArray();
        dp = new short[sChars.length][pChars.length];
        return isMatchChar(0, 0);
    }

    private boolean isMatchChar(int sIndex, int pIndex) {
        //System.out.println("isMatchChar():"+sIndex+","+pIndex);
        if (pIndex >= pChars.length) {
            if (sIndex < sChars.length) {
                return false;
            } else return true;
        }

        if (sIndex >= sChars.length) {
            for (int i = pIndex; i < pChars.length; i++) {
                if (pChars[i] != '*') return false;
            }
            return true;
        }
        if (dp[sIndex][pIndex] != 0) return dp[sIndex][pIndex] > 0;
        for (int i = pIndex; i < pChars.length; i++) {
            if (pChars[i] != '*') {
                if (i == pIndex) {
                    if (pChars[i] == '?' || sChars[sIndex] == pChars[i]) {
                        //System.out.println("匹配首个s:"+sChars[sIndex]+"和p:"+pChars[i]+"，调用下一个");
                        if (dp[sIndex][pIndex] != 0) return dp[sIndex][pIndex] > 0;
                        else return isMatchChar(sIndex + 1, pIndex + 1);
                    } else {
                        dp[sIndex][pIndex] = -1;
                        return false;
                    }
                } else {
                    int count = 0;
                    int countQuestionMark = 0;
                    while (i + count < pChars.length && (pChars[i + count] == '?' || pChars[i + count] == '*')) {
                        if (pChars[i + count] == '?') countQuestionMark++;
                        count++;
                    }
                    if (i + count >= pChars.length) {
                        return sChars.length - sIndex >= countQuestionMark;
                    }
                    int index = findInSChars(pChars[i + count], sIndex + countQuestionMark);
                    while (index < countQuestionMark) {
                        if (index < 0) {
                            dp[sIndex][pIndex] = -1;
                            return false;
                        }
                        index = findInSChars(pChars[i + count], index + 1);
                    }
                    while (!isMatchChar(index + 1, i + count + 1)) {
                        if (index < 0) {
                            dp[sIndex][pIndex] = -1;
                            return false;
                        }
                        index = findInSChars(pChars[i + count], index + 1);
                        if (index < 0) {
                            dp[sIndex][pIndex] = -1;
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    private int findInSChars(char c, int start) {
        for (int i = start; i < sChars.length; i++) {
            if (sChars[i] == c) return i;
        }
        return -1;
    }
}
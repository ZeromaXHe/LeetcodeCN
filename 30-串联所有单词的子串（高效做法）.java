class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new ArrayList<Integer>();
        if (words.length == 0) return res;
        int wl = words[0].length();//单词长度
        int wc = words.length;//单词数组容量
        int win = wc * wl; //匹配总长度。我居然没注意到题目是同等长度的子串。。。
        
        Map<String,Integer> map1 = new HashMap<String,Integer>();//map1存储<单词，重复次数>
        for (String w:words) {//遍历words数组
            if (map1.get(w)==null) map1.put(w,0);//将未收录单词存入map1
            map1.put(w, map1.get(w)+1);//出现次数+1
        }
        
        int[] wordNums = new int[map1.size()];//wordNums存储单词重复次数
        int i = 0;
        for (Integer n:map1.values()) {//这个遍历map的value的方法要学习一下，我还不怎么会用map……（捂脸）
            wordNums[i] = n;
            i++;
        }
        
        int[] f=new int[s.length()];//f中存储s位置对应单词子串的编号（优化遍历过程通过这个数组来实现的！！！）
        int wn=1;//wn就是map中对应单词的编号
        for(String w:map1.keySet()) {
            int index = -2;//方便进入循环，-2无特殊含义
            while(index != -1) {//找到一个以后，再次往后查找，直到indexOf没能找到，返回-1为止
                if (index == -2) index=-1;
                index = s.indexOf(w, index+1);//寻找字符串w（即map1存储的单词）在s中的位置
                if (index >=0) f[index] = wn;
            }
            wn++;//下一个单词，下一个编号。
        }
        
        int[] wordNumsWin = new int[map1.size()];//存储当时比较的串中各个单词的实际数量
        for (int j=0;j+win<=s.length();j++) {
            while(f[j]==0) {//f为0说明该地方没有对应的子串
                j++;
                if(j+win>s.length()) return res;
            }
            int k=j;
            while(k<j+win) {
                if(f[k] != 0) {
                    wordNumsWin[f[k]-1]++;
                    if (wordNumsWin[f[k]-1] > wordNums[f[k]-1]) break;
                }else break;
                k+=wl;//每次跳跃一个单词长度，到下一个单词
            }
            if (k==j+win) {
                res.add(j);
            }
            // clean the wordNumsWin
            for (int mm=0;mm<map1.size();mm++) wordNumsWin[mm] = 0;
        }
        
        return res;
    }
}
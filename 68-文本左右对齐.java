//执行用时 :1 ms, 在所有Java提交中击败了98.44%的用户
//内存消耗 :34.6 MB, 在所有Java提交中击败了55.84%的用户
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] count = new int[words.length];
        for(int i=0;i<words.length;i++){
            count[i] = words[i].length();
        }
        int sum = 0;
        int wordCount = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbSpace = new StringBuilder();
        List<String> res = new LinkedList<>();
        for(int i = 0; i<count.length; i++){
            if(sum+count[i]+wordCount<=maxWidth){
                sum+=count[i];
                wordCount++;
            }
            else{
                int space = maxWidth - sum;
                sbSpace.delete(0,sbSpace.length());
                sb.delete(0,sb.length());
                if(wordCount==1){
                    sb.append(words[i-1]);
                    for(int j=0;j<space;j++){
                        sb.append(' ');
                    }
                }
                else{
                    int numMoreSpace = space%(wordCount-1);
                    for(int j = 0;j<space/(wordCount-1);j++){
                        sbSpace.append(' ');
                    }
                    String lessSpace = sbSpace.toString();
                    sbSpace.append(' ');
                    String moreSpace = sbSpace.toString();
                    for(int j=wordCount;j>0;j--){
                        if(j!=wordCount){
                            if(j>wordCount-numMoreSpace-1) sb.append(moreSpace);
                            else sb.append(lessSpace);
                        }
                        sb.append(words[i-j]);
                    }
                }
                res.add(sb.toString());
                sum = count[i];
                wordCount=1;
            }
        }
        sb.delete(0,sb.length());
        for(int i=0;i<wordCount;i++){
            if(i!=0){
                sb.append(' ');
            }
            sb.append(words[words.length-wordCount+i]);
        }
        for(int i=0;i<maxWidth-sum-wordCount+1;i++) sb.append(' ');
        res.add(sb.toString());
        return res;
    }
}
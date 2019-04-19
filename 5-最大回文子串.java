class Solution {
    public String longestPalindrome(String s) {
        String str = InsertSharpToString(s);
        String output = Manacher(str);
        return output;
    }
    //构造插入了'#'的以'$'开头的新字符串
    private String InsertSharpToString(String aS){
    	StringBuilder sb= new StringBuilder();
        sb.append('$');
        for(int i =0;i<aS.length();i++){
            sb.append('#');
            sb.append(aS.charAt(i));
        }
        sb.append('#');
        String str = sb.toString();
        return str;
    }
    //马拉车算法，复杂度O(n)
    private String Manacher(String aStr){
    	int len = aStr.length();
    	int[] p=new int[len];//辅助数组，p[i]存储以i为中心的最长回文的半径
    	int mx=0;//代表以id为中心回文的右边界,mx=id+p[id]
    	int id=-1;//id必须赋个初值，java方法局部变量不初始化的话无法使用。
    	int max_len = -1;
    	int max=-1;
    	for(int i=1;i<len;i++){
    		if(i<mx) p[i]= (p[2*id-i]>mx-i)?mx-i:p[2*id-i];//p[i]取p[2*id-i]和mx-i的最小值。2*id-i是i关于id的对称点。
    		else p[i]=1;
    		while(i+p[i]<len && aStr.charAt(i-p[i])==aStr.charAt(i+p[i]))/*需要边界判断，因为java String结尾没有'\0' */
    			p[i]++;
    		// 我们每走一步 i，都要和 mx 比较，我们希望 mx 尽可能的远，这样才能更有机会执行 if (i < mx)这句代码，从而提高效率
    		if(mx<i+p[i]){
    			id=i;
    			mx=i+p[i];
    		}
    		if(max_len<p[i]-1){
    			max_len=p[i]-1;
    			max=i;
    		}
    	}
    	StringBuilder sb= new StringBuilder();
    	for(int i=max-p[max]+1;i<max+p[max];i++){
    		if (aStr.charAt(i)!='#') {
    			sb.append(aStr.charAt(i));
    		}
    	}
    	return (sb.toString());
    }
}
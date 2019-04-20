class Solution {
    public List<List<String>> partition(String s) {
        static int len=s.length();
        char[] sChar = new char[2*len+2];
        char[0]='$';

        //插入$和#  O(n)
        for(int i=0;i<len;i++){
        	sChar[2*i+1]='#';
        	sChar[2*i+2]=s.charAt(i);
        }
        sChar[sChar.length-1]='#';

        //马拉车  O(n)
        int[] p = Manacher(sChar);

        //构造图   如果使用邻接表更好   O(e)=O(n^2)
        boolean[][] graph= new boolean[len+1][len+1];
        for(int i = 0;i<p.length;i++){
        	while(p[i]>1){
        		graph[(i-p[i])/2][(i+p[i]-2)/2]=true;
        		p[i]-=2;
        	}
        }

        //dfs   O(n^2)
        boolean[] visit = new boolean[len+1];
        ArrayList singlePath = new ArrayList<String>();
        ArrayList totalPath = new ArrayList<>();
        dfs(0);


        //output    
        return totalPath;
    }
    private int[] Manacher(char[] sChar){
    	
    	int[] p=new int[sChar.length-1];//辅助数组，p[i]存储以i为中心的最长回文的半径
    	int mx=0;//代表以id为中心回文的右边界,mx=id+p[id]
    	int id=-1;//id必须赋个初值，java方法局部变量不初始化的话无法使用。

    	for(int i=1;i<sChar.length;i++){
    		if(i<mx) p[i]= (p[2*id-i]>mx-i)?mx-i:p[2*id-i];//p[i]取p[2*id-i]和mx-i的最小值。2*id-i是i关于id的对称点。
    		else p[i]=1;
    		while(i+p[i]<sChar.length && sChar[i-p[i]]==sChar[i+p[i]])/*需要边界判断，因为java String结尾没有'\0' */
    			p[i]++;
    		// 我们每走一步 i，都要和 mx 比较，我们希望 mx 尽可能的远，这样才能更有机会执行 if (i < mx)这句代码，从而提高效率
    		if(mx<i+p[i]){
    			id=i;
    			mx=i+p[i];
    		}
    	}
    	return p;
    }
    private String dfs(i){
    	for(int i=0;i<len+1;i++){
    		
    	}
    }

}
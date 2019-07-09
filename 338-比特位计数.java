//执行用时 :5 ms, 在所有 Java 提交中击败了18.35%的用户
//内存消耗 :43 MB, 在所有 Java 提交中击败了29.58%的用户
class Solution {
    //countOnes方法的设计原理参考邓俊辉版《数据结构习题解析》1-12
    int[] mask = {0x55555555,0x33333333,0x0f0f0f0f,0x00ff00ff,0x0000ffff};
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =0;i<res.length;i++){
            res[i]=countOnes(i);
        }
        return res;
    }
    
    private int round(int n, int c){
        return (n&mask[c])+(n>>(1<<c)&mask[c]);
    }
    
    private int countOnes(int n){
        n=round(n,0);
        n=round(n,1);
        n=round(n,2);
        n=round(n,3);
        n=round(n,4);
        return n;
    }
}

//执行用时 :4 ms, 在所有 Java 提交中击败了29.25%的用户
//内存消耗 :42.4 MB, 在所有 Java 提交中击败了29.96%的用户
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =0;i<res.length;i++){
            if(i==0) res[i]=0;
            else if(i==1) res[i]=1;
            else if(i%2==0)res[i]=res[i/2];
            else res[i]=res[i-1]+1;
        }
        return res;
    }
}
//执行用时 :3 ms, 在所有 Java 提交中击败了68.03%的用户
//内存消耗 :43.2 MB, 在所有 Java 提交中击败了29.21%的用户
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =1;i<res.length;i++){
            if((i&1)==0)res[i]=res[i>>1];
            else res[i]=res[i-1]+1;
        }
        return res;
    }
}
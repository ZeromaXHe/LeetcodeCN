//执行用时 :29 ms, 在所有 Java 提交中击败了68.31%的用户
//内存消耗 :36.7 MB, 在所有 Java 提交中击败了30.35%的用户
class Solution {
    public int countPrimes(int n) {
        if(n==0||n==1||n==2) return 0;
        int count = 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0]=true;
        notPrime[1]=true;
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                count++;
                //System.out.println("i:"+i+",count:"+count);
                for(int j=i*2; j<n;j+=i){
                    notPrime[j]=true;
                }
            }
        }
        return count;
    }
}
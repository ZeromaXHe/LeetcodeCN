//执行用时 :2 ms, 在所有Java提交中击败了99.76%的用户
//内存消耗 :33.5 MB, 在所有Java提交中击败了98.11%的用户
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] choosed = new boolean[n];//choosed[i]存储的是i+1是否被使用
        int[] factorial = new int[n-1];//factorial[i]存储的是i+1的阶乘
        int temp=1;
        for(int i =1;i<n;i++){
            temp*=i;
            factorial[i-1]=temp;
        }
        StringBuilder sb = new StringBuilder();
        k--;//这里不能少，毕竟我们是从0开始数，而给的k是从1开始。
        for(int i=n-2;i>=0;i--){
            int count = 0;
            int index = -1;
            while(count<k/factorial[i]+1){
                index++;
                if(!choosed[index]){
                    count++;
                }
            }
            choosed[index]=true;
            sb.append(index+1);
            k%=factorial[i];
        }
        for(int i=0;i<choosed.length;i++){
            if(!choosed[i]){
                sb.append(i+1);
                break;
            }
        }
        return sb.toString();
    }
}
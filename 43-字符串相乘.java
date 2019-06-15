//执行用时 :7 ms, 在所有Java提交中击败了97.00%的用户
//内存消耗 :35.5 MB, 在所有Java提交中击败了94.04%的用户
class Solution {
    public String multiply(String num1, String num2) {
        int[] product = new int[num1.length()+num2.length()];
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            for(int j=0;j<ch2.length;j++){
                product[i+j+1]+=(ch1[i]-'0')*(ch2[j]-'0');
            }
        }
        for(int i=product.length-1;i>0;i--){
            if(product[i]>=10){
                product[i-1]+=product[i]/10%10;
                if(i-2>=0)product[i-2]+=product[i]/100;
                product[i]%=10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag=false;
        for(int i=0;i<product.length;i++){
            if(product[i]>0) flag=true;
            if(flag) sb.append(product[i]);
        }
        if(!flag) return "0";
        return sb.toString();
    }
}
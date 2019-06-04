//执行用时 : 1 ms, 在Plus One的Java提交中击败了92.10% 的用户

//内存消耗 : 34.6 MB, 在Plus One的Java提交中击败了61.70% 的用户


class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for(int i : digits){
            if(i!=9) {flag = true; break;}
        }
        if(flag == false){
            int[] res = new int[digits.length+1];
            res[0]=1;
            return res;
        }
        else{
            for(int i = digits.length - 1;i>=0;i--){
                if(digits[i]!=9){
                    digits[i]+=1;
                    break;
                }
                else{
                    digits[i]=0;
                }
            }
            return digits;
        }
    }
}



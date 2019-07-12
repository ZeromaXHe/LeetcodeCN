//执行用时 :1 ms, 在所有 Java 提交中击败了98.48%的用户
//内存消耗 :33.9 MB, 在所有 Java 提交中击败了78.62%的用户
class Solution {
    public int findNthDigit(int n) {
        int[] digitDiv = new int[8];
        digitDiv[0]=10;
        int product = 9;
        for(int i=1;i<8;i++){
            product*=10;
            digitDiv[i]=digitDiv[i-1]+(i+1)*product;
        }
        // System.out.println(Arrays.toString(digitDiv));
        int div = 0;
        while(div<8&&n>=digitDiv[div]){
            div++;
        }
        if(div==0) return n;
        else {
            int mod = 10*(div+1);
            int divisor = div+1;
            int times = (n-digitDiv[div-1])%(div+1);
            int count = 0;
            while(count<div-times){
                mod*=10;
                divisor*=10;
                count++;
            }
            // System.out.println("mod:"+mod+" divisor:"+divisor+" div:"+div+" (n-digitDiv[div-1])%(div+1):"+(n-digitDiv[div-1])%(div+1));
            if((n-digitDiv[div-1])%(div+1)==0) return (n-digitDiv[div-1])/divisor+1;
            else return (n-digitDiv[div-1])%mod/divisor;
        }
//         else if(n<10+2*90){
//             if(n%2==1) return (n-10)%20/2;
//             else return (n-10)/20+1;
//         }
//         else if(n<190+3*900){
//             if((n-190)%3==2) return (n-190)%30/3;
//             else if((n-190)%3==1) return (n-190)%300/30;
//             else return (n-190)/300+1;
//         }
//         else if(n<2890+4*9000){
            
//         }
    }
}
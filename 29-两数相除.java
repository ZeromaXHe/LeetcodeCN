class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        long dvd = dividend;
        long dvs = divisor;
        boolean sign=false;//true代表结果为负
        if(dvd<0){
        	dvd=-dvd;
        	sign=!sign;
        }
        if(dvs<0){
        	dvs=-dvs;
        	sign=!sign;
        }
        if(dvd<dvs) return 0;
        if(sign) return (int)-test(dvd, dvs);
        else return (int)test(dvd,dvs);
    }
    private long test(long dividend, long divisor){
    	//System.out.println("dividend:"+dividend+" divisor:"+divisor);
    	if(dividend==divisor) return 1L;
    	long ans=0;
    	long divisorBackup=divisor;
    	if(dividend<divisor) return ans;
    	
    	long temp=1;
    	while(dividend > divisor){
    		divisor<<=1;
    		temp<<=1;
    	}
    	divisor >>=1;
    	temp>>=1;
    	ans+=temp;
    	dividend-=divisor;
    	ans+= test(dividend,divisorBackup);
    	
    	return ans;
    }
}

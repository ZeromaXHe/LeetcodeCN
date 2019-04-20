class Solution {
    public int romanToInt(String s) {
        int len=0;
        int num=0;
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] intR={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i =0;i<13;i++){
        	len=roman[i].length();
        	while(s.length()>=len&&roman[i].equals(s.substring(0,len))){
        		num+=intR[i];
        		s=s.substring(len);
        	}
        }
        return num;
    }
}
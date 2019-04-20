class Solution {
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
        for(int i=0;i<num/1000;i++) sb.append("M");
        num%=1000;
        if(num%500>=400){
        	if(num>=900) sb.append("CM");
        	else sb.append("CD");
        }
        else{
        	if(num>=500){
        		sb.append("D");
        		num%=500;
        	}
        	for(int i=0;i<num/100;i++) sb.append("C");
        }
        num%=100;
        if(num%50>=40){
        	if(num>=90) sb.append("XC");
        	else sb.append("XL");
        }
        else{
        	if(num>=50){
        		sb.append("L");
        		num%=50;
        	}
        	for(int i=0;i<num/10;i++) sb.append("X");
        }
    	num%=10;
    	if(num%5>=4){
        	if(num>=9) sb.append("IX");
        	else sb.append("IV");
        }
        else{
        	if(num>=5){
        		sb.append("V");
        		num%=5;
        	}
        	for(int i=0;i<num;i++) sb.append("I");
        }
    	return sb.toString();
    }
}
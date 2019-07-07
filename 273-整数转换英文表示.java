//执行用时 :6 ms, 在所有 Java 提交中击败了79.45%的用户
//内存消耗 :36.2 MB, 在所有 Java 提交中击败了80.49%的用户
class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        if(num>=1000){
            if(num>=1000000){
                if(num>=1000000000){
                    switch(num/1000000000){
                        case 0: break;
                        case 1: sb.append("One Billion"); break;
                        case 2: sb.append("Two Billion"); break;
                    }
                }
                if(num/1000000%1000>0){
                    if(sb.length()!=0) sb.append(' ');
                    sb.append(numToWordsLT1000(num/1000000%1000));
                    sb.append(" Million");
                }
            }
            if(num/1000%1000>0){
                if(sb.length()!=0) sb.append(' ');
                sb.append(numToWordsLT1000(num/1000%1000));
                sb.append(" Thousand");
            }
        }
        if(num%1000>0){
            if(sb.length()!=0) sb.append(' ');
            sb.append(numToWordsLT1000(num%1000));
        }
        return sb.toString();
    }
    
    private String numToWordsLT1000(int num){
        if(num>=100){
            String s = lastTwoDigitLT1000MT100(num%100);
            return LT20(num/100)+" Hundred"+("".equals(s)?s:" "+s);
        }
        else{
            return lastTwoDigitLT1000MT100(num%100);
        }
    }
    
    private String lastTwoDigitLT1000MT100(int num){
        if(num<=20) {
            if(num==0) return "";
            return LT20(num);
        }
        else{
            return MT20LT100(num);
        }
    }
    private String LT20(int num){
        switch(num){
            case 0:return "";
            case 1:return "One";
            case 2:return "Two";
            case 3:return "Three";
            case 4:return "Four";
            case 5:return "Five";
            case 6:return "Six";
            case 7:return "Seven";
            case 8:return "Eight";
            case 9:return "Nine";
            case 10:return "Ten";
            case 11:return "Eleven";
            case 12:return "Twelve";
            case 13:return "Thirteen";
            case 14:return "Fourteen";
            case 15:return "Fifteen";
            case 16:return "Sixteen";
            case 17:return "Seventeen";
            case 18:return "Eighteen";
            case 19:return "Nineteen";
            case 20:return "Twenty";
            default:return "";
        }
    }
    private String MT20LT100(int num){
        switch(num/10){
            case 2:return "Twenty"+(num%10==0?"":" ")+LT20(num%10);
            case 3:return "Thirty"+(num%10==0?"":" ")+LT20(num%10);
            case 4:return "Forty"+(num%10==0?"":" ")+LT20(num%10);
            case 5:return "Fifty"+(num%10==0?"":" ")+LT20(num%10);
            case 6:return "Sixty"+(num%10==0?"":" ")+LT20(num%10);
            case 7:return "Seventy"+(num%10==0?"":" ")+LT20(num%10);
            case 8:return "Eighty"+(num%10==0?"":" ")+LT20(num%10);
            case 9:return "Ninety"+(num%10==0?"":" ")+LT20(num%10);
            default:return "";
        }
    }
}
//执行用时 :1 ms, 在所有 Java 提交中击败了98.22%的用户
//内存消耗 :33.7 MB, 在所有 Java 提交中击败了67.19%的用户
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n==Integer.MAX_VALUE){
            if(guess(Integer.MAX_VALUE)==0) return Integer.MAX_VALUE;
            else return guessNumberRange(1,n);
        }
        else return guessNumberRange(1,n+1);
    }
    
    private int guessNumberRange(int from, int to){
        int g = guess(from/2+to/2);
        //System.out.println("g:"+g+" guess num:"+(from/2+to/2);
        if(g==0) return from/2+to/2;
        else if(g==-1) return guessNumberRange(from,from/2+to/2);
        else return guessNumberRange(from/2+to/2+1,to);
    }
}
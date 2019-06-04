//执行用时 : 34 ms, 在Valid Palindrome II的Java提交中击败了36.39% 的用户

//内存消耗 : 66.7 MB, 在Valid Palindrome II的Java提交中击败了10.08% 的用户

class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i <= (len-1)/2; i++){
            if(s.charAt(i)!=s.charAt(len-1-i)) 
                return palindrome(s.substring(i,len-1-i)) || palindrome(s.substring(i+1,len-i));
        }
        return true;
    }
    
    private boolean palindrome(String s){
        int len = s.length();
        for(int i = 0; i <= (len-1)/2; i++){
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        }
        return true;
    }
}


//避免使用substring可以提高效率：

//执行用时 : 13 ms, 在Valid Palindrome II的Java提交中击败了92.32% 的用户

//内存消耗 : 50.7 MB, 在Valid Palindrome II的Java提交中击败了57.76% 的用户

class Solution {
    public boolean validPalindrome(String s) {
        char[] sc = s.toCharArray();
        int len = sc.length;
        for(int i = 0; i <= (len-1)/2; i++){
            if(sc[i]!=sc[len-1-i]) 
                return palindrome(sc,i,len-1-i) || palindrome(sc,i+1,len-i);
        }
        return true;
    }
    
    private boolean palindrome(char[] sc, int from, int to){
        int len = sc.length;
        for(int i = from; i <= (from+to-1)/2; i++){
            if(sc[i]!=sc[to+from-1-i])
                return false;
        }
        return true;
    }
}


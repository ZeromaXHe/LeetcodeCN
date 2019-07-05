//执行用时 :71 ms, 在所有 Java 提交中击败了24.54%的用户
//内存消耗 :36.8 MB, 在所有 Java 提交中击败了96.99%的用户
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs,(String s1, String s2)->{
            int i =0;
            int len1 = s1.length();
            int len2 = s2.length();
            while(i<len1&&i<len2){
                if(s1.charAt(i)!=s2.charAt(i)) return s2.charAt(i)-s1.charAt(i);
                else i++;
            }
            if(i>=len1&&i>=len2) return 0;
            else if(i>=len1) {
                int temp = 0;
                String s = s1+s2;
                String st = s2+s1; 
                while(i<len2+len1){
                    if(st.charAt(i)!=s.charAt(temp)) return st.charAt(i)-s.charAt(temp);
                    else {
                        i++;
                        temp++;
                    }
                }
                return 0;
            }
            else {
                int temp = 0;
                String s = s2+s1;
                String st = s1+s2; 
                while(i<len1+len2){
                    if(st.charAt(i)!=s.charAt(temp)) return s.charAt(temp)-st.charAt(i);
                    else {
                        i++;
                        temp++;
                    }
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        if(sb.toString().charAt(0)=='0') return "0"; 
        else return sb.toString();
    }
}
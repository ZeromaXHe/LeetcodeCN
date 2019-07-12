//执行用时 :4 ms, 在所有 Java 提交中击败了57.30%的用户
//内存消耗 :42.7 MB, 在所有 Java 提交中击败了41.17%的用户
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0){
                if(i%5==0){
                    res.add("FizzBuzz");
                }
                else res.add("Fizz");
            }
            else if(i%5==0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}
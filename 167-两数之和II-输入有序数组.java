//执行用时 :4 ms, 在所有 Java 提交中击败了31.84%的用户
//内存消耗 :38.6 MB, 在所有 Java 提交中击败了23.44%的用户
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {0,numbers.length-1};
        while(res[0]<res[1]){
            if(numbers[res[0]]+numbers[res[1]]==target) {
                res[0]++;
                res[1]++;
                return res;
            }
            else if(numbers[res[0]]+numbers[res[1]]<target){
                res[0]++;
            }
            else if(numbers[res[0]]+numbers[res[1]]>target){
                res[1]--;
            }
        }
        return null;
    }
}
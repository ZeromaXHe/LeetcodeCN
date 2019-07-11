//执行用时 :4 ms, 在所有 Java 提交中击败了96.32%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了41.17%的用户
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[Math.max(nums1.length,nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        for(int i = 0;i<nums1.length;i++){
            if(i!=0&&nums1[i-1]==nums1[i]) continue;
            if(Arrays.binarySearch(nums2,nums1[i])>=0){
                res[count]=nums1[i];
                count++;
            }
        }
        return Arrays.copyOfRange(res,0,count);
    }
}
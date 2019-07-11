//执行用时 :26 ms, 在所有 Java 提交中击败了10.61%的用户
//内存消耗 :39.2 MB, 在所有 Java 提交中击败了6.03%的用户
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[Math.max(nums1.length,nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count01= 0;
        int count02= 0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0) count01++;
            else if(nums1[i]>0) break;
        }
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==0) count02++;
            else if(nums2[i]>0) break;
        }
        int count = Math.min(count01,count02);
        for(int i = 0;i<nums1.length;i++){
            if(nums1[i]==0) continue;
            int tmp = 0;
            if((tmp=Arrays.binarySearch(nums2,nums1[i]))>=0){
                res[count]=nums1[i];
                count++;
                nums2[tmp]=0;
                Arrays.sort(nums2);
            }
        }
        return Arrays.copyOfRange(res,0,count);
    }
}
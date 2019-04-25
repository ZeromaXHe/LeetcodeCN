//尚未实现
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2==1)return findKth(
        	nums1,nums2,
        	(nums1.length+nums2.length+1)/2);
        else return (
        	findKth(nums1,nums2,(nums1.length+nums2.length)/2)
        	+findKth(nums1,nums2,(nums1.length+nums2.length)/2+1)
        	)/2;
    }
    
    private double findKth(int[] nums1, int[] nums2, int k){
    	System.out.println("正在判断"+Arrays.toString(nums1)+"和"+Arrays.toString(nums2)+"的第"+k+"大的数");
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid1 = nums1[len1/2];
        int mid2 = nums2[len2/2];
        //2前半<2后半、1前半<1后半
        if(mid1>mid2){
        	if(k<=(len2+1)/2) return findKth(
        		Arrays.copyOfRange(nums1, 0, len1/2),
        		Arrays.copyOfRange(nums2, 0, len2/2),
        		k
        		);
        	else if(k>=len2+(len1+1)/2) return findKth(
        		Arrays.copyOfRange(nums1,(len1+1)/2,len1),
        		Arrays.copyOfRange(nums2,(len2+1)/2,len2),
        		k-k-(len2+1)/2
        		);
        	else return findKth(
        		Arrays.copyOfRange(nums1, 0, len1/2),
        		Arrays.copyOfRange(nums2,(len2+1)/2,len2),
        		k-(len2+1)/2
        		);
        }
        //1前半<1后半、2前半<2后半
        else{
        	if(k<=(1+len1)/2) return findKth(
        		Arrays.copyOfRange(nums1, 0, len1/2),
        		Arrays.copyOfRange(nums2, 0, len2/2),
        		k
        		);
        	else if(k>=len1+(1+len2)/2) return findKth(
        		Arrays.copyOfRange(nums1,(len1+1)/2,len1),
        		Arrays.copyOfRange(nums2,(len2+1)/2,len2),
        		k-k-(len2+1)/2
        		);
        	else return findKth(
        		Arrays.copyOfRange(nums1,(len1+1)/2,len1),
        		Arrays.copyOfRange(nums2, 0, len2/2),
        		k-(len1+1)/2
        		);
        }
    }

}
// 0	1	(2)	3	4
// len=5	[0,3][2,5]
// 0	1	(2)	3
// len=4	[0,2][2,4]
// 0	(1)	2
// len=3	[0,1][1,3]
// 0	(1)
// len=2	[0,1][1,2]
// (0)
// len=1
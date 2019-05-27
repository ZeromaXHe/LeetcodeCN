class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        int low = 0;
        if(nums[low]==target) return low;
        int high = nums.length - 1;
        if(nums[high]==target) return high;
        int mid = (high+low)/2;
        while(low<=high){
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                low = mid+1;
                mid = (high+low)/2;
            }
            else{
                high = mid-1;
                mid = (high+low)/2;
            }
        }
        return low;
        
    }
}

/*直接用类库的话，可以：
int res = Arrays.binarySearch(nums,target);
        if(res>=0)return res;
        else return -res-1;
*/
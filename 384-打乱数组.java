//执行用时 :353 ms, 在所有 Java 提交中击败了25.20%的用户
//内存消耗 :84.7 MB, 在所有 Java 提交中击败了35.33%的用户
class Solution {
    int[] originalArr; 
    int[] shuffleArr;
    public Solution(int[] nums) {
        originalArr = nums;
        shuffleArr = Arrays.copyOf(originalArr,originalArr.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
        //return Arrays.copyOf(originalArr,originalArr.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i=shuffleArr.length-1;i>0;i--){
            swap(shuffleArr,rand.nextInt(i+1),i);
        }
        return shuffleArr;
        //return Arrays.copyOf(shuffleArr,shuffleArr.length);
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
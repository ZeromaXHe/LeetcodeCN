class Solution {
    public int maxArea(int[] height) {
    	if(height.length<2) return 0;
    	int heightMin=-1;
        int start=0;
        int end=1;
        int maxArea=-1;
        while(start<height.length||end<height.length){
        	if(start==end) break;
        	heightMin=height[start]>height[end]?height[start]:height[end];
        	System.out.println("heightMin:"+heightMin);
        	System.out.println("area:"+(end-start)*heightMin);
        	if((end-start)*heightMin>maxArea){
        		maxArea=(end-start)*heightMin;

        		System.out.println("maxArea:"+maxArea);
        	}
        	if((end-start==1||height[end]<height[start])&&end<height.length-1){
        		end++;
        		System.out.println("end++ [start,end]:["+start+","+end+"]");
        	}
        	else {
        		start++;
        		System.out.println("start++ [start,end]:["+start+","+end+"]");
        	}
        }
        return maxArea;
    }
}
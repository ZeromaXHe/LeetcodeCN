class Solution {
    public int maxArea(int[] height) {
    	if(height.length<2) return 0;

    	int heightMin=-1;
        int start=0;
        int end=height.length-1;
        int maxArea=-1;
        while(start!=end){
        	
        	heightMin=height[start]>height[end]?height[end]:height[start];
        	//System.out.println("heightMin:"+heightMin);
        	//System.out.println("area:"+(end-start)*heightMin);
        	if((end-start)*heightMin>maxArea){
        		maxArea=(end-start)*heightMin;

        		//System.out.println("maxArea:"+maxArea);
        	}
        	if(heightMin==height[end]){
        		end--;
        		//System.out.println("end++ [start,end]:["+start+","+end+"]");
        	}
        	else {
        		start++;
        		//System.out.println("start++ [start,end]:["+start+","+end+"]");
        	}
        }
        return maxArea;
    }
}
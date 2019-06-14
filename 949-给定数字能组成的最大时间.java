//执行用时 :3 ms, 在所有Java提交中击败了77.19%的用户
//内存消耗 :34.2 MB, 在所有Java提交中击败了94.12%的用户
class Solution {
    boolean[] B=new boolean[4];
    
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        int index = findMax(2,A);
        if(index==-1) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(A[index]);
        B[index]=true;
        if(A[index]==2){
            index=findMax(3,A);
        } 
        else{
            index=findMax(9,A);
        }
        if(index==-1) return "";
        sb.append(A[index]);
        sb.append(":");
        B[index]=true;
        index = findMax(5,A);
        if(index==-1) return notStartWith2(A);
        sb.append(A[index]);
        B[index]=true;
        index = findMax(9,A);
        sb.append(A[index]);
        return sb.toString();
    }
    
    private String notStartWith2(int[] A) {
        Arrays.fill(B,false);
        int index = findMax(1,A);
        if(index==-1) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(A[index]);
        B[index]=true;
        index=findMax(9,A);
        if(index==-1) return "";
        sb.append(A[index]);
        sb.append(":");
        B[index]=true;
        index = findMax(5,A);
        if(index==-1) return "";
        sb.append(A[index]);
        B[index]=true;
        index = findMax(9,A);
        if(index==-1) return "";
        sb.append(A[index]);
        return sb.toString();
    }
    
    private int findMax(int cap,int[] A){
        int maxIndex=-1;
        int max=-1;
        for(int i=0;i<4;i++){
            if(A[i]>cap) break;
            if(B[i]) continue;
            if(A[i]>max){
                max=A[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
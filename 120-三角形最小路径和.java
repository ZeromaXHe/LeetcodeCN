//执行用时 :7 ms, 在所有 Java 提交中击败了43.18%的用户
//内存消耗 :38.1 MB, 在所有 Java 提交中击败了51.31%的用户
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size()];
        arr[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=i;j>=0;j--){
                if(j==0) arr[0]+= triangle.get(i).get(0);
                else if(j==i) arr[j]=arr[j-1]+triangle.get(i).get(j);
                else arr[j]=Math.min(arr[j-1]+triangle.get(i).get(j),arr[j]+triangle.get(i).get(j));
            }
            //System.out.println(Arrays.toString(arr));
        }
        int min = 0x3f3f3f3f;
        for(int i:arr){
            if(i<min) min=i;
        }
        return min;
    }
}
//执行用时 :4 ms, 在所有 Java 提交中击败了93.47%的用户
//内存消耗 :37.5 MB, 在所有 Java 提交中击败了64.80%的用户
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[triangle.size()];
        arr[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            for(int j=i;j>=0;j--){
                if(j==0) arr[0]+= list.get(0);
                else if(j==i) arr[j]=arr[j-1]+list.get(j);
                else arr[j]=Math.min(arr[j-1],arr[j])+list.get(j);
            }
            //System.out.println(Arrays.toString(arr));
        }
        int min = 0x3f3f3f3f;
        for(int i:arr){
            if(i<min) min=i;
        }
        return min;
    }
}
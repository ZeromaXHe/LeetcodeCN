//执行用时 :2 ms, 在所有 Java 提交中击败了99.43%的用户
//内存消耗 :44.1 MB, 在所有 Java 提交中击败了44.96%的用户
class Solution {
    public boolean validUtf8(int[] data) {
        int i=0;
        while(i<data.length){
            if(data[i]>>7==0) i++;
            else if(data[i]>>5==6){
                if(i+1>=data.length) return false;
                if(data[i+1]>>6==2) i+=2;
                else return false;
            }
            else if(data[i]>>4==14){
                if(i+2>=data.length) return false;
                if(data[i+1]>>6==2&&data[i+2]>>6==2) i+=3;
                else return false;
            }
            else if(data[i]>>3==30){
                if(i+3>=data.length) return false;
                if(data[i+1]>>6==2&&data[i+2]>>6==2&&data[i+3]>>6==2) i+=4;
                else return false;
            }
            else return false;
        }
        return true;
    }
}
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        double []dif=new double[numlist.length];
        for(int i=0;i< numlist.length;i++){
            if(numlist[i]-n<0){
                dif[i]=((int)Math.abs(numlist[i]-n))+0.5;
            }
            else{
                dif[i]=numlist[i]-n;
            }
        }
        Arrays.sort(dif);
        for(int i=0;i<numlist.length;i++){
            if(dif[i]%1!=0)
                answer[i]=n-(int)dif[i];
            else{
                answer[i]=(int)dif[i]+n;
            }
        }
        return answer;
    }
}
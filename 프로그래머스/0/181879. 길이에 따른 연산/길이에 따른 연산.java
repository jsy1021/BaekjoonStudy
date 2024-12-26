class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        if(num_list.length<=10){
            int result=1;
            for(int i=0;i<num_list.length;i++){
                result*=num_list[i];
                answer=result;
            }
        }
        else {
            for(int i=0;i<num_list.length;i++){
                answer+=num_list[i];
                }
        }
        return answer;
    }
}
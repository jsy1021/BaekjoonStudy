class Solution {
    public int solution(int[] num_list) {
        int odd=0;
        int even=0;
        int answer = 0;
        for(int i=0;i<num_list.length;i++){
            if(i%2==0){
                even+=num_list[i];
            }
            if(i%2==1){
                odd+=num_list[i];
            }
        }
        if(even>odd){
            answer=even;
        } else if (odd>even) {
            answer=odd;
        }
        else{
            answer=even;
        }

        return answer;
    }
}
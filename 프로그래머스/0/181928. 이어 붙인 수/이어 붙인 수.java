class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd_sum="";
        String even_sum="";
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2==0){
                even_sum+=num_list[i];
            }
            else{
                odd_sum+=num_list[i];
            }
        }
        answer=Integer.parseInt(even_sum)+Integer.parseInt(odd_sum);
        return answer;
    }
}
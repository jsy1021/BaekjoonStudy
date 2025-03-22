class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String r1=String.valueOf(a)+String.valueOf(b);
        String r2=String.valueOf(b)+String.valueOf(a);
        if(Integer.parseInt(r1)>=Integer.parseInt(r2))
            answer=Integer.parseInt(r1);
        else{
            answer=Integer.parseInt(r2);
        }


        return answer;
    }
}
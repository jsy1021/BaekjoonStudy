class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s=s.toLowerCase();
        int s_count=0;
        int p_count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p')
                p_count++;
            if(s.charAt(i)=='y')
                s_count++;
        }
        if(p_count==s_count){
            return true;
        }
        else
            return false;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    }
}
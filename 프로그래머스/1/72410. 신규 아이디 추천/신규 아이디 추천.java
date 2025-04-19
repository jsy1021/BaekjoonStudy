class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer=new_id.toLowerCase();//1단계
        answer=answer.replaceAll("[^a-z0-9-_.]","");//2단계
        answer=answer.replaceAll("[.]{2,}",".");//3단계
        answer = answer.replaceFirst("^\\.", "");
        answer = answer.replaceFirst("\\.$", "");//4단계
        if(answer.equals(""))
        {
            answer="a";
        }
        if (answer.length() >= 16) { // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceFirst("\\.$", ""); // 잘랐을 때 끝이 .이면 제거
        }
        if(answer.length()<=2){
            char lastchar=answer.charAt(answer.length()-1);
            for(int i=0;i<3;i++){
                answer+=lastchar;
            }
            answer=answer.substring(0,3);
        }
    return answer;
    }
}
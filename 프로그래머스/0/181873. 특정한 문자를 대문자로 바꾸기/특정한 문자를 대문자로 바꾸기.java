class Solution {
   public String solution(String my_string, String alp){
        StringBuilder sb=new StringBuilder();
        char find=alp.charAt(0);
        for(int i=0;i<my_string.length();i++){
            char current=my_string.charAt(i);
            if(current==find){
                sb.append(Character.toUpperCase(current));
            }
            else{
                sb.append(current);
            }
        }

        return sb.toString();
    }
}
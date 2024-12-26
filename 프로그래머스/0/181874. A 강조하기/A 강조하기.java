class Solution {
    public String solution(String myString) {
        StringBuilder sb=new StringBuilder();
        myString=myString.toLowerCase();
        for(int i=0;i<myString.length();i++){
            char current=myString.charAt(i);
            if(current=='a'){
                sb.append(Character.toUpperCase(current));
            }
            else{
                sb.append(current);
            }
        }

        return sb.toString();
    }
}
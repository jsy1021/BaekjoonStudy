class Solution {
    public int solution(String myString, String pat) {
        StringBuilder str = new StringBuilder();  // StringBuilder 사용

        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (c == 'A') {
                str.append('B');
            } else if (c == 'B') {
                str.append('A');
            }
        }
        if(str.toString().contains(pat)){
            return 1;
        }
        else{
            return 0;
        }
    }
}
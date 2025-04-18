import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character>stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        

        return stack.isEmpty();
    }
}
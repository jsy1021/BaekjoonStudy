import java.util.*;
class Solution {
    public int solution(String s){
        String str=s+s;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(isValid(str.substring(i,s.length()+i)))
                count++;
        }
        return count;
    }
    public boolean isValid(String s){
        Deque<Character> stack=new ArrayDeque<>();
        for(char current: s.toCharArray()){
            if(current=='['||current=='{'||current=='('){
                stack.push(current);
            }
            else{
                if(stack.isEmpty())
                    return false;
                char target=stack.pop();
                if ((target == '(' && current == ')') ||
                        (target == '{' && current == '}') ||
                        (target == '[' && current == ']')) {
                    continue; // 올바른 짝이면 계속 진행
                } else {
                    return false; // 짝이 맞지 않으면 false
                }
            }
        }
        return stack.isEmpty();
    }
}
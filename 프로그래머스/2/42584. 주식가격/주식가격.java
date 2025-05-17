import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택 top보다 낮아졌다면 answer에 계산
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 인덱스 처리
        while (!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = n - 1 - top;
        }

        return answer;
    }
}
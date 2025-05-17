import java.util.*;
class Solution {
    public int solution(String s) {
    int answer = s.length();

    for (int step = 1; step <= s.length() / 2; step++) {
        StringBuilder compressed = new StringBuilder();
        String prev = s.substring(0, step);
        int count = 1;

        for (int j = step; j <= s.length(); j += step) {
            String next;
            if (j + step <= s.length()) {
                next = s.substring(j, j + step);
            } else {
                next = s.substring(j);
            }

            if (prev.equals(next)) {
                count++;
            } else {
                if (count > 1) compressed.append(count);
                compressed.append(prev);
                prev = next;
                count = 1;
            }
        }

        // 마지막 남은 문자열 처리
        if (count > 1) compressed.append(count);
        compressed.append(prev);

        answer = Math.min(answer, compressed.length());
    }

    return answer;
}
}
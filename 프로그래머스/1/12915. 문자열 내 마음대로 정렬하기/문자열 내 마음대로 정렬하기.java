import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2); // 같은 문자라면 사전순 비교
            }
            return Character.compare(s1.charAt(n), s2.charAt(n)); // n번째 문자 기준 비교
        });
        return strings;
    }
}
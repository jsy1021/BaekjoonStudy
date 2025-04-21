class Solution {
     public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String base = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);

                if (base.equals(compare)) {
                    count++;
                } else {
                    if (count > 1) result.append(count);
                    result.append(base);
                    base = compare;
                    count = 1;
                }
            }

            result.append(base); // 마지막 조각 추가
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
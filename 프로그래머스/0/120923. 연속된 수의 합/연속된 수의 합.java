import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int num, int total) {
        List<Integer> result = new ArrayList<>();
        int start = (total / num) - (num - 1) / 2;

        for (int i = 0; i < num; i++) {
            result.add(start + i);
        }
        int[] array=result.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}
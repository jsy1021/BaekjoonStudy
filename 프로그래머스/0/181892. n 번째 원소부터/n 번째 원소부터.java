import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] num_list, int n) {
        // 결과 배열의 크기: 전체 크기 - (n-1)
        int[] result = new int[num_list.length - (n - 1)];
        
        // n번째 원소부터 복사
        for (int i = 0; i < result.length; i++) {
            result[i] = num_list[n - 1 + i];
        }
        
        return result;
    }
}
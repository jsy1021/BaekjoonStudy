import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 이진 탐색 전 정렬

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid_index = (start + end) / 2;
                int mid_value = arr[mid_index];

                if(mid_value < target) {
                    start = mid_index + 1;
                } else if(mid_value > target) {
                    end = mid_index - 1;
                } else {
                    find = true;
                    break;
                }
            }

            System.out.println(find ? 1 : 0);
        }
    }
}
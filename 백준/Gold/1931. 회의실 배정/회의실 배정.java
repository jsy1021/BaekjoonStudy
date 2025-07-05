import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][]arr = new int[n][2];//배열 사이즈 할당
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
            //배열에 저장
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] start, int[] end){
                if(start[1]==end[1]){//끝나는 시간이 같은 경우 //시작시간이 빠른 순서대로 정렬
                    return start[0]-end[0];//해당 처리를 하지 않을 경우(2,2),(1,2)가 있을 때 (2,2)만 수행하여 최대값이 나오지 않을 수 있음
                }
                return start[1]-end[1];//종료시간 기준 오름차순
            }
        });
        int count=0;
        int end=0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>=end){
                end=arr[i][1];//종료시간 업데이트
                count++;
            }
        }
        System.out.println(count);
    }
}
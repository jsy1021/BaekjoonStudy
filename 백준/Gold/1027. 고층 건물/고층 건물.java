import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    //백준 1027번
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for(int i=0;i<N;i++){
            heights[i]=Integer.parseInt(st.nextToken());
        }
        int maxCount=0;
        for(int i=0;i<N;i++){
            double left_slope = -1000000000; //왼쪽 기울기 최대
            double right_slope = -1000000000; //오른쪽 기울기 최대

            int left_count=0;
            int right_count=0;

            for(int j=i-1;j>=0;j--){
                //기준에서 왼쪽 기울기 계산
                double temp=(double)(heights[j]-heights[i])/(i-j);
                if(temp>left_slope){
                    left_slope=temp;
                    left_count++;
                }
            }
            for(int j=i+1;j<N;j++){
                //기준에서 오른쪽 기울기 계산
                double temp=(double)(heights[j]-heights[i])/(j-i);
                if(temp>right_slope){
                    right_slope=temp;
                    right_count++;
                }
            }
            if((left_count+right_count)>maxCount)
                maxCount=left_count+right_count;
        }
        System.out.println(maxCount);
    }
}
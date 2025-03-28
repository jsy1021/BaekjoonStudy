import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int arr[]=new int[n+1];
        int sum[]=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){ //구간 합 배열 완성
            sum[i]=arr[i]+sum[i-1];
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            System.out.println(sum[end]-sum[start-1]);
        }
    }
}
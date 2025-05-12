import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int []arr=new int[n];
        int [][]origin=new int [n][2];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<n;i++){
            origin[i][0]=arr[i]; //값
            origin[i][1]=i;//원본 인덱스
        }
        Arrays.sort(origin,(a,b)->a[0]-b[0]);

        int maxMove=0;
        for(int i=0;i<n;i++){
            if(maxMove<origin[i][1]-i){
                maxMove=origin[i][1]-i;
            }
        }
        System.out.println(maxMove+1);
    }
}

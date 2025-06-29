import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        int count=0;
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]>k)
                continue;
            else{
                count+=k/arr[i];
                k=k%arr[i];
            }
        }
        System.out.println(count);
    }
}
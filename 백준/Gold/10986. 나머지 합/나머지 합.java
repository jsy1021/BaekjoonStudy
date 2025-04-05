import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
       //Scanner sc = new Scanner(System.in);
       int n=Integer.parseInt(st.nextToken());
       int m=Integer.parseInt(st.nextToken());
       int[] arr =new int[n];
       long[] sum = new long[n];
       long[] count=new long[m];
       long ans=0;
       st=new StringTokenizer(br.readLine());
       for(int i=0;i<n;i++){
           arr[i]=Integer.parseInt(st.nextToken());
       }
       sum[0]=arr[0];
       for(int i=1;i<n;i++){
           sum[i]=sum[i-1]+arr[i];
       }
       for(int i=0;i<n;i++){
           if(sum[i]%m==0){
               ans++;
           }
           count[(int) (sum[i]%m)]++;
       }
       for(int i=0;i<m;i++){
           if(count[i]>1){
               ans+=(count[i]*(count[i]-1)/2);
           }
       }
        System.out.println(ans);
    }
}
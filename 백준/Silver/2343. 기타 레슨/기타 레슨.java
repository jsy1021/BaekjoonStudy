import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
     public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        int sum=0;
        int max=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(max<arr[i])
                max=arr[i];
            sum+=arr[i];
        }

        int start=max;
        int end=sum;
        int answer=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(isPossible(arr,m,mid)){
                answer=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        System.out.println(answer);
    }
    public static boolean isPossible(int []arr,int m, int capacity){
        int count=1;//초기 블루레이 개수
        int sum=0;
        for(int lesson: arr){
            if(sum+lesson>capacity){
                count++;
                sum=0;
            }
            sum+=lesson;    //레슨 담기
        }
        return count<=m;//나눈 블루레이 수가 요구하는 m보다 작거나 같으면 더 작게 나눠야함
    }
}
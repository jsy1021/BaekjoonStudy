import java.util.*;
public class Main{
    //백준 1300번 K번째 수
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        long low=1;
        long high=k;
        while(low<=high){
            long mid=(low+high)/2;
            long count=0;

            for(int i=1;i<=n;i++){
                count+=Math.min(mid/i,n);
            }
            if(k<=count){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println(low);
    }
}
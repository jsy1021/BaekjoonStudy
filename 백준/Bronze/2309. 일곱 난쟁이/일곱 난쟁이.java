import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int []arr=new int[9];
        int sum=0;
        for(int i=0;i<9;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        outer:
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                if(sum-arr[i]-arr[j]==100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    break outer;
                }
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<9;i++){
            if(arr[i]!=-1){
                System.out.println(arr[i]);
            }
        }
    }
}
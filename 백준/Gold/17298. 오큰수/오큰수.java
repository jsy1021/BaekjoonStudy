import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        int []nge=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            nge[i]=-1;
        }
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                int index=stack.pop();
                nge[index]=arr[i];//nge배열에 저장
            }
            stack.push(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(nge[i]).append(" ");
        }
        System.out.println(sb);
    }
} 
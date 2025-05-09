import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;//절댓값이 같은 경우 작은 수 오름차순
                }
                else{
                    return Math.abs(o1)-Math.abs(o2);
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else 
                    sb.append(pq.poll()).append("\n");
            }
            else{
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}
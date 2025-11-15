import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
     //백준 1516 게임 개발하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>>arrayList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }
        int [] indegree=new int[n+1];
        int [] selfBuild=new int[n+1];
        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            selfBuild[i]=Integer.parseInt(st.nextToken());
            while(true){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==-1)
                    break;
                arrayList.get(temp).add(i);
                indegree[i]++;//진입차수 증가
            }
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int [] result=new int[n+1];
        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int next:arrayList.get(now)){
                indegree[next]--;
                result[next]=Math.max(result[next],result[now]+selfBuild[now]);
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println(selfBuild[i]+result[i]);
        }
    }
}
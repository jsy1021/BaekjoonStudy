import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>>arrayList=new ArrayList();
        int []indegree=new int[n+1];
        for(int i=0;i<=n;i++){//2차원 리스트로 리스트 할당
            arrayList.add(new ArrayList());
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            indegree[b]++; //진입차수 증가
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=1;i<=n;i++){ //진입차수가 0인 노드 탐색 후 큐에 할당
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now=queue.poll();
            System.out.print(now+" ");
            for(int next:arrayList.get(now)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.add(next);
                }
            }
        }
    }
}
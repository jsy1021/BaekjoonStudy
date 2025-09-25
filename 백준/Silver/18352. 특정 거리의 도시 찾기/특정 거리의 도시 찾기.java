import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    //백준 18352 특정 거리의 도시 찾기
    static List<Integer>[] arr;
    static List<Integer>answer;
    static int[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        arr=new ArrayList[n+1];
        answer=new ArrayList<>();
        visited=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        Arrays.fill(visited, -1); // 초기값 -1
        BFS(x);
        for(int i=0;i<=n;i++){
            if(visited[i]==k){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println("-1");
        }
        else{
            Collections.sort(answer);
            for(int tmp:answer){
                System.out.println(tmp);
            }
        }
    }
    private static void BFS(int Node){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(Node);
        visited[Node]++;
        while(!queue.isEmpty()){
            int now_node=queue.poll();
            for(int i:arr[now_node]){
                if(visited[i]==-1){
                    visited[i]=visited[now_node]+1;
                    queue.add(i);
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    static boolean []visited;
    static int [] distance;
    static ArrayList<Edge>[] edges;
    static class Edge{
        int e; //다음 노드
        int value; //경로까지의 가중치
        Edge(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
    static void BFS(int index){
        Queue<Integer>q=new LinkedList<>();
        q.add(index);
        visited[index]=true;
        while(!q.isEmpty()){
            int now_node=q.poll();
            for(Edge e:edges[now_node]){
                int node=e.e;
                int v=e.value;
                if(!visited[node]){
                    visited[node]=true;
                    q.add(node);
                    distance[node]=distance[now_node]+v;
                }
            }
        }
    }
    //백준 1167 트리의 지름 구하기
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        edges=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            edges[i]=new ArrayList<Edge>();
        }
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int S=Integer.parseInt(st.nextToken());
            while(true) {
                int E = Integer.parseInt(st.nextToken());
                if (E == -1)
                    break;
                int V = Integer.parseInt(st.nextToken());
                edges[S].add(new Edge(E, V));
            }
        }
        int max=1;
        distance=new int[N+1];
        visited=new boolean[N+1];
        BFS(1);
        for(int i=2;i<=N;i++){
            if(distance[max]<distance[i]){
                max=i;
            }
        }
        distance=new int[N+1];
        visited=new boolean[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
}
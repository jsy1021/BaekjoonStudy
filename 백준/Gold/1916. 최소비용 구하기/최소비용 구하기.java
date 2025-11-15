import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
        static class Edge implements Comparable<Edge>{
        int node;
        int cost;

    public Edge(int end, int cost) {
        this.node = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {

        return this.cost - o.cost; // 가중치 오름차순
    }
}
    static int N, M;
    static ArrayList<ArrayList<Edge>>list=new ArrayList<>();
    static int []distance;
    static boolean []visited;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        distance=new int[N+1];
        visited=new boolean[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);// 거리 리스트 최대값 저장
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            list.get(start).add(new Edge(end,cost));
        }
        st=new StringTokenizer(br.readLine());
        int startIndex=Integer.parseInt(st.nextToken());
        int endIndex=Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex,endIndex)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dijkstra(int start, int end){
        pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        distance[start]=0;
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            int now_node=e.node;
            if(!visited[now_node]){
                visited[now_node]=true;
                for(Edge next: list.get(now_node)){
                    if(!visited[next.node]){
                        if(distance[next.node]>distance[now_node]+next.cost){
                            distance[next.node]=distance[now_node]+next.cost;//최소값으로 업데이트
                            pq.add(new Edge(next.node,distance[next.node]));
                        }
                    }
                }
            }
        }
        return distance[end];
    }
}
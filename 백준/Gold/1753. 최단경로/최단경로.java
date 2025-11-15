import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    //백준 1753 최단 경로
    public static int V, E, K;
    public static int []distance;
    public static boolean [] visited;
    public static ArrayList<ArrayList<Node>>list=new ArrayList<>();
    public static PriorityQueue<Node> pq=new PriorityQueue<>();
    static class Node implements Comparable<Node> {
        int node;
        int value;

        Node(int node, int value){
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value; // 가중치 오름차순
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance=new int[V+1];
        visited=new boolean[V+1];
        for(int i=0;i<=V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<=V;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v,w));
        }
        pq.add(new Node(K,0));
        distance[K]=0;
        while(!pq.isEmpty()){
            Node current=pq.poll();
            int currentNode=current.node;
            visited[currentNode]=true;
            for(Node tmp :list.get(currentNode)){
               int nextNode=tmp.node;
               int nextValue=tmp.value;
               if(distance[nextNode]>distance[currentNode]+nextValue){//최소 거리로 업데이트하기
                   distance[nextNode]=distance[currentNode]+nextValue;
                   pq.add(new Node(nextNode,distance[nextNode]));
               }
            }
        }
        for(int i=1;i<=V;i++){
            if(visited[i]){
                System.out.println(distance[i]);
            }
            else{
                System.out.println("INF");
            }
        }
    }
}
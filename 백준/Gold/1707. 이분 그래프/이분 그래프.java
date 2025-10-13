import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int t=0; t<K; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arr = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;

            for(int i=1; i<=V; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
                arr[b].add(a);
            }

            for(int i=1; i<=V; i++){
                if(!visited[i]){
                    DFS(i);
                    if(!IsEven) break;
                }
            }

            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void DFS(int node){
        visited[node] = true;

        for(int next : arr[node]){
            if(!visited[next]){
                check[next] = (check[node] + 1) % 2; // 반대 색깔로
                DFS(next);
            }else if(check[node] == check[next]){
                IsEven = false;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    static List<List<Integer>>list =new ArrayList<>();
    static boolean [] visited;
    static int N,M;
    static boolean arrive;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N];
        for(int i=0;i<N;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0;i<N;i++){
            DFS(i,1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else{
            System.out.println("0");
        }
    }
    public static void DFS(int now, int depth){
        if(depth==5||arrive){
            arrive=true;
            return;
        }
        visited[now]=true;
        for(int i:list.get(now)){
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[now]=false;
    }
}
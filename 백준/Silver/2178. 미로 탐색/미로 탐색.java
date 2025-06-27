import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    
	static int N,M;
    static int [][]arr;
    static boolean[][] visited;
    static int []dx={0,0,1,-1};
    static int []dy={1,-1,0,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=line.charAt(j)-'0';
            }
        }
        
        BFS(0,0);
        System.out.println(arr[N-1][M-1]);
    }
    static void BFS(int x,int y){
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y]=true;
        while(!q.isEmpty()){
            int []now=q.poll();
            int now_x=now[0];
            int now_y=now[1];
            for(int i=0;i<4;i++){
                int next_x=now_x+dx[i];
                int next_y=now_y+dy[i];
                if(range(next_x,next_y)&&!visited[next_x][next_y]&&arr[next_x][next_y]!=0){
                    visited[next_x][next_y]=true;
                    arr[next_x][next_y]=arr[now_x][now_y]+1;
                    q.offer(new int[]{next_x,next_y});
                }
            }
        }
    }
    static boolean range(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<M)
            return true;
        return false;
    }
}
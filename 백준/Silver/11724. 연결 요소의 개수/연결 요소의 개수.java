import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
		static int [][]arr;
		static boolean [] checked;
		static int N;
		static int M;
		static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
		checked=new boolean[N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x][y]=arr[y][x]=1;
		}
		
		checked=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			if(checked[i]==false) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs(int index) {
		if(checked[index]==true)
			return;
		else
		{
			checked[index]=true;
			for(int i=1;i<=N;i++) {
				if(arr[index][i]==1) {
					dfs(i);
				}
			}
		}
		
	}
}

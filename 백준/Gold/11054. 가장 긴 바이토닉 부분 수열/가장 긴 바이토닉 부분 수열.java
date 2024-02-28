import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		int dp_u[] = new int[n+1];
		int dp_d[]= new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp_u[0] = 1;
		dp_d[n-1]=1;
		for (int i = 1; i < n; i++) {
			dp_u[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp_u[i] <= dp_u[j]) {
					dp_u[i] = dp_u[j] + 1;
				}
			}
		}
		
		for (int i = n-2; i >= 0; i--) {
			dp_d[i] = 1;
			for (int j = n-1; j > i; j--) {
				if (arr[j] < arr[i] && dp_d[i] <= dp_d[j]) {
					dp_d[i] = dp_d[j] + 1;
				}
			}
		}
		
		int max=-1;
		for(int i=0;i<n;i++) {
			if(max<Math.max(dp_u[i]+dp_d[i], max))
				max=Math.max(dp_u[i]+dp_d[i], max);
		}
		System.out.println(max-1);
	}
}
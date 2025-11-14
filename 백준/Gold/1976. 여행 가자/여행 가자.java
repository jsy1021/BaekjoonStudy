import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
    //백준 1976번 여행 가자
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        parent = new int[n+1];
        int [][]city = new int[n+1][n+1];
        int routes[]=new int[m+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int i=1;i<=n;i++){//도시 연결 데이터 저장
            for(int j=1;j<=n;j++){
                city[i][j]=sc.nextInt();
            }
        }
        for(int i=1;i<=m;i++){ //여행 경로
            routes[i]=sc.nextInt();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(city[i][j]==1)
                    union(i,j);
            }
        }
        int find_path=find(routes[1]);
        for(int i=2;i<routes.length;i++){
            if(find_path!=find(routes[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            parent[b]=a;
        }
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}
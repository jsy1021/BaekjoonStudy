import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main{
    //백준 1717번 집합의 표현
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i; //자기 자신의 인덱스로 대표 노드 설정
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int choice=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(choice==0){
                union(a,b);
            }
            else{
                if(check(a,b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
    public static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            parent[b]=a;
        }
    }
    public static int find(int a){
        if(a==parent[a]){
            return a; //부모, 즉 대표 노드가 같다면 대표노드 리턴
        }
        else{
            return parent[a]=find(parent[a]);
        }
    }
    public static boolean check(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b){
            return true;
        }
        return false;
    }
}
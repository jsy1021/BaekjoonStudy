import java.util.*;
public class Main{
        //백준 1043 거짓말
    public static int[] parent;
    public static int[] truePeople;
    public static ArrayList<Integer>[] party;
    public static int result;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int t=sc.nextInt();
        result=0;
        truePeople=new int[t];
        party=new ArrayList[m];
        for(int i=0;i<t;i++){
            truePeople[i]=sc.nextInt();//진실을 아는 사람 저장
        }
        for(int i=0;i<m;i++){
            party[i]=new ArrayList<>();
            int size=sc.nextInt();
            for(int j=0;j<size;j++){
                party[i].add(sc.nextInt());
            }
        }
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<m;i++){
            int first=party[i].get(0);
            for(int j=1;j<party[i].size();j++){
                union(first,party[i].get(j));
            }
        }
        for(int i=0;i<m;i++){
            boolean flag=true;
            int current=party[i].get(0);
            for(int j=0;j< truePeople.length;j++){
                if(find(current)==find(truePeople[j])){
                    flag=false;
                    break;
                }
            }
            if(flag)
                result++;
        }
        System.out.println(result);
    }
    public static void union(int first,int second){
        first=find(first);
        second=find(second);
        if(first!=second){
            parent[second]=first;
        }
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
   
}
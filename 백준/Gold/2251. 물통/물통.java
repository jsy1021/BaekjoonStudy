import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{ 
    static class Water{
        int a;
        int b;
        int c;
        public Water(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    static int a,b,c;
    static ArrayList<Integer>answer=new ArrayList<>();
    static boolean[][][]visited=new boolean[201][201][201]; //물통 검사 여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        Queue<Water>queue=new LinkedList<>();
        queue.add(new Water(0,0,c));

        while(!queue.isEmpty()){
            Water water=queue.poll();

            if(visited[water.a][water.b][water.c]){
                continue;   //이미 검사했던 물통이면 패스
            }
            else{
                visited[water.a][water.b][water.c]=true; //처음 체크되는 물통이면 체크
            }

            if(water.a==0){
                answer.add(water.c);//첫번째 물통이 비어있을 때 c의 물 양 체크
            }

            /* 총 6개의 (a,b) ,(a,c), (b,a), (b,c), (c,a), (c,b) 검사
            a-b a-c b-c 관계별로 queue에 할당 후 체크
             */
            //a-b 체크
            if(water.a+ water.b>a){
                queue.add(new Water(a,water.a+water.b-a,water.c));
            }
            else{
                queue.add(new Water(water.a+water.b,0,water.c));
            }
            if(water.a+water.b>b){
                queue.add(new Water(water.a+water.b-b,b,water.c));
            }
            else{
                queue.add(new Water(0,water.a+water.b,water.c));
            }
            //b-c 체크
            if(water.b+ water.c>b){
                queue.add(new Water(water.a,b,water.b+water.c-b));
            }
            else{
                queue.add(new Water(water.a,water.b+water.c,0));
            }
            if(water.b+water.c>c){
                queue.add(new Water(water.a,water.b+water.c-c,c));
            }
            else{
                queue.add(new Water(water.a,0,water.b+water.c));
            }
            //a-c 체크
            if(water.a+ water.c>a){
                queue.add(new Water(a,water.b,water.a+water.c-a));
            }
            else{
                queue.add(new Water(water.a+water.c,water.b,0));
            }
            if(water.a+ water.c>c){
                queue.add(new Water(water.a+water.c-c,water.b,c));
            }
            else{
                queue.add(new Water(0,water.b,water.a+water.c));
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int a : answer) {
            set.add(a);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }

        System.out.println(sb);
    }
}
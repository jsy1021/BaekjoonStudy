import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;//절댓값이 같은 경우 작은 수 오름차순
                }
                else{
                    return Math.abs(o1)-Math.abs(o2);
                }
            }
        });
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            if(x==0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(x);
            }
        }
    }
}
import java.util.*;
public class Main{
    //백준 1744 수 묶기
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());//큰 순서부터 정렬(양수 저장 우선순위 큐)
        PriorityQueue<Integer>pq2=new PriorityQueue<>();//음수 저장 우선순위 큐
        int one_count=0; //1의 개수 카운트
        int zero_count=0;//0의 개수 카운트
        int result=0;
        for(int i=0;i<N;i++){//각각의 값 저장
            int x=sc.nextInt();
            if(x>=2){
                pq.add(x);
            }
            else if(x==1){
                one_count++;
            }
            else if(x==0){
                zero_count++;
            }
            else{
                pq2.add(x);
            }
        }
        //양수는 pq사이즈가 2미만까지 큐에서 2개씩 뺀 후 곱하여 result에 합
        while(pq.size()>=2){
            int num1=pq.poll();
            int num2=pq.poll();
            result+=num1*num2;
        }
        if(!pq.isEmpty()){
            result+=pq.poll();
        }
        while(pq2.size()>=2){
            int num1=pq2.poll();
            int num2=pq2.poll();
            result+=num1*num2;
        }
        if(!pq2.isEmpty()){
            if(zero_count>=1){
                result+=pq2.poll()*0;
                zero_count--;
            }
            else{
                result+=pq2.poll();
            }
        }
        if(one_count>=1){
            result+=one_count;
        }
        System.out.println(result);
    }
}
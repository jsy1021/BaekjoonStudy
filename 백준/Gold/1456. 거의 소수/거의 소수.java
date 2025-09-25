import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    //백준 1456 거의 소수
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long[] prime =new long[10000001];//최대 범위가 10^14의 제곱근까지 저장할 범위

        int count=0;//범위 내 거의 소수 카운트
        //입력시 범위가 10^12이므로 long과 같은 큰 정수형 사용!
        long A=Long.parseLong(st.nextToken());
        long B=Long.parseLong(st.nextToken());

        //소수 구하기(범위는 2~루트B까지(B까지 구할 필요가 없는 이유는 그보다 큰 소수들은 제곱부터 B를 넘어서기 때문에 범위안에 들어가지 않음))
        for(int i=2;i<prime.length;i++){
            prime[i]=i;//소수 배열 초기화
        }
        for(int i=2;i<Math.sqrt(prime.length);i++){
            if(prime[i]==0)
                continue;
            for(int j=i+i;j<prime.length;j=j+i){
                prime[j]=0;//배수 제거
            }
        }
        for(int i=2;i<10000001;i++){
            if(prime[i]!=0){
                long temp=prime[i];
                while((double)prime[i]<=(double)B/(double)temp){//B의 범위에 포함되는지 판단
                    if((double)prime[i]>=(double)A/(double)temp){
                        count++;
                    }
                    temp=temp*prime[i];
                }
            }
        }
        System.out.println(count);
    }
}
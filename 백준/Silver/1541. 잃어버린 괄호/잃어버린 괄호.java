import java.util.*;
public class Main{
    //백준 1541
    static int answer=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] str=input.split("-");
        for(int i=0;i<str.length;i++){
            int tmp=splitsum(str[i]);
            if(i==0){
                answer=answer+tmp;//가장 앞에 있는 값만 더함
            }
            else{
                answer-=tmp;
            }
        }
        System.out.println(answer);
    }
    static int splitsum(String s){
        int sum =0;
        String[] arr=s.split("\\+");
        for(int i=0;i<arr.length;i++){
            sum+=Integer.parseInt(arr[i]);
        }
        return sum;
    }
}
import java.util.*;
public class Main{
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    Stack<Integer>stack=new Stack<>();
    int n=sc.nextInt();
    int []arr=new int[n];
    for(int i=0;i<n;i++){
        int num=sc.nextInt();
        arr[i]=num;
    }
    int current=1;
    boolean flag=true;
    StringBuilder st=new StringBuilder();
    for(int i=0;i<n;i++){
        int target=arr[i];
        while(current<=target){
            stack.push(current++);
            st.append("+\n");
        }
        if(stack.peek()==target){
            stack.pop();
            st.append("-\n");
        }
        else{
            flag=false; //수열 불가능한 경우
            break;
        }
    }
    if(flag){
        System.out.println(st);
    }
    else{
        System.out.println("NO");
    }
    }
}


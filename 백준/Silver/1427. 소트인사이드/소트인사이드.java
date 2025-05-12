import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<Integer> list=new ArrayList<>();
        while(n!=0) {
            int left = n % 10;
            list.add(left);
            n /= 10;
        }
        Collections.sort(list, Collections.reverseOrder());

        for(int num:list) {
            System.out.print(num);
        }
    }
}

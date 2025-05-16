import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1=br.readLine();
        String input2=br.readLine();
        char []alpha_1=new char[26];
        char []alpha_2=new char[26];
        int sum=0;
        for(int i=0;i<input1.length();i++){
            alpha_1[input1.charAt(i)-'a']++;
        }
        for(int i=0;i<input2.length();i++){
            alpha_2[input2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(alpha_1[i]!=alpha_2[i]){
                if(alpha_1[i]>alpha_2[i])
                    sum+=alpha_1[i]-alpha_2[i];
                else if (alpha_1[i]<alpha_2[i]) {
                    sum+=alpha_2[i]-alpha_1[i];
                }
            }
        }
        System.out.println(sum);
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
public class Main {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count=Integer.parseInt(br.readLine());
		String temp=br.readLine();
		int sum=0;
		for(int i=0;i<count;i++)
		{
			sum+=temp.charAt(i)-'0';
		}
		bw.append(String.valueOf(sum));//String.valueOf( )는 문자열 형태로 데이터가 저장됨.
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        // 위쪽 삼각형
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i - 1; k++) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 아래쪽 삼각형
        for (int i = n - 2; i >= 0; i--) {
            for (int k = 0; k < n - i - 1; k++) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
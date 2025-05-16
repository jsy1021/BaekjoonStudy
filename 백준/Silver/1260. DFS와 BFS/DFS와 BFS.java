import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] checked;
    static int n, m, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 입력 받아서 양방향 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        // 인접 리스트 정렬 (오름차순 방문을 위해)
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        checked = new boolean[n + 1];
        dfs(start);
        System.out.println();

        checked = new boolean[n + 1];
        bfs(start);
    }

    static void dfs(int v) {
        checked[v] = true;
        System.out.print(v + " ");
        for (int next : list.get(v)) {
            if (!checked[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        checked[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : list.get(now)) {
                if (!checked[next]) {
                    checked[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
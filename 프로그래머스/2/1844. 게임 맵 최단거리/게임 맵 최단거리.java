import java.util.*;
class Solution {
    static int n;
    static int m;
    int []dx={0,0,1,-1};
    int []dy={1,-1,0,0};
    public int solution(int[][] maps) {
        int answer = 0;
        n=maps.length;
        m=maps[0].length;
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    public boolean range(int x,int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
    public void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];
            
            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                
                
                if(range(nX,nY)&&visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
            
        }
    }
}
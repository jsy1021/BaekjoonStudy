class Solution {
    public int solution(String[][]board, int h, int w){
        String find_str=board[h][w];
        int answer=0;
        int [] dx ={0,1,-1,0};
        int[] dy ={1,0,0,-1};
        for(int i=0;i<4;i++){
            int nx=w+dx[i];
            int ny=h+dy[i];
            if(nx>=0&&nx<board[h].length&&ny>=0&&ny<board.length){
                if(board[h][w].equals(board[ny][nx])){
                    answer++;
                }
            }
        }
        return answer;
    }
}
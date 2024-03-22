import sys
sys.setrecursionlimit(10**6)

def dfs(x,y,count,color):
    arr[x][y]=0
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<= nx <M and 0<=ny<N:
            if arr[nx][ny]==color:
                count=dfs(nx,ny,count+1, color)
    return count


N, M=map(int,input().split())
arr=[list((input())) for _ in range(M)]
dx=[0,0,1,-1]
dy=[1,-1,0,0]

white, blue=0,0
for i in range(M):
  for j in range(N):
    if(arr[i][j] == 'W'):
      white += (dfs(i, j, 1, 'W'))**2
    elif(arr[i][j] == 'B'):
      blue += (dfs(i, j, 1, 'B'))**2

print(white, blue)

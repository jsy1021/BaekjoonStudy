import sys
from collections import deque
input=sys.stdin.readline
dx=[0,0,-1,1]
dy=[1,-1,0,0]
def bfs(x,y):
    queue.append((x,y))
    visited[x][y]=True
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<N and 0<=ny<N and arr[nx][ny] == arr[x][y] and not visited[nx][ny]:
                visited[nx][ny] = 1  
                queue.append((nx,ny))
   
N=int(input())
arr=[list(map(str,input().strip())) for _ in range(N)]
queue=deque()

# 색약이 아닌 경우
count1=0
visited=[[False]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            count1+=1

#색약인 경우 R 와 G를 같은 경우로 봄
count2=0
for i in range(N):
    for j in range(N):
        if arr[i][j]=='G':
            arr[i][j]='R'
visited=[[False]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            count2+=1

print(count1, count2)
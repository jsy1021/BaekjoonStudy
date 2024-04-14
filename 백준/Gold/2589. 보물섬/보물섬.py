import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
arr=[list(input()) for _ in range(n)]
dx=[1,-1,0,0]
dy=[0,0,1,-1]

def bfs(x,y):
    queue=deque()
    queue.append((x,y))
    visited=[[0]*m for _ in range(n)]
    visited[x][y]=1
    count=0
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            elif arr[nx][ny]=='L' and visited[nx][ny]==0:
                    visited[nx][ny]=visited[x][y]+1
                    count=max(count,visited[nx][ny])
                    queue.append((nx,ny))
    return count-1

result=0
for i in range(n):
    for j in range(m):
        if arr[i][j]=='L':
            result=max(result,bfs(i,j))
    
print(result)
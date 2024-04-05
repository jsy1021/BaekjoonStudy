import sys
from collections import deque
input=sys.stdin.readline
dx=[0,0,-1,1,0,0]
dy=[1,-1,0,0,0,0]
dz=[0,0,0,0,1,-1]
q=deque()

def bfs():
    while q:
        z,x,y=q.popleft()
        for i in range(6):
            nx,ny,nz=x+dx[i],y+dy[i],z+dz[i]
            if 0<=nx<n and 0<=ny<m and 0<=nz<h:
                if arr[nz][nx][ny]==0:
                    arr[nz][nx][ny]=arr[z][x][y]+1
                    q.append((nz,nx,ny))
    
    

m,n,h=map(int,input().split())

arr=[[list(map(int,input().split()))for _ in range(n)] for _ in range(h)]

for i in range(h):
    for j in range(n):
        for k in range(m):
            if arr[i][j][k]==1:
                q.append((i,j,k))
bfs()

check=False
day=0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if arr[i][j][k]==0:
                check=True
            day=max(day,arr[i][j][k])
if check==True:
    print(-1)
else:
    print(day-1)
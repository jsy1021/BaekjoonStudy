import sys
sys.setrecursionlimit(10**5)
input=sys.stdin.readline

dx=[0,0,-1,1]
dy=[1,-1,0,0]

def dfs(x,y,count):
    global ans
    ans=max(ans,count)

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0<=nx<r and 0<=ny<c and visited[ord(arr[nx][ny])-65]==0:
            visited[ord(arr[nx][ny])-65]=1
            dfs(nx,ny,count+1)
            visited[ord(arr[nx][ny])-65]=0
r, c=map(int,input().split())
arr=[list(input())for _ in range(r)]
ans=1
visited = [0] * 26
visited[ord(arr[0][0])-65] = 1
dfs(0,0,1)
print(ans)
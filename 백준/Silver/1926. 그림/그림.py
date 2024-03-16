from collections import deque
def bfs(x,y):
    arr[x][y]=0
    q = deque()
    q.append((x, y))
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    cnt = 1
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if (0 <= nx < N) and (0 <= ny < M) and arr[nx][ny] == 1:
                arr[nx][ny] = 0
                q.append((nx, ny))
                cnt += 1
    return cnt


N,M=map(int,input().split())
arr=[]
for _ in range(N):
    arr.append(list(map(int,input().split())))
count=0
ans=0
for i in range(N):
    for j in range(M):
        if arr[i][j]==1:
            count+=1
            ans=max(bfs(i,j),ans)
print(count)
print(ans)
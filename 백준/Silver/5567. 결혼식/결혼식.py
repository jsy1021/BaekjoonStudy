import sys
from collections import deque
input=sys.stdin.readline

N=int(input())
M=int(input())
graph = [ [0] * (N+1) for _ in range(N+1)]
visited = [0 for _ in range(N+1)]

for _ in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(x):
    queue=deque()
    visited[x]=1
    queue.append(x)
    while queue:
        a=queue.popleft()
        for i in graph[a]:
            if visited[i]==0:
                visited[i]=visited[a]+1
                queue.append(i)

bfs(1)
result=0
for i in range(2,N+1):
    if visited[i]<4 and visited[i]!=0:
        result+=1
print(result)

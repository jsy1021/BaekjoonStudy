import sys
from collections import deque
input=sys.stdin.readline
def bfs(a,b):
    queue=deque()
    visited=[0]*(N+1)

    queue.append(a)
    visited[a]=1

    while queue:
        now=queue.popleft()

        if now==b:
            return visited[b]-1

        for n in graph[now]:
            if not visited[n]:
                queue.append(n)
                visited[n]+=visited[now]+1

    return -1
N=int(input())
a,b=map(int,input().split())
M=int(input())

graph=[[] for _ in range(N+1)]

for _ in range(M):
    x,y=map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

ans=bfs(a,b)
print(ans)
    
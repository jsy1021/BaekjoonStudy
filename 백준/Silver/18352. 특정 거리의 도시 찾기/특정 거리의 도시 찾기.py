from collections import deque
import sys
input=sys.stdin.readline
N, M, K, X=map(int,input().split())
graph=[[]for _ in range(N+1)]
for _ in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)

dis=[0 for _ in range(N+1)]
visited=[0 for _ in range(N+1)]

queue=deque([X])
visited[X]=1
while queue:
    now=queue.popleft()
    for i in graph[now]:
        if visited[i]==0:
            queue.append(i)
            visited[i]=1
            dis[i]=dis[now]+1
check=0
for i in range(1,N+1):
    if dis[i]==K:
        print(i)
        check+=1
if check==0:
    print(-1)

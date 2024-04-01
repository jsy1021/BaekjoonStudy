import sys
from collections import deque
input=sys.stdin.readline

N,M=map(int,input().split())
graph=[[] for _ in range(N+1)]
for _ in range(M):
    a,b=map(int,input().split())
    graph[b].append(a)

def bfs(node):
    queue=deque([node])
    count=0

    visited=[False] *(N+1)
    visited[node]=True

    while queue:
        now=queue.popleft()
        for i in graph[now]:
            if visited[i]==False:
                visited[i]=True
                queue.append(i)
                count+=1
    return count
result=[]
for start in range(1, N+1):
    result.append(bfs(start))

for i in range(len(result)):
    if max(result)==result[i]:
        print(i+1,end=' ')
        
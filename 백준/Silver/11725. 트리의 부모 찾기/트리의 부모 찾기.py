import sys
from collections import deque

input=sys.stdin.readline
N=int(input())
graph=[[]for i in range(N+1)]
ans=[0]*(N+1)
for _ in range(N-1):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

queue=deque()
queue.append(1)

def bfs():
    while queue:
        now=queue.popleft()
        for next in graph[now]:
            if ans[next]==0:
                ans[next]=now
                queue.append(next)
bfs()
print(*ans[2:],sep="\n")

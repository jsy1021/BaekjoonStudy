import sys
from collections import deque
input=sys.stdin.readline

def bfs(start):
    queue=deque()
    global count
    queue.append(start)
    visited[start]=count
    while queue:
        now_node=queue.popleft()
        for next_node in sorted(graph[now_node]):
            if visited[next_node]==0:
                count+=1
                visited[next_node]=count
                queue.append(next_node)


n,m,r=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[0]*(n+1)
count=1
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(r)
for i in visited[1:]:
    print(i)
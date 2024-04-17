from collections import deque
import sys
input=sys.stdin.readline
n,m,r=map(int,input().split())
graph=[[] for _ in range(n+1)]
visited=[-1]*(n+1)
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def bfs(start_node):
    queue=deque()
    queue.append(start_node)
    visited[start_node]=0
    while queue:
        now=queue.popleft()
        for next_node in graph[now]:
            if visited[next_node]==-1:
                visited[next_node]=visited[now]+1
                queue.append(next_node)
bfs(r)
for i in visited[1:]:
    print(i)

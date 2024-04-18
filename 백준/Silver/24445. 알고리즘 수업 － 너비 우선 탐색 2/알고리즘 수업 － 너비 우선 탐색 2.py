import sys
from collections import deque
input=sys.stdin.readline

def bfs(start_node):
    global count
    queue=deque()
    queue.append(start_node)
    visited[start_node]=1
    while queue:
       now_node=queue.popleft()
       graph[now_node].sort(reverse=True)
       for search_node in graph[now_node]:
          if visited[search_node]==0:
             count+=1
             visited[search_node]=count
             queue.append(search_node)
          

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
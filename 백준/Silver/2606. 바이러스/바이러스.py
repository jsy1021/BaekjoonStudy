from collections import deque

V=int(input())
E=int(input())
graph=[[] for _ in range(V+1)]
visited=[False for _ in range(V+1)]
for _ in range(E):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(x):
    deq=deque([x])
    count=0
    visited[x]=True
    while deq:
        node=deq.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node]=True
                deq.append(next_node)
                count+=1
    return count
print(bfs(1))

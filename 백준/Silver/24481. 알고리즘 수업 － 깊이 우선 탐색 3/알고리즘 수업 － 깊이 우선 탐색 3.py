import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline
N,M,R=map(int,input().split())
graph=[[]for _ in range(N+1)]
visited=[-1]*(N+1)
depth=0

for _ in range(M):
    a, b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    graph[i].sort()

def dfs(r,depth):
    visited[r]=depth
    for i in graph[r]:
        if visited[i]==-1:
            dfs(i,depth+1)
    return

dfs(R,0)

for i in visited[1:]:
    print(i)

import sys
sys.setrecursionlimit(10 ** 8)
input=sys.stdin.readline

N, M, R=map(int,input().split())
graph=[[]*(N+1)for _ in range(N+1)]
visited=[False]*(N+1)
answer = [0] * (N+1)
count=1
def dfs(x):
    global count
    visited[x]=True
    answer[x]=count
    for i in graph[x]:
        if visited[i]==False:
            count+=1
            dfs(i)

for _ in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,N+1):
    graph[i].sort(reverse=True)

dfs(R)

for i in answer[1:]:
    if i==0:
        print(0)
    else:
        print(i)
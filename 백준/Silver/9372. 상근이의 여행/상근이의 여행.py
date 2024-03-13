import sys
input=sys.stdin.readline

def solve(start,count):
    visited[start]=True
    
    for next in graph[start]:
        if visited[next]==False:
            count=solve(next,count+1)
    return count

T=int(input())
for _ in range(T):
    N, M=map(int,input().split())
    graph=[[] for _ in range(N+1)]
    visited=[False for _ in range(N+1)]
    visited[0]=True
    for _ in range(M):
        a,b=map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    ans=solve(1,0)
    print(ans)        

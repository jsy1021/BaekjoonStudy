import sys
input = sys.stdin.readline

N,M,R=map(int,input().split())
graph=[[] for _ in range(N+1)]
visited=[False]*(N+1)
result=[0]*(N+1)
for _ in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,len(graph)):
    graph[i].sort(reverse=True)

def DFS(start):
    stack=[start]
    count=1

    while stack:
        now=stack.pop()

        if visited[now]==True:
            continue
        visited[now]=True

        result[now]=count
        count+=1
        for adj_node in graph[now]:
            if visited[adj_node]==False:
                stack.append(adj_node)
    return result
result=DFS(R)
print(*result[1:],sep="\n")
    
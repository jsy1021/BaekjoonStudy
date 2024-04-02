import sys
import heapq
input=sys.stdin.readline

INF=int(1e8)

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dis, now_node=heapq.heappop(q)

        if distance[now_node]<dis:
            continue

        for i in graph[now_node]:
            cost=dis+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

N,M=map(int,input().split())
start=int(input())
graph=[[] for _ in range(N+1)]
distance=[INF]*(N+1)


for _ in range(M):
    u,v,w=map(int,input().split())
    graph[u].append((v,w))

dijkstra(start)

for i in range(1,N+1):
    if distance[i]==INF:
        print("INF")
    else:
        print(distance[i])

        
import sys
from collections import deque
input=sys.stdin.readline

def bfs():
    q=deque()
    q.append(N)
    while q:
        now=q.popleft()
        if now==K:
            print(dis[now])
            break
        for nx in (now-1,now+1,now*2):
            if 0<=nx<=MAX and not dis[nx]:
                dis[nx]=dis[now]+1
                q.append(nx)
N, K=map(int,input().split())

MAX=10**5
dis=[0]*(MAX+1)
bfs()


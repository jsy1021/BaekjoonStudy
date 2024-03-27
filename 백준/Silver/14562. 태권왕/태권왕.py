import sys
from collections import deque
input=sys.stdin.readline

def bfs(s,t):
    C=0
    queue=deque()
    queue.append([s,t,C])
    while queue:
        now_s, now_t,cnt=queue.popleft()
        if now_s<now_t:
            queue.append([now_s*2,now_t+3,cnt+1])
            queue.append([now_s+1,now_t,cnt+1])
        elif now_s==now_t:
            print(cnt)
            break

c=int(input())
for _ in range(c):
    s,t=map(int,input().split())
    bfs(s,t)
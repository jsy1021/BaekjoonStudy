import sys
import heapq as hq
input=sys.stdin.readline
N=int(input())
heap=[]
for _ in range(N):
    X=int(input())
    if X>0:
        hq.heappush(heap,(-X,X))
        
    else:
        if len(heap)>=1:
            print(hq.heappop(heap)[1])
        else:
            print(0)
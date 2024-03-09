from collections import deque
A, B=map(int,input().split())

q=deque()
q.append((A,1))

while q:
    now, count=q.popleft()
    
    if now >B:
        continue
    if now ==B:
        print(count)
        break
    q.append((now*2,count+1))
    q.append((int(str(now)+"1"),count+1))
else:
    print(-1)
    
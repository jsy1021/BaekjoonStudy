import sys
input = sys.stdin.readline
N, M=map(int , input().split())
set1=set()

count=0
for i in range(N):
    s=input().rstrip()
    set1.add(s)
for j in range(M):
    s=input().rstrip()
    if s in set1:
        count+=1
print(count)

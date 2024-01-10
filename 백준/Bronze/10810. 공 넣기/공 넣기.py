# 백준 10810
N, M=map(int,input().split())
x=[0]*N

for _ in range(M):
    i, j, k=map(int, input().split())
    for w in range(i,j+1):
        x[w-1]=k
for i in range(N):
    print(f"{x[i]} ",end='')


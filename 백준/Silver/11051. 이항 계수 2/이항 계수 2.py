N, K=map(int, input().split())
p=[0]
for depth in range(2, N+2):
    p.append([0]*depth)
p[1]=[1,1]

for depth in range(2,N):
    p[depth][0]=1 #처음 값 1로 처리
    for idx in range(1, depth):
      p[depth][idx]=(p[depth-1][idx-1]+p[depth-1][idx])%10007
    p[depth][-1]=1 #마지막 값 1로 처리
if K==0 or K==N:
   print(1)
else:
   print((p[N-1][K-1]+p[N-1][K])%10007)  